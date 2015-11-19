package ch08.ex15;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class GrepUtil {
	public static void main(String[] args) throws IOException {
		Predicate<String> predicate = Pattern.compile("[A-C]{2,}").asPredicate();

		Files.lines(Paths.get("./src/ch08/ex15/WarAndPeace.txt")).filter(predicate).forEach(System.out::println);
	}
}
//*** START OF THIS PROJECT GUTENBERG EBOOK WAR AND PEACE ***
//WAR AND PEACE
//are equal; please note that the angle ABC..."

//上記は下記の用語でひっかかっている。
//PEACE
//PEACE
//ABC