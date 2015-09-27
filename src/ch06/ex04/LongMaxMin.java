package ch06.ex04;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.LongAccumulator;

public class LongMaxMin {

	public static void main(String[] args){
		int size = 100000;
		
		Random r = new Random();
		long[] val = new long[size];
		for (int i = 0 ; i < size ; i++ ) {
			val[i] = r.nextLong();
		}
		System.out.println(max(val));
		System.out.println(min(val));
	}
	
	public static long max(long[] longs) {
        LongAccumulator max = new LongAccumulator(Long::max, Long.MIN_VALUE);
        Arrays.stream(longs).forEach(x -> max.accumulate(x));
        return max.get();
    }

    public static long min(long[] longs) {
        LongAccumulator max = new LongAccumulator(Long::min, Long.MAX_VALUE);
        Arrays.stream(longs).forEach(x -> max.accumulate(x));
        return max.get();
    }
}
