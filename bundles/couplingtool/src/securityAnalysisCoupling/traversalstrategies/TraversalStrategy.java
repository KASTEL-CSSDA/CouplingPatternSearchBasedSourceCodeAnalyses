package securityAnalysisCoupling.traversalstrategies;

import java.util.Collection;

import edu.kit.kastel.sdq.coupling.models.couplinggraph.CouplingGraph;
import edu.kit.kastel.sdq.coupling.models.couplinggraph.Edge;
import edu.kit.kastel.sdq.coupling.models.couplinggraph.Node;

public abstract class TraversalStrategy {

	protected final CouplingGraph graph;
	
	public TraversalStrategy(CouplingGraph graph) {
		this.graph = graph;
	}
	
	
	public abstract Collection<Edge> findViolations(Node nodeWithWeakness);
}
