package architecture.PCM.backtransformation;

import java.util.Collection;

import architecture.PCM.EdgeLinkCorrespondence;
import architecture.PCM.InputModelsAccessAnalysis;
import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.Weakness;
import securityAnalysisCoupling.BacktransformationFactory;
import securityAnalysisCoupling.BacktransformationStrategy;

public class BacktransformationFactoryAccessAnalysis implements BacktransformationFactory{

	
	public BacktransformationFactoryAccessAnalysis(InputModelsAccessAnalysis inputModels) {
		super();
		this.inputModels = inputModels;
	}


	private InputModelsAccessAnalysis inputModels;
	
	
	@Override
	public BacktransformationStrategy createStrategy(Weakness weakness) {
		switch (weakness.getName()) {
		case "unencrypted_connection":
			return new UnencryptedConnectionBacktransformationStrategy(inputModels, inputModels.getRoot(), weakness);
		case "weak_encryption":
			return new WeakencryptionBacktransformationStrategy(inputModels, inputModels.getRoot(), weakness);
		case "hard_coded_key":
			return new HardCodedKeyBacktransformationStrategy(inputModels, inputModels.getRoot(), weakness);
		default:
			return null;
		}
	}

}
