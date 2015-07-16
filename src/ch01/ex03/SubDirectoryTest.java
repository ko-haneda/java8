package ch01.ex03;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.Test;

public class SubDirectoryTest {

	public static File file = new File("./src/ch01/ex03/testSample");

	@Test
	public void testGetSubDirectory() {
		List<File> result = new SubDirectory().getSubDirectory(file, ".txt");
		assertNotNull(result);
		result.forEach(f -> assertTrue(!f.isDirectory()));
		result.forEach(System.out::println);
	}

}
