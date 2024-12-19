package sourceCodeAnalysis;

import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.SecurityCharacteristicWeaknessMappingRoot;
import sourceCodeAnalysis.cognicrypt.CognicryptCodeAnalysis;
import sourceCodeAnalysis.cognicrypt.CognicryptPatternViolationMapper;
import sourceCodeAnalysis.findsecbugs.FindSecBugsAnalysis;
import sourceCodeAnalysis.findsecbugs.FindSecBugsPatternWeaknessMapper;

public class SourceCodeAnalysisFactory {

	public static final String COGNI_CRYPT_IDENTIFIER = "CogniCrypt";
	public static final String FIND_SEC_BUGS = "FindSecBugs";
	
	
	public static CodeAnalysis createAnalysis(String analysisName) throws Exception {
		switch (analysisName) {
		case COGNI_CRYPT_IDENTIFIER:
			return new CognicryptCodeAnalysis();
		case FIND_SEC_BUGS: 
			return new FindSecBugsAnalysis();
		default:
			throw new Exception("Analysis with Name %s not awailable".formatted(analysisName));
		}
	}
	
	public static PatternWeaknessMapper createPatternToWeaknessMapperForAnalysis(String analysisName, SecurityCharacteristicWeaknessMappingRoot scwMappings) throws Exception {
		switch (analysisName) {
		case COGNI_CRYPT_IDENTIFIER:
			return new CognicryptPatternViolationMapper(scwMappings);
		case FIND_SEC_BUGS: 
			return new FindSecBugsPatternWeaknessMapper(scwMappings);
		default:
			throw new Exception("Analysis with Name %s not awailable".formatted(analysisName));
		}
	}
}
