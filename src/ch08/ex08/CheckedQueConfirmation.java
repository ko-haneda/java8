package ch08.ex08;

import java.nio.file.Paths;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class CheckedQueConfirmation {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		Queue que1 = new LinkedList<>();
		que1.add("string");
		System.out.println("que=" + que1);
		que1.add(Paths.get("path"));
		System.out.println("que=" + que1);

		Queue que2 = Collections.checkedQueue(que1, String.class);
		try {
			que2.add("string");
			System.out.println("que=" + que1);
			que2.add(Paths.get("path"));
			System.out.println("que=" + que1);
		} catch (ClassCastException e) {
			System.out.println("error");
		}
		//メリット
		//addするタイミングでエラーに気付ける。
	}
}
