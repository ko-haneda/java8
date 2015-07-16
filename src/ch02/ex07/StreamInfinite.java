package ch02.ex07;

import java.util.stream.Stream;

public class StreamInfinite {
	public static <T> boolean isFinite(Stream<T> stream) {
		return stream.spliterator().getExactSizeIfKnown() != -1;
	}

	public static void main(String[] args) {
		Stream<String> song = Stream.of("gently", "dowwn", "the", "stream");
		Stream<String> echos = Stream.generate(() -> "Echo");
		System.out.println(isFinite(song));
		System.out.println(isFinite(echos));
		//spliterator()が終端操作であるため、streamが使用できないから。
		System.out.println(isFinite(song));
	}
}
