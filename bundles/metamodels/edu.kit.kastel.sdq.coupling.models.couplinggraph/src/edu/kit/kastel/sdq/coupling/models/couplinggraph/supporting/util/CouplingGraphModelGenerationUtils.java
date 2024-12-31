package edu.kit.kastel.sdq.coupling.models.couplinggraph.supporting.util;

import java.util.Optional;

import edu.kit.kastel.sdq.coupling.models.couplinggraph.CouplingGraph;
import edu.kit.kastel.sdq.coupling.models.couplinggraph.CouplinggraphFactory;
import edu.kit.kastel.sdq.coupling.models.couplinggraph.Edge;
import edu.kit.kastel.sdq.coupling.models.couplinggraph.Node;

public class CouplingGraphModelGenerationUtils {
	public static CouplingGraph generateGraph() {

		CouplingGraph graph = CouplinggraphFactory.eINSTANCE.createCouplingGraph();
		return graph;
	}

	public static Node generateNode() {

		Node node = CouplinggraphFactory.eINSTANCE.createNode();
		return node;
	}

	public static Edge generateEdge() {
		return CouplinggraphFactory.eINSTANCE.createEdge();
	}
	
	
	public static Node getOrCreateNode(String className, String methodName, CouplingGraph graph) {
		Optional<Node> searchedNode = graph.getNodes().stream().filter(node -> node.getClassName().equals(className) && node.getMethodName().equals(methodName)).findFirst();
		
	
		if(searchedNode.isPresent()) {
			return searchedNode.get();
		} else {
			Node methodNode = CouplingGraphModelGenerationUtils.generateNode();
			methodNode.setClassName(className);
			methodNode.setMethodName(methodName);
			return methodNode;
		}
	}
}
