
package architecture.PCM;

import org.palladiosimulator.pcm.resourceenvironment.LinkingResource;

import edu.kit.kastel.sdq.coupling.models.couplinggraph.Edge;

public class EdgeLinkCorrespondence {
	
	private final Edge edge;
	private final LinkingResource linkingResource;
	
	public EdgeLinkCorrespondence(Edge edge, LinkingResource linkingResource) {
		super();
		this.edge = edge;
		this.linkingResource = linkingResource;
	}

	public Edge getEdge() {
		return edge;
	}

	public LinkingResource getLinkingResource() {
		return linkingResource;
	}
}
