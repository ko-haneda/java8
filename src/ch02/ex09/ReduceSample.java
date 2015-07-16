package ch02.ex09;

import java.util.ArrayList;
import java.util.stream.Stream;

public class ReduceSample<T> {

	// reduce(BinaryOperator<T> accumulator)
	public ArrayList<T> toArrayList1(Stream<ArrayList<T>> source) {
		return source.reduce((x, y) -> {
			x = new ArrayList<>();
			x.addAll(y);
			return x;
		}).orElse(new ArrayList<>());
	}

	// reduce(T identity, BinaryOperator<T> accumulator)
	public ArrayList<T> toArrayList2(Stream<ArrayList<T>> source) {
		return source.reduce(new ArrayList<>(), (x, y) -> {
			x = new ArrayList<>();
			x.addAll(y);
			return x;
		});
	}

	// reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)
	public ArrayList<T> toArrayList3(Stream<ArrayList<T>> source) {
		return source.reduce(new ArrayList<>(), (x, y) -> {
			x.addAll(y);
			return x;
		}, (x, y) -> {
			x.addAll(y);
			return x;
		});
	}

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		Stream<ArrayList<String>> stream;
		stream = Stream.of(list);
		ArrayList<String> array1 = new ReduceSample<String>().toArrayList1(stream);
		for (String str : array1) {
			System.out.println(str);
		}
		stream = Stream.of(list);
		ArrayList<String> array2 = new ReduceSample<String>().toArrayList2(stream);
		for (String str : array2) {
			System.out.println(str);
		}

		stream = Stream.of(list);
		ArrayList<String> array3 = new ReduceSample<String>().toArrayList3(stream);
		for (String str : array3) {
			System.out.println(str);
		}

	}
}
