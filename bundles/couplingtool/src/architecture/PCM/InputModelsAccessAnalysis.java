package architecture.PCM;

import java.io.IOException;
import java.nio.file.Path;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.modelversioning.emfprofileapplication.ProfileApplication;
import org.palladiosimulator.pcm.allocation.Allocation;
import org.palladiosimulator.pcm.repository.Repository;
import org.palladiosimulator.pcm.resourceenvironment.ResourceEnvironment;
import org.palladiosimulator.pcm.system.System;

import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.SecurityCharacteristicWeaknessMappingRoot;


public class InputModelsAccessAnalysis {


	public ResourceEnvironment getResourceEnvironment() {
		return resourceEnvironment;
	}



	public Allocation getAllocation() {
		return allocation;
	}



	public Repository getRepository() {
		return repository;
	}


	public ProfileApplication getResourceEnvironmentProfile() {
		return resourceEnvironmentProfile;
	}



	private final ResourceEnvironment resourceEnvironment;
	private final Allocation allocation;
	private final Repository repository;
	private final SecurityCharacteristicWeaknessMappingRoot root;
	private final ProfileApplication resourceEnvironmentProfile;
	private final System system;
	

	public SecurityCharacteristicWeaknessMappingRoot getRoot() {
		return root;
	}



	public System getSystem() {
		return system;
	}



	public InputModelsAccessAnalysis(ResourceEnvironment resourceEnvironment, Allocation allocation, Repository repository,
			SecurityCharacteristicWeaknessMappingRoot root, ProfileApplication resourceEnvironmentProfile, System system) {
		super();
		this.resourceEnvironment = resourceEnvironment;
		this.allocation = allocation;
		this.repository = repository;
		this.root = root;
		this.resourceEnvironmentProfile = resourceEnvironmentProfile;
		this.system = system;
	}
	
	
	
	public static InputModelsAccessAnalysis createModelsFromFiles(String repositoryFilePath, String resourceEnvironmentPath, String allocationPath, String mappingModelPath, String systemPath) {
		ResourceSetImpl resSet = new ResourceSetImpl();

		URI repositoryUri = URI.createFileURI(Path.of(repositoryFilePath).toAbsolutePath().toString());
		URI resourceEnvironmentUri = URI.createFileURI(Path.of(resourceEnvironmentPath).toAbsolutePath().toString());
		URI allocationUri = URI.createFileURI(Path.of(allocationPath).toAbsolutePath().toString());
		URI mappingModelUri = URI.createFileURI(Path.of(mappingModelPath).toAbsolutePath().toString());
		URI systemUri = URI.createFileURI(Path.of(systemPath).toAbsolutePath().toString());

		Resource resourceRepository = resSet.getResource(repositoryUri, true);
		Resource resourceResourceEnvironment = resSet.getResource(resourceEnvironmentUri, true);
		Resource resourceAllocation = resSet.getResource(allocationUri, true);
		Resource resourceMappingModel = resSet.getResource(mappingModelUri, true);
		Resource resourceSystem = resSet.getResource(systemUri, true);

		try {
			resourceRepository.load(null);
			resourceResourceEnvironment.load(null);
			resourceAllocation.load(null);
			resourceMappingModel.load(null);
			resourceSystem.load(null);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Repository repository = (Repository) resourceRepository.getContents().get(0);
		ResourceEnvironment resourceEnvironment = (ResourceEnvironment) resourceResourceEnvironment.getContents().get(0);
		ProfileApplication resourceEnvironmentProfile = (ProfileApplication) resourceResourceEnvironment.getContents().get(1);
		Allocation allocation = (Allocation) resourceAllocation.getContents().get(0);
		SecurityCharacteristicWeaknessMappingRoot mappingRoot = (SecurityCharacteristicWeaknessMappingRoot) resourceMappingModel.getContents().get(0);
		System system = (System) resourceSystem.getContents().get(0);

		return new InputModelsAccessAnalysis(resourceEnvironment, allocation, repository, mappingRoot, resourceEnvironmentProfile, system);
	}
}
