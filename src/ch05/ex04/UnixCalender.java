package ch05.ex04;

import java.time.LocalDate;
/**
 * 
 * カレンダーを表示するプログラムを作成しなさい。
 * →年月をinputとし、日曜日が右端に表示するものを作成する。
 * 
 * @author haneda
 *
 */
public class UnixCalender {


	//TODO エラー処理をすること。
	//コマンド引数のチェック→引数が二つかどうか、正しい数値かどうか
	public static void main(String[] args) {
		int month = Integer.parseInt(args[0]);
        int year = Integer.parseInt(args[1]);
        
		LocalDate date = LocalDate.of(year, month, 1);
		int day = date.getDayOfWeek().getValue() - 1; //曜日を取得
		int day_end = date.plusMonths(1).minusDays(1).getDayOfMonth(); //月の最後の日を取得
		StringBuilder str = new StringBuilder();
		for(int i = 0; i < day; i++){
			str.append("   ");
		}
		for(int i = 1; i <= day_end; i++){
			if(i < 10){
				str.append(" ");
			}
			str.append(i + " ");
			if((day + i) %  7 == 0){
				str.append("\n");
			}
		}
		System.out.println(str);
	}
}
