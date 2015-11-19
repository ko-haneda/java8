package ch09.ex05;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReverseCharReader {
	public static void main(String[] args) {

		try {
			byte[] origin = Files.readAllBytes(Paths.get("./src/ch09/ex05/WarAndPeace.txt"));
			byte[] reversed = new byte[origin.length];
			for (int i = 0; i < origin.length; i++) {
				reversed[i] = origin[origin.length - 1 - i];
			}
			Files.write(Paths.get(new File("./src/ch09/ex05/out.txt").toURI()), reversed);
		} catch (IOException ex) {
			System.out.println(ex);
		}
	}
}
