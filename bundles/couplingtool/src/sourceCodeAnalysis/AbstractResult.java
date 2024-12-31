package sourceCodeAnalysis;

import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.Weakness;

/**
 * An abstract base class representing the result of an analysis performed by a
 * specific tool. It provides information about a pattern violation.
 */

public class AbstractResult {
	private Weakness weakness;
	private String methodName;
	private String className;
	private int startCodeLine;
	private int endCodeLine;

	/**
	 * Constructs a new AbstractResult object.
	 *
	 * @param weakness The weakness
	 * @param methodName    The name of the affected method.
	 * @param className     The name of the affected class.
	 * @param startCodeLine The starting line number of the result in the source
	 *                      code.
	 * @param endCodeLine   The ending line number of the result in the source code.
	 */
	public AbstractResult(Weakness weakness, String methodName, String className, int startCodeLine,
			int endCodeLine) {
		this.weakness = weakness;
		this.methodName = methodName;
		this.className = className;
		this.startCodeLine = startCodeLine;
		this.endCodeLine = endCodeLine;

	}

	public int getStartCodeLine() {
		return startCodeLine;
	}

	public int getEndCodeLine() {
		return endCodeLine;
	}

	public Weakness getWeakness() {
		return weakness;
	}

	public String getMethodName() {
		return methodName;
	}

	public String getClassName() {
		return className;
	}

}
