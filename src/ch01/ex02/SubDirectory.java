package ch01.ex02;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class SubDirectory {

	public List<File> getSubDirectory1(List<File> allDirs, File file) {
		List<File> subDirs = Arrays.asList(file.listFiles(path -> path.isDirectory()));
		allDirs.addAll(subDirs);
        subDirs.forEach(d -> getSubDirectory1(allDirs, d));
		return allDirs;
	}

	public List<File> getSubDirectory2(List<File> allDirs, File file) {
		List<File> subDirs = Arrays.asList(file.listFiles(File::isDirectory));
		allDirs.addAll(subDirs);
        subDirs.forEach(d -> getSubDirectory2(allDirs, d));
		return allDirs;
    }

}