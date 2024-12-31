package securityAnalysisCoupling;

import architecture.PCM.EdgeLinkCorrespondence;
import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.Weakness;

public interface BacktransformationStrategy {

	public void transformWeaknessForCorrespondence(Weakness weakness, EdgeLinkCorrespondence correspondence);
	
}
