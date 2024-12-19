package sourceCodeAnalysis.findsecbugs;

import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.SecurityCharacteristicWeaknessMappingRoot;
import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.Weakness;
import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.supporting.util.SecurityCharacteristicWeaknessMappingLookupUtil;
import exceptions.GenerationException;
import exceptions.InputException;
import exceptions.PatternViolationClassException;
import sourceCodeAnalysis.PatternWeaknessMapper;

public class FindSecBugsPatternWeaknessMapper implements PatternWeaknessMapper {

	private SecurityCharacteristicWeaknessMappingRoot scwMappings;

	public FindSecBugsPatternWeaknessMapper(SecurityCharacteristicWeaknessMappingRoot scwMappings) {
		this.scwMappings = scwMappings;
	}

	@Override
	public Weakness mapToolPatternToWeakness(String patternName)
			throws PatternViolationClassException, GenerationException, InputException {
		// TODO Auto-generated method stub
		switch (patternName) {
		case "DES_USAGE":
			return SecurityCharacteristicWeaknessMappingLookupUtil.findWeaknessByName("weak_encryption", scwMappings);
		case "UNENCRYPTED_SOCKET":
			return SecurityCharacteristicWeaknessMappingLookupUtil.findWeaknessByName("unencrypted_connection", scwMappings);
		default:
			return null;
		}
	}

}
