package ch05.ex09;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.stream.Collectors;

public class TimeDifference {
	public static void main(String[] args) {
		Instant now = LocalDateTime.now().toInstant(ZoneOffset.UTC);//日本時間が取得されているがこういうものなのか。
		System.out.println(now);
		System.out.println("----------------------------");
		ZoneId.getAvailableZoneIds().stream()
				.map(w -> ZoneId.of(w))
				.map(w -> now.atZone(w))
				.filter(w -> (w.getOffset().getTotalSeconds() < 3600 ) && (w.getOffset().getTotalSeconds() > -3600 ))
				.map(w -> w.getZone())
				.collect(Collectors.toList())
				.forEach(System.out::println);
	}
	/**
		GMT
		Etc/GMT-0
		Atlantic/St_Helena
		Etc/GMT+0
		Africa/Banjul
		Etc/GMT
		Africa/Freetown
		Africa/Bamako
		Africa/Conakry
		Universal
		Africa/Sao_Tome
		Africa/Nouakchott
		UTC
		Etc/Universal
		Atlantic/Azores
		Africa/Abidjan
		Africa/Accra
		Etc/UCT
		GMT0
		Zulu
		Africa/Ouagadougou
		Atlantic/Reykjavik
		Etc/Zulu
		Iceland
		Africa/Lome
		Greenwich
		Etc/GMT0
		America/Danmarkshavn
		Africa/Dakar
		America/Scoresbysund
		Africa/Bissau
		Etc/Greenwich
		Africa/Timbuktu
		UCT
		Africa/Monrovia
		Etc/UTC
	 */
}
