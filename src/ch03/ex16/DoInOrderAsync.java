package ch03.ex16;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

/**
 * 
 * 問１　うまいユースケースを示しなさい
 *
 *
 * 問２　３つめのパラメータ（Consumer<Throwable> handler）は必要ですか。
 * 答　　不要
 */
public class DoInOrderAsync {
	public static <T> void doInOrderAsync(Supplier<T> first, BiConsumer<T, Throwable> second)
	{
		new Thread(
				() -> {
					T result = null;
					try {
						result = first.get();
						second.accept(result, null);
					} catch (Throwable th) {
						second.accept(result, th);
					}
				}).start();
	}	
}



