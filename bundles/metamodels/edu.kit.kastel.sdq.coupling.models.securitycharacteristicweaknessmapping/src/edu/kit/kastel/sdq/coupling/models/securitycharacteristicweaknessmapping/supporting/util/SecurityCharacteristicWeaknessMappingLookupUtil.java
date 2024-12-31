package edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.supporting.util;

import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.SecurityCharacteristic;
import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.SecurityCharacteristicWeaknessMappingRoot;
import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.Weakness;

public class SecurityCharacteristicWeaknessMappingLookupUtil {

	public static SecurityCharacteristic findCharacteristicByName(String characteristicName,
			SecurityCharacteristicWeaknessMappingRoot mappings) {
		return mappings.getSecurityCharacteristics().stream().filter(
				characteristic -> characteristic.getName().toLowerCase().equals(characteristicName.toLowerCase()))
				.findFirst().get();
	}
	
	public static Weakness findWeaknessByName(String weaknessName, SecurityCharacteristicWeaknessMappingRoot mappings) {
		return mappings.getWeaknesses().stream().filter(
				weakness -> weakness.getName().toLowerCase().equals(weaknessName.toLowerCase()))
				.findFirst().get();
	}

}
