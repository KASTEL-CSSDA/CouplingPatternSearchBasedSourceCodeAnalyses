package sourceCodeAnalysis.snyk;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.Weakness;
import exceptions.GenerationException;
import exceptions.InputException;
import exceptions.PatternViolationClassException;
import sourceCodeAnalysis.AbstractResult;
import sourceCodeAnalysis.CodeAnalysis;
import sourceCodeAnalysis.PatternWeaknessMapper;

public class SnykAnalysis implements CodeAnalysis{

	private static final String RUNS_KEY = "runs";
	private static final String RESULTS_KEY = "results";
	private static final String PATTERN_ID_KEY = "ruleId";
	private static final String LOCATION_KEY = "locations";
	private static final String PHYSICAL_LOCATION_KEY = "physicalLocation";
	private static final String ARTIFACT_LOCATION_KEY = "artifactLocation";
	private static final String FILE_KEY = "uri";
	private static final String METHOD_ID_KEY = "region";
	private static final String START_LINE_KEY = "startLine";
	private static final String END_LINE_KEY = "endLine";
	
	private PatternWeaknessMapper patternWeaknessMapper; 
	
	
	@Override
	public List<AbstractResult> runCodeAnalysis(String sourceCodeFilePath, PatternWeaknessMapper patternWeaknessMapper,
			String sourceCodeAnalysisOutputLocation) {
		
		this.patternWeaknessMapper = patternWeaknessMapper;
		
		List<AbstractResult> abstractResults = new ArrayList<AbstractResult>();
		String jsonContent = "";
		try {
			 jsonContent = new String(Files.readAllBytes(Paths.get(sourceCodeAnalysisOutputLocation)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		JSONObject root = new JSONObject(jsonContent);
		JSONArray runs = root.getJSONArray(RUNS_KEY);
		
		for(int run = 0; run < runs.length(); run++) {
			parseRun(runs.getJSONObject(run), abstractResults);
		}
		
		
		return abstractResults;
	}


	private void parseRun(JSONObject run, List<AbstractResult> abstractResults) {
		JSONArray results = run.getJSONArray(RESULTS_KEY);
		
		for(int result = 0; result < results.length(); result++) {
			parseResult(results.getJSONObject(result), abstractResults);
		}
		
	}


	private void parseResult(JSONObject result, List<AbstractResult> abstractResults) {
		
		String pattern = result.getString(PATTERN_ID_KEY);
		
		String className = getClassName(result.getJSONArray(LOCATION_KEY));
		int startLineOfCode = getStartLineOfCode(result.getJSONArray(LOCATION_KEY));
		int endLineOfOCode = getEndLineOfCode(result.getJSONArray(LOCATION_KEY));
		
		
		Weakness weakness = null;
		try {
			weakness = patternWeaknessMapper.mapToolPatternToWeakness(pattern);
		} catch (PatternViolationClassException | GenerationException | InputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AbstractResult reportedWeakness = new AbstractResult(weakness, "", className, startLineOfCode, endLineOfOCode);
		
		abstractResults.add(reportedWeakness);
		
		
	}
	private String getClassName(JSONArray locations) {
		
		//We assume only one location per array
		JSONObject location = locations.getJSONObject(0);
		JSONObject physicalLocation = location.getJSONObject(PHYSICAL_LOCATION_KEY);
		JSONObject artefactLocation = physicalLocation.getJSONObject(ARTIFACT_LOCATION_KEY);
		
		//We assume no nested classes and java, therefore, parsing the qualified class name from the file name
		String uri = artefactLocation.getString(FILE_KEY);
		
		String[] srcRemainderSplit = uri.split("src/");
		String packagePath = srcRemainderSplit[1];
		
		String className = packagePath.replace(".java", "");
		className = className.replace("/", ".");
		
		return className;
		
	}
	
	private int getStartLineOfCode(JSONArray locations) {
		//We assume only one location per array
		JSONObject location = locations.getJSONObject(0);
		JSONObject physicalLocation = location.getJSONObject(PHYSICAL_LOCATION_KEY);
		JSONObject methodIdentification = physicalLocation.getJSONObject(METHOD_ID_KEY);
		
		int startLineOfCode = methodIdentification.getInt(START_LINE_KEY);

		return startLineOfCode;
		
	}

	private int getEndLineOfCode(JSONArray locations) {
		//We assume only one location per array
		JSONObject location = locations.getJSONObject(0);
		JSONObject physicalLocation = location.getJSONObject(PHYSICAL_LOCATION_KEY);
		JSONObject methodIdentification = physicalLocation.getJSONObject(METHOD_ID_KEY);
		
		int endLineOfCode = methodIdentification.getInt(END_LINE_KEY);
		
		return endLineOfCode;
	}






}
