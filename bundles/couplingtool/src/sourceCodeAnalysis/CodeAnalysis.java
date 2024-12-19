package sourceCodeAnalysis;

import java.util.List;

/**
 * This interface defines a contract for running code analysis on a given source
 * code file. Implementing classes are expected to provide implementations for
 * the runCodeAnalysis method to perform code analysis and return a list of
 * abstract results.
 */
public interface CodeAnalysis {
	/**
	 * Runs code analysis on the specified source code file and returns a list of
	 * abstract results representing the analysis outcomes.
	 *
	 * @param sourceCodeFilePath The path to the source code file to be analyzed.
	 * @return A list of abstract results from the code analysis.
	 */
	public List<AbstractResult> runCodeAnalysis(String sourceCodeFilePath, PatternWeaknessMapper patternWeaknessMapper);

}
