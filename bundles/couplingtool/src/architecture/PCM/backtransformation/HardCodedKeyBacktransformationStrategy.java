package architecture.PCM.backtransformation;

import java.util.Collection;
import java.util.HashSet;

import org.modelversioning.emfprofileapplication.StereotypeApplication;

import architecture.PCM.AccessAnalysisStereotypeSecurityCharacteristicsMapper;
import architecture.PCM.EdgeLinkCorrespondence;
import architecture.PCM.InputModelsAccessAnalysis;
import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.SecurityCharacteristic;
import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.SecurityCharacteristicWeaknessMappingRoot;
import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.Weakness;

public class HardCodedKeyBacktransformationStrategy extends BacktransformationStrategyAccessAnalysis{

	public HardCodedKeyBacktransformationStrategy(InputModelsAccessAnalysis inputModels,
			SecurityCharacteristicWeaknessMappingRoot mappingRoot, Weakness targetWeakness) {
		super(inputModels, mappingRoot, targetWeakness);
	}

	@Override
	public void transformWeaknessForCorrespondence(Weakness weakness, EdgeLinkCorrespondence correspondence) {
		Collection<StereotypeApplication> appliedStereotypes = inputModels.getResourceEnvironmentProfile()
				.getStereotypeApplications(correspondence.getLinkingResource());
		Collection<StereotypeApplication> stereotypeApplicationsToRemove = new HashSet<StereotypeApplication>();

		for (StereotypeApplication stereo : appliedStereotypes) {
			SecurityCharacteristic characteristic = AccessAnalysisStereotypeSecurityCharacteristicsMapper
					.getSecurityCharacisticForStereotype(stereo.getStereotype(), mappingRoot);

			if (weakness.getViolates().contains(characteristic)) {
				stereotypeApplicationsToRemove.add(stereo);
				inputModels.getResourceEnvironmentProfile().getStereotypeApplications().remove(stereo);
				System.out.println("Stereotype To Remove: Name %s, Applied To %s".formatted(stereo.getStereotype().getName(), correspondence.getLinkingResource().getEntityName()));
				
			}
		}
	}

}
