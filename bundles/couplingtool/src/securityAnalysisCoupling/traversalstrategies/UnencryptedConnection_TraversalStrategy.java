package securityAnalysisCoupling.traversalstrategies;

import java.util.Collection;
import java.util.HashSet;

import architecture.PCM.EdgeLinkCorrespondence;
import edu.kit.kastel.sdq.coupling.models.couplinggraph.CouplingGraph;
import edu.kit.kastel.sdq.coupling.models.couplinggraph.Edge;
import edu.kit.kastel.sdq.coupling.models.couplinggraph.Node;
import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.Weakness;
import utils.CorrespondenceUtil;

public class UnencryptedConnection_TraversalStrategy extends TraversalStrategy {

	public UnencryptedConnection_TraversalStrategy(CouplingGraph graph, Collection<EdgeLinkCorrespondence> correspondences) {
		super(graph, correspondences);
	}

	@Override
	public Collection<Edge> findViolations(Node nodeWithWeakness, Weakness unencryptedConnectionWeakness) {
		Collection<Edge> violatedEdges = new HashSet<Edge>();
		findViolationsForEdgeRecursive(nodeWithWeakness, unencryptedConnectionWeakness, violatedEdges);
		
		System.out.println("Original Node %s.%s violated by weakness %s".formatted(nodeWithWeakness.getClassName(), nodeWithWeakness.getMethodName(), unencryptedConnectionWeakness.getName()));
		violatedEdges.stream().forEach(edge -> System.out.println("%s.%s --unencryptedconnection-> %s.%s".formatted(edge.getSource().getClassName(), edge.getSource().getMethodName(), edge.getDestination().getClassName(), edge.getDestination().getMethodName())));
		
		
		return violatedEdges;
	}


	private void findViolationsForEdgeRecursive(Node node, Weakness weakness, Collection<Edge> violatedEdges) {

		
		Collection<Edge> edgesWithNodeAsSource = getEdgesForNodeAsSrc(node);

		for (Edge edge : edgesWithNodeAsSource) {
			
			Collection<EdgeLinkCorrespondence> correspondences = CorrespondenceUtil.getCorrespondencesForEdge(edge, super.correspondences);
			
			if(edge.getSecurityCharacteristics().stream().anyMatch(characteristic -> weakness.getViolates().contains(characteristic))) {
				violatedEdges.add(edge);
			}
			
			if(correspondences.isEmpty()) {
				findViolationsForEdgeRecursive(edge.getDestination(), weakness, violatedEdges);
			}
		}
	}
	
}
