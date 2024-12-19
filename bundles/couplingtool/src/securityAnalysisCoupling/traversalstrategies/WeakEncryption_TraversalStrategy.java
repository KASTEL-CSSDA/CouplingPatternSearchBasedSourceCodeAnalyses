package securityAnalysisCoupling.traversalstrategies;

import java.util.Collection;

import edu.kit.kastel.sdq.coupling.models.couplinggraph.CouplingGraph;
import edu.kit.kastel.sdq.coupling.models.couplinggraph.Edge;
import edu.kit.kastel.sdq.coupling.models.couplinggraph.Node;

public class WeakEncryption_TraversalStrategy extends TraversalStrategy{

	public WeakEncryption_TraversalStrategy(CouplingGraph graph) {
		super(graph);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Collection<Edge> findViolations(Node nodeWithWeakness) {
		// TODO Auto-generated method stub
		return null;
	}

}
