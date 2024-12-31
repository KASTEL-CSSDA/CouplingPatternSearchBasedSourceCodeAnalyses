package securityAnalysisCoupling;

import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.Weakness;

public interface BacktransformationFactory {

	
	public BacktransformationStrategy createStrategy(Weakness weakness);
	
}
