package utils;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import org.palladiosimulator.pcm.resourceenvironment.LinkingResource;

import architecture.PCM.EdgeLinkCorrespondence;
import edu.kit.kastel.sdq.coupling.models.couplinggraph.Edge;

public class CorrespondenceUtil {

	
	public static Collection<EdgeLinkCorrespondence> getCorrespondencesForEdge(Edge edge, Collection<EdgeLinkCorrespondence> correspondences){
			return correspondences.stream().filter(corr -> corr.getEdge().equals(edge)).collect(Collectors.toSet());
	}
	
	public static EdgeLinkCorrespondence getOrCreateCorrespondence(Edge edge, LinkingResource link, Collection<EdgeLinkCorrespondence> correspondences) {
		
		Optional<EdgeLinkCorrespondence> potentialCorrespondence = correspondences.stream().filter(corr -> corr.getEdge().equals(edge) && corr.getLinkingResource().equals(link)).findFirst();
		
		
		if(potentialCorrespondence.isPresent()) {
			return potentialCorrespondence.get();
		}
		
		return new EdgeLinkCorrespondence(edge, link);
		
	}
}
