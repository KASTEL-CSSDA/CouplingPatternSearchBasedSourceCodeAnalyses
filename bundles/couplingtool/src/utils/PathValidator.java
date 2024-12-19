package utils;

import java.io.File;

import exceptions.InputException;

public class PathValidator {
	/**
	 * Validates whether the given path is valid and points to an existing file.
	 *
	 * @param path The path to be validated.
	 * @throws InputException If the path is invalid or does not exist.
	 */
	public static void validatePath(String path) throws InputException {
		File directory = new File(path);

		if (!directory.exists() || directory.isDirectory()) {
			throw new InputException("Invalid or non-existent path: " + path);
		}
	}
}
