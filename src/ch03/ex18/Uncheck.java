package ch03.ex18;

import java.util.function.Function;

public class Uncheck {

	public interface ThrowableFunction<T, U> {
		U apply(T t) throws Exception;
	}

	public static <T, U> Function<T, U> unchecked(ThrowableFunction<T, U> f) {
		return (t) -> {
			try {
				return f.apply(t);
			} catch (Throwable th) {
				throw new RuntimeException(th);
			}
		};
	}

	public static void main(String[] args) {
		try {
			unchecked(t -> { throw new Exception();}).apply(new Object());
		} catch (RuntimeException e) {
			System.out.println("success");
		} catch (Throwable t) {
			System.out.println("fail");
		}

	}
}
