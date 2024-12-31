package securityAnalysisCoupling.traversalstrategies;

import java.util.Collection;
import java.util.stream.Collectors;

import architecture.PCM.EdgeLinkCorrespondence;
import edu.kit.kastel.sdq.coupling.models.couplinggraph.CouplingGraph;
import edu.kit.kastel.sdq.coupling.models.couplinggraph.Edge;
import edu.kit.kastel.sdq.coupling.models.couplinggraph.Node;
import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.Weakness;

public abstract class TraversalStrategy {

	protected final CouplingGraph graph;
	protected final Collection<EdgeLinkCorrespondence> correspondences;
	
	public TraversalStrategy(CouplingGraph graph, Collection<EdgeLinkCorrespondence> correspondences) {
		this.graph = graph;
		this.correspondences = correspondences;
	}
	
	
	public abstract Collection<Edge> findViolations(Node nodeWithWeakness, Weakness unencryptedConnectionWeakness);
	
	protected Collection<Edge> getEdgesForNodeAsSrc(Node node){
		return graph.getEdges().stream().filter(edge -> edge.getSource().equals(node)).collect(Collectors.toList());
	}
	

}
