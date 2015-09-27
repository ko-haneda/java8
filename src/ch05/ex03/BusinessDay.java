package ch05.ex03;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.function.Predicate;

/**
 * 
 * 下記のnextメソッドに渡された述語を満足する翌日の日付を生成する。
 * today.with(next(w -> w.getDayOfWeek().getValue() < 6));
 * →次の営業日(土日以外、祝日は含まない)を返すnextメソッドを作成する。
 * @author haneda
 *
 */
public class BusinessDay {

    public static void main(String[] args) {
    	LocalDate today1 = LocalDate.of(2015, 9, 24);//木曜日
    	LocalDate today2 = LocalDate.of(2015, 9, 25);//金曜日
    	LocalDate today3 = LocalDate.of(2015, 9, 26);//土曜日
    	LocalDate today4 = LocalDate.of(2015, 9, 27);//日曜日
        LocalDate next1 = today1.with(next(w -> w.getDayOfWeek().getValue() < 6));
        LocalDate next2 = today2.with(next(w -> w.getDayOfWeek().getValue() < 6));
        LocalDate next3 = today3.with(next(w -> w.getDayOfWeek().getValue() < 6));
        LocalDate next4 = today4.with(next(w -> w.getDayOfWeek().getValue() < 6));
        System.out.println("------------test1------------");
        System.out.println(today1);
        System.out.println(next1);
        System.out.println("------------test2------------");
        System.out.println(today2);
        System.out.println(next2);
        System.out.println("------------test3------------");
        System.out.println(today3);
        System.out.println(next3);
        System.out.println("------------test4------------");
        System.out.println(today4);
        System.out.println(next4);
    }

    public static TemporalAdjuster next(Predicate<LocalDate> predicate) {
        return TemporalAdjusters.ofDateAdjuster(w -> {
            do {
                w = w.plusDays(1);
            } while (!predicate.test(w));
            return w;
        });
    }
}
