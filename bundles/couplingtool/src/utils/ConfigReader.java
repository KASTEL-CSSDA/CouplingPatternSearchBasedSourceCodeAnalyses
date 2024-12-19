package utils;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConfigReader {
	
	private final static String JSON_KEY_SOURCE_CODE_PATH = "sourceCodePath";
	private final static String JSON_KEY_SOURCE_CODE_ANALYSIS = "sourceCodeAnalysis";
	private final static String JSON_KEY_SCW_MAPPING_MODEL_LOCATION = "scwMappingModelLocation";
	private final static String JSON_KEY_REPOSITORY_MODEL_LOCATION = "repositoryModelLocation";
	private final static String JSON_KEY_SYSTEM_MODEL_LOCATION = "systemModelLocation";
	private final static String JSON_KEY_ALLOCATION_MODEL_LOCATION = "allocationModelLocation";
	private final static String JSON_KEY_RESOURCE_ENVIRONMENT_MODEL_LOCATION = "resourceEnvironmentModelLocation";
	private final static String JSON_KEY_GRAPH_MODEL_LOCATION = "graphModelSaveLocation";
	/**
	 * Reads the sourceCodePath from a JSON file and returns it as a string.
	 *
	 * @param jsonFilePath The path to the JSON file.
	 * @return The sourceCodePath as a string, or null if there's an error.
	 * @throws JSONException
	 */
	public static String getSourceCodePathFromJSON(String jsonFilePath) throws JSONException {
		try {
			// Read JSON file content as text
			String jsonContent = new String(Files.readAllBytes(Paths.get(jsonFilePath)));

			// Create a JSON object from the text
			JSONObject jsonObject = new JSONObject(jsonContent);

			// Extract and return the value of the "sourceCodePath" key as a string
			return jsonObject.getString(JSON_KEY_SOURCE_CODE_PATH);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Reads the sourceCodePath from a JSON file and returns it as a string.
	 *
	 * @param jsonFilePath The path to the JSON file.
	 * @return The sourceCodePath as a string, or null if there's an error.
	 * @throws JSONException
	 */
	public static String getTargetSourceCodeAnalysisFromJSON(String jsonFilePath) throws JSONException {
		try {
			// Read JSON file content as text
			String jsonContent = new String(Files.readAllBytes(Paths.get(jsonFilePath)));

			// Create a JSON object from the text
			JSONObject jsonObject = new JSONObject(jsonContent);

			// Extract and return the value of the "sourceCodeAnalysis" key as a string
			return jsonObject.getString(JSON_KEY_SOURCE_CODE_ANALYSIS);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String getSCWMappingModelLocationFromJSON(String jsonFilePath) throws JSONException {
		try {
			// Read JSON file content as text
			String jsonContent = new String(Files.readAllBytes(Paths.get(jsonFilePath)));

			// Create a JSON object from the text
			JSONObject jsonObject = new JSONObject(jsonContent);

			// Extract and return the value of the "sourceCodeAnalysis" key as a string
			return jsonObject.getString(JSON_KEY_SCW_MAPPING_MODEL_LOCATION);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String getRepositoryModelLocationFromJSON(String jsonFilePath) throws JSONException {
		try {
			// Read JSON file content as text
			String jsonContent = new String(Files.readAllBytes(Paths.get(jsonFilePath)));

			// Create a JSON object from the text
			JSONObject jsonObject = new JSONObject(jsonContent);

			// Extract and return the value of the "sourceCodeAnalysis" key as a string
			return jsonObject.getString(JSON_KEY_REPOSITORY_MODEL_LOCATION);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String getSystemModelLocationFromJSON(String jsonFilePath) throws JSONException {
		try {
			// Read JSON file content as text
			String jsonContent = new String(Files.readAllBytes(Paths.get(jsonFilePath)));

			// Create a JSON object from the text
			JSONObject jsonObject = new JSONObject(jsonContent);

			// Extract and return the value of the "sourceCodeAnalysis" key as a string
			return jsonObject.getString(JSON_KEY_SYSTEM_MODEL_LOCATION);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String getAllocationModelLocationFromJSON(String jsonFilePath) throws JSONException {
		try {
			// Read JSON file content as text
			String jsonContent = new String(Files.readAllBytes(Paths.get(jsonFilePath)));

			// Create a JSON object from the text
			JSONObject jsonObject = new JSONObject(jsonContent);

			// Extract and return the value of the "sourceCodeAnalysis" key as a string
			return jsonObject.getString(JSON_KEY_ALLOCATION_MODEL_LOCATION);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String getResourceEnvironmentModelLocationFromJSON(String jsonFilePath) throws JSONException {
		try {
			// Read JSON file content as text
			String jsonContent = new String(Files.readAllBytes(Paths.get(jsonFilePath)));

			// Create a JSON object from the text
			JSONObject jsonObject = new JSONObject(jsonContent);

			// Extract and return the value of the "sourceCodeAnalysis" key as a string
			return jsonObject.getString(JSON_KEY_RESOURCE_ENVIRONMENT_MODEL_LOCATION);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String getCouplingGraphModelSaveLocationFromJSON(String jsonFilePath) throws JSONException {
		try {
			// Read JSON file content as text
			String jsonContent = new String(Files.readAllBytes(Paths.get(jsonFilePath)));

			// Create a JSON object from the text
			JSONObject jsonObject = new JSONObject(jsonContent);

			// Extract and return the value of the "sourceCodeAnalysis" key as a string
			return jsonObject.getString(JSON_KEY_GRAPH_MODEL_LOCATION);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String getSourceCodeAnalysisNameFromJSON(String jsonFilePath) throws JSONException {
		try {
			// Read JSON file content as text
			String jsonContent = new String(Files.readAllBytes(Paths.get(jsonFilePath)));

			// Create a JSON object from the text
			JSONObject jsonObject = new JSONObject(jsonContent);

			// Extract and return the value of the "sourceCodeAnalysis" key as a string
			return jsonObject.getString(JSON_KEY_SOURCE_CODE_ANALYSIS);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
