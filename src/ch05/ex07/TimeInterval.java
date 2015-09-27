package ch05.ex07;

import java.time.LocalDateTime;

/**
 * カレンダーの予定が重複していないか確かめるメソッドを作成する。
 * →二つのインターバルが重なっていないか確かめる。
 * 
 * @author haneda
 *
 */
public class TimeInterval {
	LocalDateTime start;
	LocalDateTime end;
	
	public TimeInterval(LocalDateTime start, LocalDateTime end){
		this.start = start;
		this.end = end;
	}
	
	public boolean overlap(TimeInterval other){
		if(end.isEqual(other.start))	return false;
		if(end.isBefore(other.start))	return false;
		if(start.isEqual(other.end))	return false;
		if(start.isAfter(other.end))	return false;
		return true;
	}
}
