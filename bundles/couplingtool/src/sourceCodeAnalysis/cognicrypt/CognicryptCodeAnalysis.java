package sourceCodeAnalysis.cognicrypt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import crypto.HeadlessCryptoScanner;
import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.Weakness;
import exceptions.GenerationException;
import exceptions.InputException;
import exceptions.PatternViolationClassException;
import sourceCodeAnalysis.AbstractResult;
import sourceCodeAnalysis.CodeAnalysis;
import sourceCodeAnalysis.PatternWeaknessMapper;

/**
 * A tool for running CogniCrypt analysis on source code and extracting results.
 */
public class CognicryptCodeAnalysis implements CodeAnalysis {
	
	
	private List<AbstractResult> results = new LinkedList<AbstractResult>();

	private static final String COGNICRYPT_RULESDIR_PATH = "/home/frederik/Arbeitsplatz/git/lehre/praktikum/sandronegri/ISE/SecurityAnalysis/src/tool/cognicrypt/resources/crypto-rules";

	private static final String COGNICRYPT_REPORTDIR_PATH = "/home/frederik/Arbeitsplatz/git/lehre/praktikum/sandronegri/ISE/SecurityAnalysis/src/tool/cognicrypt/resources/results";

	private static final String COGNICRYPT_REPORT_FORMAT = "--sarifReport";
	private static final String REPORT_NAME = "CogniCrypt-SARIF-Report";
	
	private PatternWeaknessMapper mapper;

	/**
	 * Runs CogniCrypt analysis on the specified source code file.
	 *
	 * @param sourceCodeFilePath The path to the source code file.
	 * @return The list of AbstractResult objects representing analysis results.
	 */
	@Override
	public List<AbstractResult> runCodeAnalysis(String sourceCodeFilePath, PatternWeaknessMapper patternWeaknessMapper, String sourceCodeAnalyisOutputLocation) {
		
		this.mapper = patternWeaknessMapper;
		
		HeadlessCryptoScanner hcs = HeadlessCryptoScanner
				.createFromOptions(new String[] { "--rulesDir", COGNICRYPT_RULESDIR_PATH, "--applicationCp",
						sourceCodeFilePath, "--reportDir", COGNICRYPT_REPORTDIR_PATH, COGNICRYPT_REPORT_FORMAT, "" });
		hcs.exec();

		String jsonStructure = createJSONStructureFromReport();

		return createResultFromJSONStructure(jsonStructure);

	}

	/**
	 * Creates a JSON structure from the CogniCrypt analysis report.
	 *
	 * @return The JSON structure as a string.
	 */
	private String createJSONStructureFromReport() {
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(REPORT_NAME));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String jsonStructure = null;
		try {
			StringBuilder sb = new StringBuilder();
			String line = null;
			try {
				line = bufferedReader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

			while (line != null) {
				sb.append(line);
				sb.append("\n");
				try {
					line = bufferedReader.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			jsonStructure = sb.toString();
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return jsonStructure;
	}

	// TODO handle different exceptions in catch block

	/**
	 * Creates a list of AbstractResult objects from a JSON structure as a string.
	 *
	 * @param jsonStructure The JSON structure as a string.
	 * @return The list of AbstractResult objects representing analysis results.
	 */
	private List<AbstractResult> createResultFromJSONStructure(String jsonStructure) {
		String violatedClassName = null;
		String methodName = null;
		String className = null;
		int startCodeLine = 0;
		int endCodeLine = 0;
		boolean isMoreThanOneLine = false;

		// parse JSON file
		JSONArray resultsArray = null;
		try {
			JSONObject jsonObject = new JSONObject(jsonStructure);
			JSONArray runsArray = jsonObject.getJSONArray("runs");
			JSONObject resultsObject = runsArray.getJSONObject(0);
			resultsArray = resultsObject.getJSONArray("results");
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (int i = 0; i < resultsArray.length(); i++) {
			String message = null;
			JSONObject locationsObject = null;
			try {
				locationsObject = resultsArray.getJSONObject(i);
				JSONObject messageObject = locationsObject.optJSONObject("message");
				message = messageObject.getString("richText");
			} catch (JSONException e) {
				e.printStackTrace();
			}

			// get violated class from message
			String[] messageSplitted = (message.split(" "));
			String s = messageSplitted[messageSplitted.length - 1];
			String violatedClass = s.substring(0, s.length() - 1);
			String[] violatedClassSplitted = violatedClass.split("\\.");
			violatedClassName = violatedClassSplitted[violatedClassSplitted.length - 1];

			// get code location, method and class name
			JSONArray locationsArray = null;
			JSONObject startLineObject = null;
			JSONObject regionObject = null;
			try {
				locationsArray = locationsObject.getJSONArray("locations");
				regionObject = locationsArray.getJSONObject(0);
				JSONObject pysicalLocationObject = regionObject.getJSONObject("physicalLocation");
				startLineObject = pysicalLocationObject.getJSONObject("region");
			} catch (JSONException e) {
				e.printStackTrace();
			}

			startCodeLine = (int) startLineObject.optInt("startLine");
			endCodeLine = (int) startLineObject.optInt("endLine");
			String qualifiedName = regionObject.optString("fullyQualifiedLogicalName");
			String[] qualifiedNameSplitted = qualifiedName.split("::");
			methodName = qualifiedNameSplitted[qualifiedNameSplitted.length - 1];
			className = qualifiedNameSplitted[qualifiedNameSplitted.length - 2];

	
			try {
				Weakness weakness = mapper.mapToolPatternToWeakness(violatedClassName);
				
				results.add(new Result(weakness, methodName, className, startCodeLine, endCodeLine,
						isMoreThanOneLine));

			} catch (PatternViolationClassException | GenerationException | InputException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		return results;
	}

}
