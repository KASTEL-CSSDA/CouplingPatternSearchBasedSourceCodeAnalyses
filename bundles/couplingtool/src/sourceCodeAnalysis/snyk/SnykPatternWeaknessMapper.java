package sourceCodeAnalysis.snyk;

import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.SecurityCharacteristicWeaknessMappingRoot;
import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.Weakness;
import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.supporting.util.SecurityCharacteristicWeaknessMappingLookupUtil;
import exceptions.GenerationException;
import exceptions.InputException;
import exceptions.PatternViolationClassException;
import sourceCodeAnalysis.PatternWeaknessMapper;

public class SnykPatternWeaknessMapper implements PatternWeaknessMapper{


	private final SecurityCharacteristicWeaknessMappingRoot scwMappings;
	
	public SnykPatternWeaknessMapper(SecurityCharacteristicWeaknessMappingRoot scwMappings) {
		super();
		this.scwMappings = scwMappings;
	}


	@Override
	public Weakness mapToolPatternToWeakness(String patternName)
			throws PatternViolationClassException, GenerationException, InputException {
		// TODO Auto-generated method stub
		switch (patternName) {
		case "java/InsecureCipher":
			return SecurityCharacteristicWeaknessMappingLookupUtil.findWeaknessByName("weak_encryption", scwMappings);
		case "java/HardcodedSecret":
			return SecurityCharacteristicWeaknessMappingLookupUtil.findWeaknessByName("hard_coded_key", scwMappings);
		default:
			return null;
		}
	}

}
