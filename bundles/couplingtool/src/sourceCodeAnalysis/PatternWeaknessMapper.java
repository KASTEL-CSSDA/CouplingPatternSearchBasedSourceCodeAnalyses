package sourceCodeAnalysis;

import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.Weakness;
import exceptions.GenerationException;
import exceptions.InputException;
import exceptions.PatternViolationClassException;

public interface PatternWeaknessMapper {

	/**
	 * interface for mapping the tool specific pattern violation name to an
	 * identifiable name.
	 * 
	 *
	 * @author sandro
	 * @throws PatternViolationClassException
	 * @throws GenerationException
	 * @throws InputException
	 * 
	 */
	public Weakness mapToolPatternToWeakness(String patternName)
			throws PatternViolationClassException, GenerationException, InputException;

}
