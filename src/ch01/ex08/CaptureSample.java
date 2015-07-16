package ch01.ex08;

import java.util.ArrayList;
import java.util.List;

public class CaptureSample {
	public static void sample1() {
		String[] names = { "Peter", "Paul", "Mary" };
		List<Runnable> runners = new ArrayList<>();
		for (String name : names) {
			runners.add(() -> System.out.println("sample1  " + name));
		}
		runners.forEach(r -> new Thread(r).start());
	}

	public static void sample2() {
		String[] names = { "Peter", "Paul", "Mary" };
		List<Runnable> runners = new ArrayList<>();
		for (int i = 0; i < names.length; i++) {
			int j = i;
			runners.add(() -> System.out.println("sample2  " + names[j]));
		}
		runners.forEach(r -> new Thread(r).start());
	}

	public static void main(String[] args) {
		sample1();
		sample2();
		//共に異なる値をキャプチャする？
	}
}
