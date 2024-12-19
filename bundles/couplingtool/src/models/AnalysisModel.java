package models;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Collection;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.resource.Resource;
import org.json.JSONException;
import architecture.PCM.InputModelsAccessAnalysis;
import exceptions.InputException;
import exceptions.ModelSaveException;
import utils.ConfigReader;
import utils.PathValidator;

/**
 * This class represents an analysis model that combines the palladio component
 * model (pcm) and the SecPropPatternViolation model. This class allows you to
 * create, update, and retrieve Palladio models like Allocation, Repository,
 * Resource Environment, System, and the SecPropPatternViolation model.
 */
public class AnalysisModel {

	private static final String ACCESS_CONFIG_FILE_ENDING = "json";

	private final InputModelsAccessAnalysis inputModels;

	public InputModelsAccessAnalysis getInputModels() {
		return inputModels;
	}

	private final Path baseFolder;
	private final String sourceCodePath;
	private final String sourceCodeAnalysisName;

	public String getSourceCodeAnalysisName() {
		return sourceCodeAnalysisName;
	}


	/**
	 * Constructs an AnalysisModel instance.
	 *
	 * @param rootSecPropPatternViolation     The RootSecPropPatternViolation model.
	 * @param baseFolder                      The base folder for the models.
	 * @param allocation                      The Allocation model.
	 * @param repository                      The Repository model.
	 * @param resourceEnvironment             The ResourceEnvironment model.
	 * @param system                          The System model.
	 * @param rootsecPropPatternViolationPath The path to the
	 *                                        RootSecPropPatternViolation model.
	 */
	public AnalysisModel(InputModelsAccessAnalysis inputModels, Path baseFolder, String sourceCodePath, String sourceCodeAnalysisName) {

		this.baseFolder = baseFolder;
		this.inputModels = inputModels;
		this.sourceCodePath = sourceCodePath;
		this.sourceCodeAnalysisName = sourceCodeAnalysisName;

	}

	
	public static IFile getConfig(Collection<IFile> files) {
		for (IFile file : files) {
			if(file.getFileExtension().equals(ACCESS_CONFIG_FILE_ENDING)) {
				return file;
			}
		}
		
		return null;
	}

	private void saveResource(Resource resource) throws ModelSaveException {
		try {
			resource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
			throw new ModelSaveException(e.getMessage());
		}
	}

	/**
	 * Creates AnalysisModel instances from a collection of files.
	 *
	 * @param files The collection of files containing the necessary models.
	 * @return An AnalysisModel instance.
	 * @throws InputException If an error occurs while reading the models from
	 *                        files.
	 * @throws JSONException
	 */
	public static AnalysisModel createModelsFromConfig (IFile config) throws InputException, JSONException {

		IPath configPath = config.getLocation();
		String configPathString = configPath.toOSString();
		
		Path repositoryPath = Path.of(ConfigReader.getRepositoryModelLocationFromJSON(configPathString));
		Path resourceEnvironmentPath = Path.of(ConfigReader.getResourceEnvironmentModelLocationFromJSON(configPathString));
		Path allocationPath = Path.of(ConfigReader.getAllocationModelLocationFromJSON(configPathString));
		Path mappingModelPath = Path.of(ConfigReader.getSCWMappingModelLocationFromJSON(configPathString));
		Path systemPath = Path.of(ConfigReader.getSystemModelLocationFromJSON(configPathString));
		
		
		InputModelsAccessAnalysis inputModels = InputModelsAccessAnalysis.createModelsFromFiles(
				repositoryPath.toAbsolutePath().toString(), resourceEnvironmentPath.toAbsolutePath().toString(),
				allocationPath.toAbsolutePath().toString(), mappingModelPath.toAbsolutePath().toString(),
				systemPath.toAbsolutePath().toString());

		
		String sourceCodePath = ConfigReader.getSourceCodePathFromJSON(configPathString);
		PathValidator.validatePath(configPathString);

		String sourceCodeAnalysisName = ConfigReader.getSourceCodeAnalysisNameFromJSON(configPathString);
		
		
		// Obtain the parent directory path of 'repositoryPath' by removing the last
		// segment, which represents the file itself in the directory
		Path basePath = repositoryPath.getParent();
		return new AnalysisModel(inputModels, basePath, sourceCodePath, sourceCodeAnalysisName);

	}

	public String getSourceCodePath() {
		return sourceCodePath;
	}

	public Path getBaseFolder() {
		return baseFolder;
	}
}
