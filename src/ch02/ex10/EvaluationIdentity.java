package ch02.ex10;

import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

//count()で割ること？？
public class EvaluationIdentity {

	//returnしたものがresultに入るためうまくいかない。
	public static double averageNG(Stream<Double> stream) {
		AtomicLong count = new AtomicLong();
		double ave = stream.reduce(0.0, (result, element) -> {
			result = result + element;
			return result / count.incrementAndGet();
		});
		return ave;
	}

	public static double averageOK(Stream<Double> stream) {
		AtomicLong count = new AtomicLong();
		double ave = stream.reduce(0.0, (result, element) -> {
			result = result * count.get() + element;
			return result / count.incrementAndGet();
		});
		return ave;
	}

	public static void main(String[] args) {
		System.out.println(averageNG(Stream.of(1.0, 2.0, 3.0, 4.0)));
		System.out.println(averageOK(Stream.of(1.0, 2.0, 3.0, 4.0)));
	}
}
