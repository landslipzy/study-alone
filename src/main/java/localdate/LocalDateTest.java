package localdate;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * @author zhongying
 * @description
 * @date 2020/10/28
 */
public class LocalDateTest {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDateTime now1 = LocalDateTime.now();
        Duration threeMinutes = Duration.ofMinutes(3);
        Duration threeMinutes2 = Duration.of(3, ChronoUnit.MINUTES);

        Period tenDays = Period.ofDays(10);
        Period threeWeeks = Period.ofWeeks(3);
        Period twoYearsSixMonthsOneDay = Period.of(2, 6, 1);
        System.out.println(now1);
    }
}
