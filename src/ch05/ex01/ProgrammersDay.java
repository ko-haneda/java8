package ch05.ex01;

import java.time.LocalDate;

/**
 * 
 * プラスを使わないでプログラマーの日をもとめなさい。
 * →西暦を入力値として、月日を返すようなメソッドを作成する。（閏年考慮すること）
 * @author haneda
 *
 */
public class ProgrammersDay {
	public static void main(String[] args) {
		//通常1 09月13日
		System.out.println(getYearDay(2014));
		//通常2 09月13日
		System.out.println(getYearDay(1900));
		//閏年1 09月13日
		System.out.println(getYearDay(2012));
		//閏年2 09月13日
		System.out.println(getYearDay(2000));
	}
	
	/**
	 * 
	 * @param year
	 * @return
	 */
	public static LocalDate getYearDay(int year) {
		return LocalDate.ofYearDay(year, 256);
	}
}
