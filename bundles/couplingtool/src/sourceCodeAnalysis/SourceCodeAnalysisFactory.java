package sourceCodeAnalysis;

import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.SecurityCharacteristicWeaknessMappingRoot;
import sourceCodeAnalysis.findsecbugs.FindSecBugsAnalysis;
import sourceCodeAnalysis.findsecbugs.FindSecBugsPatternWeaknessMapper;
import sourceCodeAnalysis.semgrep.SemgrepAnalysis;
import sourceCodeAnalysis.semgrep.SemgrepPatternWeaknessMapper;
import sourceCodeAnalysis.snyk.SnykAnalysis;
import sourceCodeAnalysis.snyk.SnykPatternWeaknessMapper;

public class SourceCodeAnalysisFactory {

	public static final String COGNI_CRYPT_IDENTIFIER = "CogniCrypt";
	public static final String FIND_SEC_BUGS = "FindSecBugs";
	public static final String SNYK = "Snyk";
	public static final String SEMGREP = "Semgrep";
	
	
	public static CodeAnalysis createAnalysis(String analysisName) throws Exception {
		switch (analysisName) {
		case FIND_SEC_BUGS: 
			return new FindSecBugsAnalysis();
		case SNYK:
			return new SnykAnalysis();
		case SEMGREP: 
			return new SemgrepAnalysis();
		default:
			throw new Exception("Analysis with Name %s not awailable".formatted(analysisName));
		}
	}
	
	public static PatternWeaknessMapper createPatternToWeaknessMapperForAnalysis(String analysisName, SecurityCharacteristicWeaknessMappingRoot scwMappings) throws Exception {
		switch (analysisName) {
		case FIND_SEC_BUGS: 
			return new FindSecBugsPatternWeaknessMapper(scwMappings);
		case SNYK:
			return new SnykPatternWeaknessMapper(scwMappings);
		case SEMGREP:
			return new SemgrepPatternWeaknessMapper(scwMappings);
		default:
			throw new Exception("Analysis with Name %s not awailable".formatted(analysisName));
		}
	}
}
