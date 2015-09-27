package ch05.ex06;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * 20世紀のすべての13日の金曜日を列挙せよ
 * 
 * @author haneda
 *
 */
public class Jason {
	public static void main(String[] args) {
		LocalDate start = LocalDate.of(1901,  1, 13);
		LocalDate end = LocalDate.of(2000, 12, 31);
		
        while (start.isBefore(end)) {
            if (start.getDayOfWeek() == DayOfWeek.FRIDAY) {
            	System.out.println(start);
            }
            start = start.plusMonths(1);
        }
	}
}
