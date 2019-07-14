package tark.matt.restful.NFLYearRestfulAPI;

import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class YearOfCurrentNFLSeasonService {
	
	public static void main(String[] args) {
		SpringApplication.run(YearOfCurrentNFLSeasonService.class, args);
	}

}

@RestController
class NFLYearController {

	private static final int MONTH_OF_JUNE = Month.JULY.getValue();
	private static final int FIRST_DAY = 1;
	
	@RequestMapping(value="/getCurrentSeason", produces = "text/plain")
	String getCurrentSeasonYear() {
		
		// get the date/time now
		ZonedDateTime currentDate = ZonedDateTime.now(ZoneId.of("America/New_York"));
		
		// params: Year, Month, Day, Hours, Mins, Secs, Millis, Zone
		ZonedDateTime julyFirst = ZonedDateTime.of(currentDate.getYear(), MONTH_OF_JUNE, FIRST_DAY, 0, 0, 0, 0, ZoneId.of("America/New_York"));

		// if the current date is before July 1st, use the previous year.
		// Else, add one to the year.
		if (currentDate.compareTo(julyFirst) < 0) {
			ZonedDateTime newDate = currentDate.minusYears(1);
		}
		
		return Integer.toString(currentDate.getYear());
		
	}
	
}
