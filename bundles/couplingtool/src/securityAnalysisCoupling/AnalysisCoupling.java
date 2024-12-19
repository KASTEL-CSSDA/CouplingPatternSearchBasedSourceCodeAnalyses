package securityAnalysisCoupling;

import java.util.List;
import java.util.Optional;
import architecture.ArchitectureGraphAnnotator;
import astGraphBuilder.ASTGraphBuilder;
import edu.kit.kastel.sdq.coupling.models.couplinggraph.CouplingGraph;
import edu.kit.kastel.sdq.coupling.models.couplinggraph.Edge;
import edu.kit.kastel.sdq.coupling.models.couplinggraph.Node;
import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.SecurityCharacteristic;
import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.Weakness;
import exceptions.GenerationException;
import exceptions.InputException;
import exceptions.PatternViolationClassException;
import sourceCodeAnalysis.AbstractResult;
import sourceCodeAnalysis.CodeAnalysis;
import sourceCodeAnalysis.PatternWeaknessMapper;

/**
 * This class performs security coupling analysis based on provided source code, a tool for identifying pattern violations, and loaded model files.
 * It follows these steps:
 * 
 * 1. Identifies pattern violations using the specified tool.
 * 2. Generates an Abstract Syntax Tree (AST) from the source code.
 * 3. Annotates the graph with security properties from the architectural domain using an interface.
 * 4. Adds pattern violations to the graph based on the tool results.
 * 5. Constructs violated security properties based on the annotated security properties on the edges and the pattern violations mapped in the nodes.
 */
public class AnalysisCoupling {
	private CodeAnalysis tool;
	private PatternWeaknessMapper resultMapper;
	private ASTGraphBuilder graphBuilder;
	private CouplingGraph graph;
	private ArchitectureGraphAnnotator archGraphAnnotator;

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
	 * @param graphBuilder       The builder for generating the Abstract Syntax Tree
	 *                           (AST) graph.
	 * 
	 */
	public AnalysisCoupling(CodeAnalysis tool, PatternWeaknessMapper resultMapper, String sourceCodeFilePath,
			ASTGraphBuilder graphBuilder, ArchitectureGraphAnnotator archGraphAnnotator) {

		this.tool = tool;
		this.resultMapper = resultMapper;
		this.graphBuilder = graphBuilder;
		this.archGraphAnnotator = archGraphAnnotator;
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
	public void runSecurityCouplingAnalysis(String sourceCodeFilePath)
			throws GenerationException, PatternViolationClassException, InputException {
		
		graphBuilder.buildASTGraph();
		graph = graphBuilder.getGraph();
		archGraphAnnotator.annotateGraph(graph);
		
		List<AbstractResult> toolResults = tool.runCodeAnalysis(sourceCodeFilePath, resultMapper);

		//addPatternViolationsToGraph(toolResults, graphBuilder);
		buildViolatedSecurityProperties();
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
	private void addWeaknessesToGraph(List<AbstractResult> toolResults, ASTGraphBuilder graphBuilder)
			throws GenerationException, InputException, PatternViolationClassException {
		for (AbstractResult currResult : toolResults) {

			Optional<Edge> EdgeOptional = graphBuilder.getEdgeForCalledMethod(currResult.getMethodName());
			if (EdgeOptional.isPresent()) {
				Edge edge = EdgeOptional.get();

				assignWeaknessToNode(edge, currResult);
			}
		}
	}

	/**
	 * Creates and assigns a pattern violation to a node.
	 *
	 * @param edge       The graph edge.
	 * @param toolResult The Tool result.
	 * @throws PatternViolationClassException If a wrong pattern violation name is
	 *                                        mapped.
	 * @throws GenerationException            If the PatternViolationType is not
	 *                                        found in the model. This should only
	 *                                        happen in case of an error in the
	 *                                        model instance.
	 * @throws InputException                 If an input exception occurs during
	 *                                        analysis.
	 */
	private void assignWeaknessToNode(Edge edge, AbstractResult toolResult)
			throws PatternViolationClassException, GenerationException, InputException {
		
//		IdentifiedVulnerability vulnerability = CouplingGraphPatternViolationModelGenerator.generateIdentifiedVulnerability();
//		int startCodeLine = toolResult.getStartCodeLine();
//		int endCodeLine = toolResult.getEndCodeLine();
//		vulnerability.setStart(startCodeLine);
//		if (isMoreThanOneCodeLine(startCodeLine, endCodeLine)) {
//			vulnerability.setEnd(endCodeLine);
//		}
//		vulnerability.setMethodName(toolResult.getMethodName());
//		vulnerability.setClassName(toolResult.getClassName());
//		
//		PatternViolationType patternViolationType = resultMapper
//				.mapToolPatternViolationName(toolResult.getViolatedClass());
//		vulnerability.setVulnerabilityType(patternViolationType);
//		Node calledNode = edge.getDestination();
//		calledNode.getDetectedVulnerability().add(vulnerability);

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

	/**
	 * Builds violated security properties for edges in the graph.
	 *
	 * This method iterates through all the edges in the graph and processes pattern
	 * violations associated with their source and destination nodes. It calls the
	 * 'processPatternViolations' method for both the source and destination nodes,
	 * passing the edge as a parameter to identify the relationship.
	 */
	private void buildViolatedSecurityProperties() {

		for (Edge edge : graph.getEdges()) {
			Node srcNode = edge.getSource();
			Node dstNode = edge.getDestination();

			processPatternViolations(srcNode, edge);
			processPatternViolations(dstNode, edge);
		}
	}

	/**
	 * Processes pattern violations for a specific node and edge combination.
	 *
	 * This method analyzes the security properties by the given edge in relation to
	 * the node's associated pattern violations. For each security property, it
	 * checks if a corresponding violated property exists within the node's pattern
	 * violations, adding it to the violation list when found.
	 *
	 * @param node The node for which pattern violations are examined.
	 * @param edge The edge that contains security properties to be checked.
	 */
	private void processPatternViolations(Node node, Edge edge) {
		for (SecurityCharacteristic securityCharacteristic : edge.getSecurityCharacteristics()) {
			for (Weakness weakness : node.getWeaknesses()) {
				if (weakness.getViolates().equals(securityCharacteristic)) {

				}
			}
		}
	}
}
