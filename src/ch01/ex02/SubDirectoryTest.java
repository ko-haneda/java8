package ch01.ex02;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SubDirectoryTest {

	public static File file = new File("./");

	@Test
	public void testGetSubDirectory1() {
		List<File> result = new SubDirectory().getSubDirectory1(new ArrayList<>(), file);
		assertNotNull(result);
		result.forEach(f -> assertTrue(f.isDirectory()));
		result.forEach(System.out::println);
	}

	@Test
	public void testGetSubDirector2() {
		List<File> result = new SubDirectory().getSubDirectory2(new ArrayList<>(), file);
		assertNotNull(result);
		result.forEach(f -> assertTrue(f.isDirectory()));
	}
}
