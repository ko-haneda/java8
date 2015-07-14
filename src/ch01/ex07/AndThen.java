package ch01.ex07;

public class AndThen {
	public static Runnable andThen(Runnable first, Runnable second) {
		return () -> {
			first.run();
			second.run();
		};
	}

	public static void main(String[] args) {
		new Thread(andThen(
				()->{int i = 0; while(i < 10000)System.out.println("thread1  " + i++);},
				()->{int i = 0; while(i < 10000)System.out.println("thread2  " + i++);}
				)
				).start();
	}
}
