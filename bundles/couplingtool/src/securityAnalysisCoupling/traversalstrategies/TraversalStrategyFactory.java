package securityAnalysisCoupling.traversalstrategies;

import com.google.common.graph.Graph;

import edu.kit.kastel.sdq.coupling.models.couplinggraph.CouplingGraph;

public class TraversalStrategyFactory {

	
public static TraversalStrategy getTraversalStrategy(String weaknessName, CouplingGraph graph) {
		switch (weaknessName) {
		case "unencrypted_connection":
			return new UnencryptedConnection_TraversalStrategy(graph);
		case "weak_encryption":
			return new WeakEncryption_TraversalStrategy(graph);
		default:
			return null;
		}
	}
}
