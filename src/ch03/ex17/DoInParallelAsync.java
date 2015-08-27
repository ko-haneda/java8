package ch03.ex17;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class DoInParallelAsync<T, U> {
	public static void main(String[] args) {
		doInParallelAsync(()->{
			for(int i = 0; i < 10000; i++){
				System.out.println("test1");
			}
		},()->{
			for(int i = 0; i < 10000; i++){
				System.out.println("test2");
			}
		},(t)->{
			System.out.println("test3" + t.getMessage());
			
		});
	}

	public static <T> void doInParallelAsync(Runnable first, Runnable second, Consumer<Throwable> handler) {
		ExecutorService service = Executors.newCachedThreadPool();
		service.submit(() -> {
			try {
				first.run();
			} catch (Throwable t) {
				handler.accept(t);
			}
		});
		service.submit(() -> {
			try {
				second.run();
//				throw new Exception();
			} catch (Throwable t) {
				handler.accept(t);
			}
		});
		service.shutdown();
	}
}
