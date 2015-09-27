package ch06.ex03;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class Benchmark {
	private static final int threadNum = 1000;
	private static final int count = 100_000;

	public static void main(String[] args) {
		System.out.println("AtomicLong : " + measureAtomicLong());
		System.out.println("LongAdder  : " + measureLongAdder());
		/**
		 AtomicLong : 2335
		 LongAdder  : 517
		 */
	}

	public static long measureAtomicLong() {
		AtomicLong counter = new AtomicLong();
		List<Thread> threads = new ArrayList<>();
		for (int i = 0; i < threadNum; i++) {
			threads.add(new Thread(() -> {
				for (int j = 0; j < count; j++) {
					counter.incrementAndGet();
				}
			}));
		}
		return checkPerformance(threads);
	}

	public static long measureLongAdder() {
		LongAdder counter = new LongAdder();
		List<Thread> threads = new ArrayList<>();
		for (int i = 0; i < threadNum; i++) {
			threads.add(new Thread(() -> {
				for (int j = 0; j < count; j++) {
					counter.increment();
				}
			}));
		}
		return checkPerformance(threads);
	}

	private static long checkPerformance(List<Thread> threads) {
		Instant start = Instant.now();
		threads.stream().forEach(t -> t.start());
		threads.stream().forEach(t -> {
			try {
				t.join();
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		});
		Instant end = Instant.now();
		return Duration.between(start, end).toMillis();
	}
}
