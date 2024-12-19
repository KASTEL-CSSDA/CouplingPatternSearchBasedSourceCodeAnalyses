package architecture;

import edu.kit.kastel.sdq.coupling.models.couplinggraph.CouplingGraph;

/**
 * An interface for annotating a graph with security properties in the context
 * of an architecture. Implementations of this interface are intended to process
 * the given input graph and annotate its edges with security properties
 * specific to the architecture The annotated graph is used for the further
 * security analysis coupling process
 *
 * @param <Graph> The graph that will be annotated.
 */
public interface ArchitectureGraphAnnotator {
	/**
	 * Annotates the input graph with security properties specific to the
	 * architecture.
	 *
	 * @param graph The input graph to be annotated.
	 * 
	 */ 
	public void annotateGraph(CouplingGraph graph);
}
