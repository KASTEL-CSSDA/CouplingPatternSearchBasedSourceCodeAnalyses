package architecture.PCM;

import org.modelversioning.emfprofile.Stereotype;


import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.SecurityCharacteristic;
import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.SecurityCharacteristicWeaknessMappingRoot;
import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.supporting.util.SecurityCharacteristicWeaknessMappingLookupUtil;

public class AccessAnalysisStereotypeSecurityCharacteristicsMapper {

	private static final String ENCRYPTION_CHARACTERISTIC = "Encryption";
	
	public static SecurityCharacteristic getSecurityCharacisticForStereotype(Stereotype stereotype, SecurityCharacteristicWeaknessMappingRoot root) {
		
		String stereotypeName = stereotype.getName();
		if(stereotypeName.toLowerCase().equals(ENCRYPTION_CHARACTERISTIC.toLowerCase())) {
			
			return SecurityCharacteristicWeaknessMappingLookupUtil.findCharacteristicByName("encryption", root);
		
		}
			
		return null;
	}
	
}
