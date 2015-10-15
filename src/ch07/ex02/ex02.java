package ch07.ex02;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class ex02 {
	public static String path = "./src/ch07/ex02/WarAndPeace.txt";

	public static void main(String[] args) throws IOException {

		String contents = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
		List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
		words.stream().filter(w -> w.length() > 12).map(w -> w.toLowerCase()).distinct().sorted().forEach(System.out::println);
	}
}
