package architecture.PCM;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.modelversioning.emfprofileapplication.StereotypeApplication;
import org.palladiosimulator.pcm.allocation.Allocation;
import org.palladiosimulator.pcm.allocation.AllocationContext;
import org.palladiosimulator.pcm.core.composition.AssemblyConnector;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.repository.Interface;
import org.palladiosimulator.pcm.repository.OperationProvidedRole;
import org.palladiosimulator.pcm.repository.OperationRequiredRole;
import org.palladiosimulator.pcm.repository.OperationSignature;
import org.palladiosimulator.pcm.repository.ProvidedRole;
import org.palladiosimulator.pcm.repository.Repository;
import org.palladiosimulator.pcm.repository.RepositoryComponent;
import org.palladiosimulator.pcm.repository.RequiredRole;
import org.palladiosimulator.pcm.resourceenvironment.LinkingResource;
import org.palladiosimulator.pcm.resourceenvironment.ResourceContainer;
import org.palladiosimulator.pcm.resourceenvironment.ResourceEnvironment;
import architecture.ArchitectureGraphAnnotator;
import edu.kit.kastel.sdq.coupling.models.couplinggraph.CouplingGraph;
import edu.kit.kastel.sdq.coupling.models.couplinggraph.Edge;
import edu.kit.kastel.sdq.coupling.models.couplinggraph.Node;
import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.SecurityCharacteristic;
import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.SecurityCharacteristicWeaknessMappingRoot;
import exceptions.GenerationException;

/**
 * The PCMGraphAnnotator class is responsible for adding security properties
 * from the palladio component model to edges of a Graph.
 */
public class PCMGraphAnnotator implements ArchitectureGraphAnnotator {
	private final InputModelsAccessAnalysis inputModels;
	private CouplingGraph graph;
	private final ResourceEnvironment resourceEnvironment;
	private final Allocation allocation;
	private final Repository repository;
	private final SecurityCharacteristicWeaknessMappingRoot root;
	private final Collection<EdgeLinkCorrespondence> edgeLinkCorrespondences;



	public PCMGraphAnnotator(InputModelsAccessAnalysis inputModels) {
		this.inputModels = inputModels;
		resourceEnvironment = inputModels.getResourceEnvironment();
		allocation = inputModels.getAllocation();
		repository = inputModels.getRepository();
		root = inputModels.getRoot();
		this.edgeLinkCorrespondences = new HashSet<EdgeLinkCorrespondence>();
	}

	@Override
	public void annotateGraph(CouplingGraph graph) {
		this.graph = graph;
		try {
			processSecurityPropertiesForAllocatedComponents();
		} catch (GenerationException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Processes security properties for allocated components in the system.
	 *
	 * This method iterates through the linking resources in the resource
	 * environment to identify connected resource containers. It then matches
	 * allocation contexts to the corresponding resource containers and retrieves
	 * the encapsulated components for each allocation context. Finally, it adds
	 * security properties to an edge representing the annotated connection between
	 * the encapsulated components.
	 *
	 * @throws GenerationException If there is an error during the generation
	 *                             process.
	 */
	private void processSecurityPropertiesForAllocatedComponents() throws GenerationException {
		for (LinkingResource linkingR : resourceEnvironment.getLinkingResources__ResourceEnvironment()) {
			for (int i = 0; i < linkingR.getConnectedResourceContainers_LinkingResource().size(); i++) {

				ResourceContainer resourceC1 = linkingR.getConnectedResourceContainers_LinkingResource().get(i);
				Collection<AssemblyContext> assemblyContextsOnResourceC1 = allocation.getAllocationContexts_Allocation()
						.stream().filter(alloc -> alloc.getResourceContainer_AllocationContext().equals(resourceC1))
						.map(alloc -> alloc.getAssemblyContext_AllocationContext()).collect(Collectors.toSet());

				for (int j = i + 1; i < linkingR.getConnectedResourceContainers_LinkingResource().size(); i++) {
					ResourceContainer resourceC2 = linkingR.getConnectedResourceContainers_LinkingResource().get(j);

					// Get Allocations on resource C1 and Resource C2
					Collection<AssemblyContext> assemblyContextsOnResourceC2 = allocation
							.getAllocationContexts_Allocation().stream()
							.filter(alloc -> alloc.getResourceContainer_AllocationContext().equals(resourceC2))
							.map(alloc -> alloc.getAssemblyContext_AllocationContext()).collect(Collectors.toSet());

					Collection<AssemblyConnector> assemblyConnectors = inputModels.getSystem()
							.getConnectors__ComposedStructure().stream().filter(AssemblyConnector.class::isInstance)
							.map(AssemblyConnector.class::cast).collect(Collectors.toSet());

					for (AssemblyConnector connector : assemblyConnectors) {

						for (AssemblyContext assemblyContextOnResourceC1 : assemblyContextsOnResourceC1) {
							for (AssemblyContext assemblyContextOnResourceC2 : assemblyContextsOnResourceC2) {

								if (connector.getProvidingAssemblyContext_AssemblyConnector()
										.equals(assemblyContextOnResourceC1)
										|| connector.getProvidingAssemblyContext_AssemblyConnector()
												.equals(assemblyContextOnResourceC2)
												&& (connector.getRequiringAssemblyContext_AssemblyConnector()
														.equals(assemblyContextOnResourceC1)
														|| connector.getRequiringAssemblyContext_AssemblyConnector()
																.equals(assemblyContextOnResourceC2))) {

									addSecurityProperiesToEdge(linkingR, connector);
								}
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Adds security properties to an edge between two RepositoryComponents.
	 *
	 * 
	 * @param linkingResourceId The ID of the linking resource representing the
	 *                          connection.
	 * @param component1        The first RepositoryComponent in the connection.
	 * @param component2        The second RepositoryComponent in the connection.
	 * @throws GenerationException If there is an error during the generation
	 *                             process.
	 */
	private void addSecurityProperiesToEdge(LinkingResource linkingResource, AssemblyConnector connector)
			throws GenerationException {

		RepositoryComponent providingComponent = connector.getProvidingAssemblyContext_AssemblyConnector()
				.getEncapsulatedComponent__AssemblyContext();
		RepositoryComponent requiringComponent = connector.getRequiringAssemblyContext_AssemblyConnector()
				.getEncapsulatedComponent__AssemblyContext();

		for (OperationSignature providedSignature : connector.getProvidedRole_AssemblyConnector()
				.getProvidedInterface__OperationProvidedRole().getSignatures__OperationInterface()) {
			String signatureName = trimArtificialPCMOperationSignaturesName(providedSignature.getEntityName());

			for (Edge edge : graph.getEdges()) {

				if(edge.getDestination().getClassName().equals(edge.getSource().getClassName())) {
					continue;
				}
				
				
				if (edgeMapsToConnector(edge, providingComponent.getEntityName(), requiringComponent.getEntityName(), signatureName)) {
					
					EdgeLinkCorrespondence correspondence = new EdgeLinkCorrespondence(edge, linkingResource);
					edgeLinkCorrespondences.add(correspondence);

					mapSecurityCharacteristicToEdge(edge, linkingResource);
				}

			}
		}

	}

	/**
	 * Checks if the class and method names in the components match those in the
	 * source code file
	 *
	 *
	 * @param srcComponentClassName  The class name of the source component.
	 * @param srcComponentMethodName The method name of the source component.
	 * @param dstComponentClassName  The class name of the destination component.
	 * @param dstComponentMethodName The method name of the destination component.
	 * @param edge                   The edge to be checked for mapping.
	 * @return true if the mapping matches, false otherwise.
	 */
	private boolean edgeMapsToConnector(Edge edge, String providingComponentName, String requiringComponentName,
			String serviceName) {

		Node srcNode = edge.getSource();
		Node dstNode = edge.getDestination();

		String simpleSrcClassName = extractSimpleClassName(srcNode.getClassName());
		String simpleDstClassName = extractSimpleClassName(dstNode.getClassName());
		String dstMethodName = dstNode.getMethodName();


		return simpleSrcClassName.equals(requiringComponentName) && simpleDstClassName.equals(providingComponentName)
				&& dstMethodName.equals(serviceName);
	}

	/**
	 * 
	 * Maps a Confidentiality Profile from StereotypeApplications to a Security
	 * Property and associates it with the given Edge.
	 *
	 * @param edge              The Edge to which the Security Property is
	 *                          associated.
	 * @param linkingResourceId The resource ID used for linking.
	 * @throws GenerationException If an error occurs during Security Property
	 *                             generation.
	 */
	private void mapSecurityCharacteristicToEdge(Edge edge, LinkingResource linkingResource)
			throws GenerationException {
		//
		Collection<StereotypeApplication> appliedStereotypes = inputModels.getResourceEnvironmentProfile()
				.getStereotypeApplications(linkingResource);

		for (StereotypeApplication stereo : appliedStereotypes) {
			SecurityCharacteristic characteristic = AccessAnalysisStereotypeSecurityCharacteristicsMapper
					.getSecurityCharacisticForStereotype(stereo.getStereotype(), root);

			if (characteristic != null && !edge.getSecurityCharacteristics().contains(characteristic)) {
				edge.getSecurityCharacteristics().add(characteristic);
			}
		}
	}

	private String extractSimpleClassName(String qualifiedClassName) {
		String[] pathparts = qualifiedClassName.split("\\.");

		return pathparts[pathparts.length - 1];
	}
	
	//We have to remove artificial names for PCM OperationSignatures to increase readability
	private String trimArtificialPCMOperationSignaturesName(String artificialSignatureName) {
		
		String[] splitForOperationMarkers = artificialSignatureName.split("::");
		
		String[] removedParameters = splitForOperationMarkers[splitForOperationMarkers.length -1].split("\\(");
		
		return removedParameters[0];
	}
	
	public Collection<EdgeLinkCorrespondence> getEdgeLinkCorrespondences() {
		return edgeLinkCorrespondences;
	}

}
