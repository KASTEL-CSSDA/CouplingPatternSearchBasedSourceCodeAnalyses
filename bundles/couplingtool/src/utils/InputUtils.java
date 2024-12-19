package utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;

public final class InputUtils {
	private InputUtils() {

	}

	@SuppressWarnings("unchecked")
	public static Collection<IFile> getFilteredList(ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;

			return (List<IFile>) structuredSelection.toList().stream().filter(file -> file instanceof IFile)
					.map(IFile.class::cast).collect(Collectors.toList());
		}
		return new ArrayList<IFile>();
	}
}
