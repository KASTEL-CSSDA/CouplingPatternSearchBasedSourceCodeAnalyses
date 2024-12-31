package architecture.PCM.backtransformation;

import java.util.Collection;

import architecture.PCM.EdgeLinkCorrespondence;
import architecture.PCM.InputModelsAccessAnalysis;
import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.SecurityCharacteristicWeaknessMappingRoot;
import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.Weakness;
import securityAnalysisCoupling.BacktransformationFactory;
import securityAnalysisCoupling.BacktransformationStrategy;

public abstract class BacktransformationStrategyAccessAnalysis implements BacktransformationStrategy{





	protected final InputModelsAccessAnalysis inputModels;
	protected final SecurityCharacteristicWeaknessMappingRoot mappingRoot;
	protected final Weakness targetWeakness;
	
	public BacktransformationStrategyAccessAnalysis(InputModelsAccessAnalysis inputModels,
			SecurityCharacteristicWeaknessMappingRoot mappingRoot, Weakness targetWeakness) {
		super();
		this.inputModels = inputModels;
		this.mappingRoot = mappingRoot;
		this.targetWeakness = targetWeakness;
	}
	
	public abstract void transformWeaknessForCorrespondence(Weakness weakness, EdgeLinkCorrespondence correspondence);
	
}
