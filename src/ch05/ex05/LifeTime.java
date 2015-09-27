package ch05.ex05;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * 
 * 今までに生きてきた日数を表示するプログラムを作成せよ
 * 
 * @author haneda
 *
 */
public class LifeTime {
	public static void main(String[] args) {
		LocalDateTime birthday = LocalDateTime.of(1988, 10, 3, 0, 0);
		LocalDateTime today = LocalDateTime.now();
		long days = Duration.between(birthday, today).toDays();
		System.out.println(days);
	}
}
