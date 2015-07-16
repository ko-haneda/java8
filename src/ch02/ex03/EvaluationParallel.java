package ch02.ex03;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class EvaluationParallel {

	public static String path = "./src/ch02/ex03/WarAndPeace.txt";

	public static void main(String[] args) throws IOException {

		String contents = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
		List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

		long time1 = System.nanoTime();
		words.stream().filter(w -> w.length() > 3).count();
		time1 = System.nanoTime() - time1;
		System.out.println(time1);

		long time2 = System.nanoTime();
		words.parallelStream().filter(w -> w.length() > 3).count();
		time2 = System.nanoTime() - time2;
		System.out.println(time2);

		System.out.println("stream / parallelStream = " + (time1 / time2));
	}
}
