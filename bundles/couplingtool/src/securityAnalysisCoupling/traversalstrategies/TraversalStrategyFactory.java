package securityAnalysisCoupling.traversalstrategies;

import java.util.Collection;

import architecture.PCM.EdgeLinkCorrespondence;
import edu.kit.kastel.sdq.coupling.models.couplinggraph.CouplingGraph;
import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.Weakness;

public class TraversalStrategyFactory {

	
public static TraversalStrategy getTraversalStrategy(Weakness weakness, CouplingGraph graph, Collection<EdgeLinkCorrespondence> correspondences) {
		switch (weakness.getName()) {
		case "unencrypted_connection":
			return new UnencryptedConnection_TraversalStrategy(graph, correspondences);
		case "weak_encryption":
			return new WeakEncryption_TraversalStrategy(graph, correspondences);
		default:
			return null;
		}
	}
}
