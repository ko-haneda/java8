package ch09.ex06;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class ReverseLineReader {
	public static void main(String[] args) {
		try {
			List<String> origin = Files.readAllLines(Paths.get("./src/ch09/ex06/WarAndPeace.txt"));
			Collections.reverse(origin);
			Files.write(Paths.get("./src/ch09/ex06/out.txt"), origin);
		} catch (IOException ex) {
			System.out.println(ex);
		}
	}
}
