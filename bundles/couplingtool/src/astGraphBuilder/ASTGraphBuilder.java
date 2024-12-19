package astGraphBuilder;

import java.util.Optional;

import edu.kit.kastel.sdq.coupling.models.couplinggraph.CouplingGraph;
import edu.kit.kastel.sdq.coupling.models.couplinggraph.Edge;


/**
 * This interface defines methods for building an Abstract Syntax Tree (AST)
 * graph. This interface provides methods for adding edges and retrieving the
 * graph from securityCouplingGraph.
 */
public interface ASTGraphBuilder {

	public Optional<Edge> getEdgeForCalledMethod(String calledMethod);

	public void buildASTGraph();

	public CouplingGraph getGraph();
}
