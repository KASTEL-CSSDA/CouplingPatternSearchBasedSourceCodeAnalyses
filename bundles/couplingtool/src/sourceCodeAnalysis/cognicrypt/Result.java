package sourceCodeAnalysis.cognicrypt;

import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.Weakness;
import sourceCodeAnalysis.AbstractResult;

/**
 * Constructs a new Result object from a specific tool with the specified
 * parameters.
 *
 * @param violatedClass The name of the class where the violation occurred. This
 *                      is tool specific.
 * @param methodName    The name of the method associated with the violation.
 * @param className     The name of the class containing the violation.
 * @param startCodeLine The starting line number of the violation in the source
 *                      code.
 * @param endCodeLine   The ending line number of the violation in the source
 *                      code.
 * 
 */
public class Result extends AbstractResult {

	public Result(Weakness weakness, String methodName, String className, int startCodeLine, int endCodeLine,
			boolean isMoreThanOneLine) {
		super(weakness, methodName, className, startCodeLine, endCodeLine);

	}

}
