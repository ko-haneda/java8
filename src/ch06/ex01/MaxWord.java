package ch06.ex01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 
 * 
 * @author haneda
 *
 */
public class MaxWord {

	public static String path = "./src/ch06/ex01/WarAndPeace.txt";

	public static void main(String[] args) {
		try {
			String contents = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
			List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
			System.out.println(getMaxWord(words));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getMaxWord(List<String> words) {
		int threadNum = 100; //100個のスレッドを作成する。
		AtomicReference<String> maxWord = new AtomicReference<>("");
		List<Thread> threads = new ArrayList<>();
		
		for(int i = 0; i < threadNum; i++){
			int devidedword = words.size() / threadNum; //１スレッドが担当するワード数
			int start = i * devidedword;
			int end = (i + 1) * devidedword;
			threads.add(new Thread(() -> {
				for (int j = start; j < end; j++) {
					maxWord.accumulateAndGet(words.get(j), (x, y) ->x.length() > y.length() ? x : y);
				}
			}));
		}

		threads.stream().forEach(t -> t.start());
		threads.stream().forEach(t -> {
			try {
				t.join();
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		});
		return maxWord.get();
	}
}
