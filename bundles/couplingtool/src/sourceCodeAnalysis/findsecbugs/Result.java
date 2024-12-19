package sourceCodeAnalysis.findsecbugs;

import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.Weakness;
import sourceCodeAnalysis.AbstractResult;

public class Result extends AbstractResult{

	public Result(Weakness weakness, String methodName, String className, int startCodeLine, int endCodeLine) {
		super(weakness, methodName, className, startCodeLine, endCodeLine);
		// TODO Auto-generated constructor stub
	}

}
