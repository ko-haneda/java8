package ch03.ex24;

import java.util.function.Function;
import java.util.stream.Stream;

public class Pair<T> {
	private T first;
	private T second;

	public Pair(T first, T second) {
		this.first = first;
		this.second = second;
	}

	public <R> Pair<R> map(Function<? super T, ? extends R> mapper) {
		return new Pair<>(mapper.apply(first), mapper.apply(second));
	}

	//わからない。
	public <R> Pair<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper) {
		return null;
	}
}