package ch05.ex07;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;

public class TimeIntervalTest {
	TimeInterval interval1;
	{
		//2015年09月1日の10時から11時の予定を作成
		LocalDateTime start = LocalDateTime.of(2015, 9, 1, 10, 0);
		LocalDateTime end = LocalDateTime.of(2015, 9, 1, 11, 0);
		interval1 = new TimeInterval(start, end);
	}
	
	//2015年09月1日の11時から12時の予定を作成
	@Test
	public void tesOverlapt1() {
		LocalDateTime start = LocalDateTime.of(2015, 9, 1, 11, 0);
		LocalDateTime end = LocalDateTime.of(2015, 9, 1, 12, 0);
		TimeInterval interval2 = new TimeInterval(start, end);
		assertFalse(interval1.overlap(interval2));
	}
	//2015年09月1日の09時から10時の予定を作成
	@Test
	public void tesOverlapt2() {
		LocalDateTime start = LocalDateTime.of(2015, 9, 1, 9, 0);
		LocalDateTime end = LocalDateTime.of(2015, 9, 1, 10, 0);
		TimeInterval interval2 = new TimeInterval(start, end);
		assertFalse(interval1.overlap(interval2));
	}
	
	//2015年09月1日の09時から10時30分の予定を作成
	@Test
	public void tesOverlapt3() {
		LocalDateTime start = LocalDateTime.of(2015, 9, 1, 9, 0);
		LocalDateTime end = LocalDateTime.of(2015, 9, 1, 10, 30);
		TimeInterval interval2 = new TimeInterval(start, end);
		assertTrue(interval1.overlap(interval2));
	}
	
	//2015年09月1日の10時30分から12時の予定を作成
	@Test
	public void tesOverlapt4() {
		LocalDateTime start = LocalDateTime.of(2015, 9, 1, 10, 30);
		LocalDateTime end = LocalDateTime.of(2015, 9, 1, 12, 0);
		TimeInterval interval2 = new TimeInterval(start, end);
		assertTrue(interval1.overlap(interval2));	}
	
	//2015年09月1日の10時30分から10時45分の予定を作成
	@Test
	public void tesOverlapt5() {
		LocalDateTime start = LocalDateTime.of(2015, 9, 1, 10, 30);
		LocalDateTime end = LocalDateTime.of(2015, 9, 1, 10, 45);
		TimeInterval interval2 = new TimeInterval(start, end);
		assertTrue(interval1.overlap(interval2));
	}
	
	//2015年09月1日の10時から11時の予定を作成
	@Test
	public void tesOverlapt6() {
		LocalDateTime start = LocalDateTime.of(2015, 9, 1, 10, 0);
		LocalDateTime end = LocalDateTime.of(2015, 9, 1, 11, 0);
		TimeInterval interval2 = new TimeInterval(start, end);
		assertTrue(interval1.overlap(interval2));	}
	
	//2015年08月1日の10時から11時の予定を作成
	@Test
	public void tesOverlapt7() {
		LocalDateTime start = LocalDateTime.of(2015, 8, 1, 10, 0);
		LocalDateTime end = LocalDateTime.of(2015, 8, 1, 11, 0);
		TimeInterval interval2 = new TimeInterval(start, end);
		assertFalse(interval1.overlap(interval2));
	}
	//2015年08月1日の10時から2015年10月1日の11時の予定を作成
	@Test
	public void tesOverlapt8() {
		LocalDateTime start = LocalDateTime.of(2015, 8, 1, 10, 0);
		LocalDateTime end = LocalDateTime.of(2015, 10, 1, 11, 0);
		TimeInterval interval2 = new TimeInterval(start, end);
		assertTrue(interval1.overlap(interval2));
	}

}
