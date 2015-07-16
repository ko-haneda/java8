package ch01.ex04;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class SortedFile {
	public List<File> sortFile(File[] files) {
		Arrays.sort(files, (file1, file2) -> {
			if (file1.isDirectory() && !file2.isDirectory()) {
				return -1;
			} else if (!file1.isDirectory() && file2.isDirectory()) {
				return 1;
			} else {
				return file1.getName().compareTo(file2.getName());
			}
		});
		return Arrays.asList(files);
	}
}
