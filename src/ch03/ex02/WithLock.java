package ch03.ex02;

import java.util.concurrent.locks.ReentrantLock;

public class WithLock {

	//TODO 下記の方法ではロックしようがしまいが結果に変わりない。
	public static void withLock(ReentrantLock myLock, Runnable r) {
		myLock.lock();
		try {
			r.run();
		} finally {
			myLock.unlock();
		}
	}

	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		withLock(lock, () -> {
			for (int i = 0; i < 100000; i++) {
				System.out.println("i");
			}
		});
		withLock(lock, () -> {
			for (int i = 0; i < 100000; i++) {
				System.out.println("j");
			}
		});
		withLock(lock, () -> {
			for (int i = 0; i < 100000; i++) {
				System.out.println("k");
			}
		});
	}
}