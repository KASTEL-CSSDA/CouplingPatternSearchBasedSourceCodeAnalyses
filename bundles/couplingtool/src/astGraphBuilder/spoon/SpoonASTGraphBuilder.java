package astGraphBuilder.spoon;

import spoon.reflect.visitor.CtScanner;
import spoon.reflect.visitor.filter.TypeFilter;
import spoon.Launcher;
import spoon.reflect.code.CtInvocation;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtInterface;
import spoon.reflect.declaration.CtMethod;
import java.util.List;
import java.util.Optional;
import astGraphBuilder.ASTGraphBuilder;
import edu.kit.kastel.sdq.coupling.models.couplinggraph.CouplingGraph;
import edu.kit.kastel.sdq.coupling.models.couplinggraph.Edge;
import edu.kit.kastel.sdq.coupling.models.couplinggraph.Node;
import edu.kit.kastel.sdq.coupling.models.couplinggraph.supporting.util.CouplingGraphModelGenerationUtils;

/**
 * AST Scanner that builds the call graph with securityProperty annotation.
 */
public class SpoonASTGraphBuilder extends CtScanner implements ASTGraphBuilder {
	private CouplingGraph graph;
	private final String sourceCodeFile;

	public SpoonASTGraphBuilder(String sourceCodeFile) {
		this.graph = CouplingGraphModelGenerationUtils.generateGraph();
		this.sourceCodeFile = sourceCodeFile;
	}

	/**
	 * Traverses the given AST element and builds the call graph.
	 * 
	 * @param element The AST element to be traversed.
	 */
	@Override
	public void scan(CtElement element) {
		element.accept(this);
	}

	/**
	 * Visits a class in the AST and processes its methods.
	 * 
	 * @param visitedClass The visited class.
	 */
	@Override
	public <T> void visitCtClass(CtClass<T> visitedClass) {
		for (CtMethod<?> method : visitedClass.getMethods()) {
			method.accept(this);
		}
	}

	/**
	 * Visits a method in the AST and processes its method invocations.
	 * 
	 * @param visitedMethod The visited method.
	 */
	@Override
	public <T> void visitCtMethod(CtMethod<T> visitedMethod) {
		if(visitedMethod.getParent() instanceof CtInterface) {
			return;
		}
		String className = visitedMethod.getParent(CtClass.class).getQualifiedName();
		String methodName = visitedMethod.getSimpleName();
		
		if(className.contains("Main")) {
			return;
		}
		Node methodNode = getOrCreateAndAddNode(className, methodName);

		for (CtInvocation<?> invocation : visitedMethod.getElements(new TypeFilter<>(CtInvocation.class))) {
			String invocedMethodName = invocation.getExecutable().getSimpleName();
			String invocedClassName = invocation.getExecutable().getDeclaringType().getQualifiedName();
			if(invocedClassName.startsWith("java.")) {
				continue;
			}
			Node invocationNode = getOrCreateAndAddNode(invocedClassName, invocedMethodName);

			Edge edge = CouplingGraphModelGenerationUtils.generateEdge();
			edge.setSource(methodNode);
			edge.setDestination(invocationNode);
			graph.getEdges().add(edge);
			

		}
	}

	/**
	 * Finds and returns the calling edge (source node to target node) in the graph
	 * for the given called method name. If an edge with the specified called method
	 * name is found, it is wrapped in an Optional and returned. Otherwise, an empty
	 * Optional is returned to indicate that no such edge was found.
	 *
	 * @param calledMethod The name of the called method to search for.
	 * @return An Optional containing the calling edge if found, or an empty
	 *         Optional if no such edge was found.
	 */
	@Override
	public Optional<Edge> getEdgeForCalledMethod(String calledMethod) {
		for (Edge edge : graph.getEdges()) {
			Node calledNode = edge.getDestination();

			if (calledNode.getMethodName().equals(calledMethod)) {
				return Optional.of(edge);
			}
		}
		return Optional.empty();
	}

	/**
	 * Creates the AST using the Spoon framework.
	 */
	@Override
	public void buildASTGraph() {
		Launcher launcher = initLauncher();
		launcher.getModel().getRootPackage().accept(this);
	}

	/**
	 * Initializes the Spoon Launcher for building the AST model. SourceCodeFilePath
	 * as InputResource.
	 *
	 * @return The initialized Spoon Launcher.
	 */
	private Launcher initLauncher() {
		Launcher launcher = new Launcher();
		launcher.addInputResource(this.sourceCodeFile);
		launcher.getEnvironment().setComplianceLevel(8);
		launcher.buildModel();
		return launcher;
	}

	@Override
	public CouplingGraph getGraph() {
		return graph;
	}

	public List<Node> getMethodNodes() {
		return graph.getNodes();
	}

	public List<Edge> getEdges() {
		return graph.getEdges();
	}
	
	private Node getOrCreateAndAddNode(String className, String methodName) {
		Optional<Node> searchedNode = graph.getNodes().stream().filter(node -> node.getClassName().equals(className) && node.getMethodName().equals(methodName)).findFirst();
		
	
		if(searchedNode.isPresent()) {
			return searchedNode.get();
		} else {
			Node methodNode = CouplingGraphModelGenerationUtils.generateNode();
			methodNode.setClassName(className);
			methodNode.setMethodName(methodName);
			
			graph.getNodes().add(methodNode);
			
			return methodNode;
		}
	}
}
