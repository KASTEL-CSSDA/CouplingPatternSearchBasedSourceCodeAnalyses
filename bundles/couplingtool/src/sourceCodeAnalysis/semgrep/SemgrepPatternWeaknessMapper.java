package sourceCodeAnalysis.semgrep;

import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.SecurityCharacteristicWeaknessMappingRoot;
import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.Weakness;
import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.supporting.util.SecurityCharacteristicWeaknessMappingLookupUtil;
import exceptions.GenerationException;
import exceptions.InputException;
import exceptions.PatternViolationClassException;
import sourceCodeAnalysis.PatternWeaknessMapper;

public class SemgrepPatternWeaknessMapper implements PatternWeaknessMapper {

	private final SecurityCharacteristicWeaknessMappingRoot scwMappings;
	private static final String UNENCRYPTED_SOCKED = "java.lang.security.audit.crypto.unencrypted-socket.unencrypted-socket";
	private static final String DES_USAGE = "java.lang.security.audit.crypto.desede-is-deprecated.desede-is-deprecated";
	private static final String DES_USAGE_2 = "java.lang.security.audit.crypto.des-is-deprecated.des-is-deprecated";
	private static final String HARD_CODED_SECRET = "java.lang.security.crypto.hardcoded-secret-key-spec.hardcoded-secret-key-spec";

	public SemgrepPatternWeaknessMapper(SecurityCharacteristicWeaknessMappingRoot scwMappings) {
		super();
		this.scwMappings = scwMappings;
	}

	@Override
	public Weakness mapToolPatternToWeakness(String patternName)
			throws PatternViolationClassException, GenerationException, InputException {
		switch (patternName) {
		case DES_USAGE:
			return SecurityCharacteristicWeaknessMappingLookupUtil.findWeaknessByName("weak_encryption", scwMappings);
		case DES_USAGE_2:
			return SecurityCharacteristicWeaknessMappingLookupUtil.findWeaknessByName("weak_encryption", scwMappings);
		case UNENCRYPTED_SOCKED:
			return SecurityCharacteristicWeaknessMappingLookupUtil.findWeaknessByName("unencrypted_connection",
					scwMappings);
		case HARD_CODED_SECRET:
			return SecurityCharacteristicWeaknessMappingLookupUtil.findWeaknessByName("hard_coded_key", scwMappings);
		default:
			return null;
		}
	}
}
