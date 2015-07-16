package ch02.ex12;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CheckAtomic {

	public static String path = "./src/ch02/ex12/WarAndPeace.txt";

	public static void main(String[] args) throws IOException {

		String contents = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
		List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
		AtomicInteger[] shortWords = new AtomicInteger[12];
		for (int i = 0; i < 12; i++) {
			shortWords[i] = new AtomicInteger();
		}

		words.stream().parallel().forEach(s -> {if(s.length() < 12) shortWords[s.length()].getAndIncrement();});
		System.out.println(Arrays.toString(shortWords));
	}

}
