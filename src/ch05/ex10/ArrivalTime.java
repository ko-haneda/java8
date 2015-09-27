package ch05.ex10;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAmount;

public class ArrivalTime {
	public static void main(String[]args) {
		ZoneId startZone = ZoneId.of("America/Los_Angeles");
		ZoneId endZone = ZoneId.of("CET"); //Germany Time: Central European Time (CET)
		TemporalAmount travelTime = Duration.ofMinutes(650);
		LocalDateTime startTime = LocalDateTime.of(2015, 9, 1, 3, 5); 

		System.out.println(new ArrivalTime().calcArrivalTime(startZone, endZone, travelTime, startTime));
	}
	
	ZonedDateTime calcArrivalTime(ZoneId startZone, ZoneId endZone, TemporalAmount travelTime, LocalDateTime startTime){
		return ZonedDateTime.of(startTime, startZone).plus(travelTime).withZoneSameLocal(endZone);
	}
}
