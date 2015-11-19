package ch09.ex07;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WebPageReader {
	public static void main(String[] args) {
		try {
			Files.copy(new URL("https://ja.wikipedia.org/wiki/Java").openStream(), Paths.get("./src/ch09/ex07/out.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
