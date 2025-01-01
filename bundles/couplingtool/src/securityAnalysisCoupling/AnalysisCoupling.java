package securityAnalysisCoupling;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import architecture.ArchitectureGraphAnnotator;
import architecture.PCM.EdgeLinkCorrespondence;
import architecture.PCM.InputModelsAccessAnalysis;
import architecture.PCM.backtransformation.UnencryptedConnectionBacktransformationStrategy;
import astGraphBuilder.ASTGraphBuilder;
import edu.kit.kastel.sdq.coupling.models.couplinggraph.CouplingGraph;
import edu.kit.kastel.sdq.coupling.models.couplinggraph.Edge;
import edu.kit.kastel.sdq.coupling.models.couplinggraph.Node;
import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.SecurityCharacteristic;
import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.Weakness;
import exceptions.GenerationException;
import exceptions.InputException;
import exceptions.PatternViolationClassException;
import securityAnalysisCoupling.traversalstrategies.TraversalStrategy;
import securityAnalysisCoupling.traversalstrategies.TraversalStrategyFactory;
import sourceCodeAnalysis.AbstractResult;
import sourceCodeAnalysis.CodeAnalysis;
import sourceCodeAnalysis.PatternWeaknessMapper;
import utils.CorrespondenceUtil;

/**
 * This class performs security coupling analysis based on provided source code,
 * a tool for identifying pattern violations, and loaded model files. It follows
 * these steps:
 * 
 * 1. Identifies pattern violations using the specified tool. 2. Generates an
 * Abstract Syntax Tree (AST) from the source code. 3. Annotates the graph with
 * security properties from the architectural domain using an interface. 4. Adds
 * pattern violations to the graph based on the tool results. 5. Constructs
 * violated security properties based on the annotated security properties on
 * the edges and the pattern violations mapped in the nodes.
 */
public class AnalysisCoupling {
	private CodeAnalysis tool;
	private PatternWeaknessMapper resultMapper;
	private ASTGraphBuilder graphBuilder;
	private CouplingGraph graph;
	private ArchitectureGraphAnnotator archGraphAnnotator;
	private BacktransformationFactory backTransformationFactory;

	/**
	 * Constructs a new SecurityCouplingAnalysis object.
	 *
	 * @param tool               The code analysis tool used for identifying pattern
	 *                           violations.
	 * @param resultMapper       The pattern violation mapper to map tool results to
	 *                           pattern violations.
	 * @param modelGenerator     The generator for coupling graph pattern violation
	 *                           models.
	 * @param sourceCodeFilePath The file path to the source code to be
	 * 
	 * @param graphBuilder       The builder for generating the nullAbstract Syntax
	 *                           Tree (AST) graph.
	 * 
	 */
	public AnalysisCoupling(CodeAnalysis tool, PatternWeaknessMapper resultMapper, String sourceCodeFilePath,
			ASTGraphBuilder graphBuilder, ArchitectureGraphAnnotator archGraphAnnotator,
			BacktransformationFactory backTransformationFactory) {

		this.tool = tool;
		this.resultMapper = resultMapper;
		this.graphBuilder = graphBuilder;
		this.archGraphAnnotator = archGraphAnnotator;
		this.backTransformationFactory = backTransformationFactory;
	}

	/**
	 * Runs the security coupling analysis on the specified source code file.
	 *
	 * @param sourceCodeFilePath The path to the source code file to analyze.
	 * @throws GenerationException            If the PatternViolationType is not
	 *                                        found in the model. This should only
	 *                                        happen in case of an error in the
	 *                                        model instance.
	 * @throws PatternViolationClassException If a wrong pattern violation name is
	 *                                        mapped.
	 * @throws InputException                 If an input exception occurs during
	 *                                        analysis.
	 */
	public void runSecurityCouplingAnalysis(String sourceCodeFilePath, String sourceCodeAnalysisOutputLocation)
			throws GenerationException, PatternViolationClassException, InputException {

		graphBuilder.buildASTGraph();
		graph = graphBuilder.getGraph();
		archGraphAnnotator.annotateGraph(graph);

		List<AbstractResult> toolResults = tool.runCodeAnalysis(sourceCodeFilePath, resultMapper,
				sourceCodeAnalysisOutputLocation);
		addWeaknessesToGraph(toolResults);
		performViolationCalculation();
	}

	/**
	 * Adds pattern violations to the graph based on tool results.
	 *
	 * This method takes a list of tool results and an AST graph builder as input.
	 * It iterates through the tool results and associates pattern violations with
	 * graph nodes based on the called methods. If a corresponding edge is found in
	 * the graph, it links the tool result to the edge's source or destination node.
	 *
	 * @param toolResults  The list of tool results to be used for adding pattern
	 *                     violations.
	 * @param graphBuilder The AST graph builder used to construct the graph.
	 * @throws GenerationException            If an error occurs during the
	 *                                        generation process.
	 * @throws InputException                 If there is an issue with the input
	 *                                        data.
	 * @throws PatternViolationClassException If a wrong pattern violation name is
	 *                                        mapped.
	 */
	private void addWeaknessesToGraph(List<AbstractResult> toolResults)
			throws GenerationException, InputException, PatternViolationClassException {
		for (AbstractResult currResult : toolResults) {
			
			
			if(currResult.getMethodName().isEmpty()) {
				addWeaknessToGraphCodeLineBased(currResult);
			} else {
				addWeaknessToGraphMethodNameBased(currResult);
			}

			
		}
	}

	private void addWeaknessToGraphCodeLineBased(AbstractResult currResult) {
		
		Node targetNode = null;
		
		//find direkt node 
		//currently we do not handle "inner call" nodes, so disabled
		for(Node node : graph.getNodes()) {
			if(node.getClassName().equals(currResult.getClassName()) && node.getStartLine() == currResult.getStartCodeLine() && node.getEndLine() == currResult.getEndCodeLine()) {
				targetNode = node;
				break;
			}
		}
		
		//find enclosing node
		if(targetNode == null) {
			for(Node node : graph.getNodes()) {
				if(node.getClassName().equals(currResult.getClassName()) && node.getStartLine() < currResult.getStartCodeLine() && node.getEndLine() > currResult.getEndCodeLine()) {
					targetNode = node;
					break;
				}
			}
		}
		
		if(targetNode != null) {
			addWeaknessToNode(targetNode, currResult.getWeakness());
		}
		
	}

	private void addWeaknessToGraphMethodNameBased(AbstractResult currResult) {
		for (Node node : graph.getNodes()) {

			if (node.getClassName().equals(currResult.getClassName())
					&& node.getMethodName().equals(currResult.getMethodName())) {

				addWeaknessToNode(node, currResult.getWeakness());
				
				break;
			}

		}
	}
	
	private void addWeaknessToNode(Node node, Weakness weakness) {
		if (!node.getWeaknesses().contains(weakness)) {
			System.out.println("Added Weakness To Node: %s to %s.%s".formatted(weakness.getName(), node.getClassName(), node.getMethodName()));
			node.getWeaknesses().add(weakness);
		}
	}

	private void performViolationCalculation() {

		Collection<Node> nodesWithWeaknesses = graph.getNodes().stream().filter(node -> !node.getWeaknesses().isEmpty())
				.collect(Collectors.toSet());

		for (Node nodeWithWeakness : nodesWithWeaknesses) {
			for (Weakness weakness : nodeWithWeakness.getWeaknesses()) {

				TraversalStrategy traversal = TraversalStrategyFactory.getTraversalStrategy(weakness, graph,
						archGraphAnnotator.getEdgeLinkCorrespondence());

				Collection<Edge> violatedEdgesForNodeAndWeakness = traversal.findViolations(nodeWithWeakness, weakness);

				for (Edge edge : violatedEdgesForNodeAndWeakness) {
					Collection<EdgeLinkCorrespondence> fittingCorrespondences = CorrespondenceUtil
							.getCorrespondencesForEdge(edge, archGraphAnnotator.getEdgeLinkCorrespondence());

					for (EdgeLinkCorrespondence correspondence : fittingCorrespondences) {

						performBacktransformation(weakness, correspondence);

					}
				}

			}
		}

	}

	private void performBacktransformation(Weakness weakness, EdgeLinkCorrespondence correspondence) {
		BacktransformationStrategy strategy = backTransformationFactory.createStrategy(weakness);

		strategy.transformWeaknessForCorrespondence(weakness, correspondence);

	}

	/**
	 * Check if there is more than one code line by verifying whether 'start' is
	 * less than 'end'
	 *
	 * @param start The starting position of the code line.
	 * @param end   The ending position of the code line.
	 * @return true if 'start' is less than 'end', false otherwise.
	 */
	private boolean isMoreThanOneCodeLine(int start, int end) {
		return start < end;
	}

}
