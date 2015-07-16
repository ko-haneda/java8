package ch02.ex04;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStreamSample {

	public static void main(String[] args) {
		int[] values = { 1, 4, 9, 16 };
		Stream<int[]> stream = Stream.of(values);
		System.out.println(stream);
		// java.util.stream.ReferencePipeline$Head@2a139a55
		stream.forEach(System.out::println);
		//[I@1fb3ebeb

		IntStream intStream = IntStream.of(values);
		intStream.forEach(System.out::println);
		// 1 4 9 16
	}
}
