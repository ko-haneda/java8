package ch01.ex06;

public class UnCheckRunnable {
	public interface RunnableEx {
		void run() throws Exception;
	}

	public static Runnable unCheck(RunnableEx runner) {
		return () -> {
			try {
				runner.run();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		};
	}

	public static void main(String[] args) {
		new Thread(unCheck(() -> {
			System.out.println("zzz");
			Thread.sleep(1000);
		})).start();

//		下記はコンパイルエラー
//		new Thread(() -> {
//			System.out.println("zzz");
//			Thread.sleep(1000);
//			}
//		}).start();
	}
}
