package sourceCodeAnalysis.cognicrypt;

import java.util.List;

import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.SecurityCharacteristicWeaknessMappingRoot;
import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.Weakness;
import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.supporting.util.SecurityCharacteristicWeaknessMappingLookupUtil;
import exceptions.GenerationException;
import exceptions.InputException;
import exceptions.PatternViolationClassException;
import sourceCodeAnalysis.PatternWeaknessMapper;

/**
 * A mapper class responsible for mapping tool-specific pattern violation names
 * to corresponding pattern violation types.
 */
public class CognicryptPatternViolationMapper implements PatternWeaknessMapper {
	
	private SecurityCharacteristicWeaknessMappingRoot scwMappings;
	
	public CognicryptPatternViolationMapper(SecurityCharacteristicWeaknessMappingRoot scwMappings) {
		this.scwMappings = scwMappings;
	}

	/**
	 * Maps a tool-specific pattern violation name to a corresponding weakness
	 *
	 * @param patternName The name of the pattern from the tool.
	 * @return The mapped weakness.
	 * @throws PatternViolationClassException If a wrong pattern violation name is
	 *                                        mapped.
	 * @throws GenerationException            If the PatternViolationType is not
	 *                                        found in the model. This should only
	 *                                        happen in case of an error in the
	 *                                        model instance.
	 * @throws InputException                 If an input error occurs.
	 */
	@Override
	public Weakness mapToolPatternToWeakness(String patternName)
			throws PatternViolationClassException, GenerationException, InputException {

		switch (patternName) {
		case "Cipher":
			return SecurityCharacteristicWeaknessMappingLookupUtil.findWeaknessByName("Weak Encryption", scwMappings);

		case "RSAKeyGenParameterSpec":
			return SecurityCharacteristicWeaknessMappingLookupUtil.findWeaknessByName("Weak Encryption", scwMappings);

		default:
			throw new PatternViolationClassException("pattern mapping: " + patternName + "undefined");
		}

	}
}
