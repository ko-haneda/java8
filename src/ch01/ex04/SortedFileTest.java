package ch01.ex04;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.Test;

public class SortedFileTest {

	public static File file = new File("./src/ch01/ex04/testSample");

	@Test
	public void testSortFile() {
		List<File> files = new SortedFile().sortFile(file.listFiles());
		assertTrue(files.get(0).toString().equals(".\\src\\ch01\\ex04\\testSample\\aaa"));
		assertTrue(files.get(1).toString().equals(".\\src\\ch01\\ex04\\testSample\\bbb"));
		assertTrue(files.get(2).toString().equals(".\\src\\ch01\\ex04\\testSample\\ccc"));
		assertTrue(files.get(3).toString().equals(".\\src\\ch01\\ex04\\testSample\\aaa.txt"));
		assertTrue(files.get(4).toString().equals(".\\src\\ch01\\ex04\\testSample\\bbb.txt"));
		assertTrue(files.get(5).toString().equals(".\\src\\ch01\\ex04\\testSample\\ccc.txt"));
		assertTrue(files.get(6).toString().equals(".\\src\\ch01\\ex04\\testSample\\eee.txt"));
		assertTrue(files.get(7).toString().equals(".\\src\\ch01\\ex04\\testSample\\ggg.txt"));
	}

}
