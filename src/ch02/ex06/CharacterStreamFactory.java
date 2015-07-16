package ch02.ex06;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CharacterStreamFactory {
	public static Stream<Character> characterStream(String s) {
		return IntStream.rangeClosed(0, s.length() - 1).mapToObj(s::charAt);
	}

	public static void main(String[] args) {
		characterStream("Hello World!").forEach(System.out::print);
	}
}
