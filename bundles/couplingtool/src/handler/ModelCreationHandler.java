package handler;

import java.util.Collection;
import exceptions.GenerationException;
import exceptions.InputException;
import exceptions.PatternViolationClassException;
import exceptions.RefreshException;
import jdk.jshell.SourceCodeAnalysis;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.json.JSONException;
import architecture.ArchitectureGraphAnnotator;
import architecture.PCM.PCMGraphAnnotator;
import astGraphBuilder.spoon.SpoonASTGraphBuilder;
import utils.InputUtils;
import models.AnalysisModel;
import securityAnalysisCoupling.AnalysisCoupling;
import sourceCodeAnalysis.CodeAnalysis;
import sourceCodeAnalysis.PatternWeaknessMapper;
import sourceCodeAnalysis.SourceCodeAnalysisFactory;
import sourceCodeAnalysis.cognicrypt.CognicryptCodeAnalysis;
import sourceCodeAnalysis.cognicrypt.CognicryptPatternViolationMapper;

/**
 * inspired by
 * https://github.com/KASTEL-CSSDA/PCM2Java4Joana/tree/master/bundles/edu.kit.kastel.scbs.pcm2java4joana
 * 
 * This class is the handler for the plugin which is used to trigger the
 * analysis model generation and then the security coupling analysis is
 * performed.
 * 
 *
 */
public class ModelCreationHandler extends AbstractHandler {

	/**
	 * Executes the handler command to read and initialize the required model files
	 * and performs a security analysis on the selected files.
	 *
	 * @param event The execution event triggering the command.
	 * @return A collection of files that were analyzed. Is currently not used.
	 */
	@Override
	public Object execute(ExecutionEvent event) {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		Collection<IFile> list = InputUtils.getFilteredList(selection);

		
		
		
		IFile config = AnalysisModel.getConfig(list);
		
		
		if (config == null) {
			MessageDialog.openInformation(window.getShell(), "Information",
					"Es wurde keine .json datei übergeben für die Configuration übergeben");
			return null;
		}
		
		
		
		AnalysisModel models;
		try {
			models = AnalysisModel.createModelsFromConfig(config);
		} catch (InputException | JSONException e1) {
			MessageDialog.openError(window.getShell(), "Error", "Die Modelle konnten nicht eingelesen werden.");
			return null;
		}

		String savingPath = models.getBaseFolder().toAbsolutePath().toString();

		String sourceCodePath = models.getSourceCodePath();

		ArchitectureGraphAnnotator archGraphAnnotator = new PCMGraphAnnotator(models.getInputModels());

		String sourceCodeAnalysisName = models.getSourceCodeAnalysisName();
		
		CodeAnalysis sourceCodeAnalysis = null;
		PatternWeaknessMapper patternWeaknessMapper = null;
		try {
			sourceCodeAnalysis = SourceCodeAnalysisFactory.createAnalysis(sourceCodeAnalysisName);
			patternWeaknessMapper = SourceCodeAnalysisFactory.createPatternToWeaknessMapperForAnalysis(sourceCodeAnalysisName, models.getInputModels().getRoot());
		} catch (Exception e1) {
			System.out.println("No such source code analysis: " + sourceCodeAnalysisName);
			return null;
		}
	
		AnalysisCoupling securityCouplingAnalysis = new AnalysisCoupling(sourceCodeAnalysis,
				patternWeaknessMapper, sourceCodePath, new SpoonASTGraphBuilder(sourceCodePath),
				archGraphAnnotator);

		try {
			securityCouplingAnalysis.runSecurityCouplingAnalysis(sourceCodePath);
		} catch (GenerationException | PatternViolationClassException | InputException e) {

			e.printStackTrace();
		}
		return list;
	}

	/**
	 * Refreshes the project located at the specified path.
	 *
	 * @param projectPath The path to the project to be refreshed.
	 * @throws RefreshException If an error occurs while refreshing the project.
	 */
	private void refreshProject(IPath projectPath) throws RefreshException {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		try {
			IProjectDescription description = workspace.loadProjectDescription(projectPath.append(".project"));
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(description.getName());
			project.open(null);
			project.refreshLocal(1, null);
		} catch (CoreException e) {
			e.printStackTrace();
			throw new RefreshException(e.getMessage());
		}
	}
}
