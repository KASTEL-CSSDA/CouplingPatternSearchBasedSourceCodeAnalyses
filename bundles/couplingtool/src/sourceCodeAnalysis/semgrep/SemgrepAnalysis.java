package sourceCodeAnalysis.semgrep;

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

public class SemgrepAnalysis implements CodeAnalysis{

	private PatternWeaknessMapper patternWeaknessMapper; 
	private static final String RESULTS_KEY = "results";
	private static final String PATTERN_ID_KEY = "check_id";
	private static final String JAVA_FILE_KEY_PATH = "path";
	private static final String START_LINE_ELEMENT_KEY = "start";
	private static final String END_LINE_ELEMENT_KEY = "end";
	private static final String LINE_KEY = "line";
	
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
		JSONArray results = root.getJSONArray(RESULTS_KEY);
		
		parseResults(results, abstractResults);
		
		return abstractResults;
	}

	private void parseResults(JSONArray results, List<AbstractResult> abstractResults) {
	
		
		for(int result = 0; result < results.length(); result++) {
			parseResult(results.getJSONObject(result), abstractResults);
		}
		
	}

	private void parseResult(JSONObject result, List<AbstractResult> abstractResults) {
		String pattern = result.getString(PATTERN_ID_KEY);
		String className = parseClassName(result);
		int startLine = parseStartLine(result);
		int endLine = parseEndLine(result);
		
		Weakness weakness = null;
		try {
			weakness = patternWeaknessMapper.mapToolPatternToWeakness(pattern);
		} catch (PatternViolationClassException | GenerationException | InputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(weakness == null) {
			System.err.println("Unknown Pattern: " + pattern);
			return;
		}
		
		AbstractResult resultEntry = new AbstractResult(weakness, "", className, startLine, endLine);
		
		abstractResults.add(resultEntry);
		
	}
	

	private String parseClassName(JSONObject result) {
		
		String path = result.getString(JAVA_FILE_KEY_PATH);
		String packagePath = "";
		if(path.startsWith("src/")) {
		String[] srcRemainderSplit = path.split("src/");
		packagePath = srcRemainderSplit[1];
		} else {
			packagePath = path;
		}
		
		String className = packagePath.replace(".java", ""); 
		className = className.replace("/", ".");
		
		return className;
	}
	
	private int parseStartLine(JSONObject result) {
		JSONObject start = result.getJSONObject(START_LINE_ELEMENT_KEY);
		
		return start.getInt(LINE_KEY);
	}

	private int parseEndLine(JSONObject result) {
		JSONObject end = result.getJSONObject(END_LINE_ELEMENT_KEY);
		return end.getInt(LINE_KEY);
	}




}
