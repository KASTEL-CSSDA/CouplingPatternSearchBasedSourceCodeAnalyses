package securityAnalysisCoupling.traversalstrategies;

import java.util.Collection;

import edu.kit.kastel.sdq.coupling.models.couplinggraph.CouplingGraph;
import edu.kit.kastel.sdq.coupling.models.couplinggraph.Edge;
import edu.kit.kastel.sdq.coupling.models.couplinggraph.Node;

public class UnencryptedConnection_TraversalStrategy extends TraversalStrategy {

	public UnencryptedConnection_TraversalStrategy(CouplingGraph graph) {
		super(graph);
	}

	@Override
	public Collection<Edge> findViolations(Node nodeWithWeakness) {
		// TODO Auto-generated method stub
		return null;
	}

}
