package ch02.ex02;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CheckLimit {

	public static String path = "./src/ch02/ex02/java.txt";

	public static void main(String[] args) throws IOException {

		String contents = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
		List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
		AtomicInteger count = new AtomicInteger();

		words.stream().filter(w -> {
			System.out.println();
			System.out.println("filter:\t" + w);
			return w.length() > 3;
		}).limit(5).forEach(str -> System.out.println(count.incrementAndGet() + "limit:\t" + str));
	}
}
