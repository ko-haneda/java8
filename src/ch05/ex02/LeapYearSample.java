package ch05.ex02;

import java.time.LocalDate;

/**
 * 
 * 閏年に年を加算するとどのようになるか確かめる。
 * 
 * @author haneda
 *
 */
public class LeapYearSample {

	public static void main(String[] args) {
		LocalDate date1 = LocalDate.of(2000, 2, 29);
		LocalDate date2 = date1.plusYears(1);
		LocalDate date3 = date1.plusYears(4);
		LocalDate date4 = date1.plusYears(1).plusYears(1).plusYears(1).plusYears(1);
		System.out.println("1.\t" + date1);
		System.out.println("2.\t" + date2);
		System.out.println("3.\t" + date3);
		System.out.println("4.\t" + date4);
		/**
		 * 結果----------------------
		 * 1.	2000-02-29
		 * 2.	2001-02-28
		 * 3.	2004-02-29
		 * 4.	2004-02-28
		 * --------------------------
		 * 
		 * 2. 閏年ではないので2月28日になる
		 * 3. 閏年なので2月29日になる
		 * 4. plusYearsはLocalDateのコピーを返すので、
		 *    2000-02-29 → 2001-02-28 → 2002-02-28 → 2003-02-28 → 2004-02-28となり
		 *    閏年の2月28日になる
		 */
	}
}
