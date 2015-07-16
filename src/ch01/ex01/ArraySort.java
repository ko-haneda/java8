package ch01.ex01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraySort
{
	public List<String> sort(String[] words) {
		List<String> threads = new ArrayList<>();
		threads.add(Thread.currentThread().toString());
		Arrays.sort(words, (first, second) -> {
			threads.add(Thread.currentThread().toString());
			return Integer.compare(first.length(), second.length());
		});

		return threads;
	}

	//呼び出されたスレッドで実行される。
	public static void main(String[] args) {
		System.out.println(Thread.currentThread());
		String[] strs = { "cde", "abc", "bcd", "dkd", "grij", "fffl" };
		List<String> list = new ArraySort().sort(strs);
		list.forEach(System.out::println);
	}
}