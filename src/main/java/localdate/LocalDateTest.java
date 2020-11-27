package localdate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 * @author zhongying
 * @description
 * @date 2020/10/28
 */
public class LocalDateTest {
    public static void main(String[] args) {
        LocalDate now1 = LocalDate.of(2020,10,2);

        LocalDate localDateTime2 = now1.with(new NextWorkingDay());
//        ZoneId.of()
        System.out.println(now1.format(DateTimeFormatter.BASIC_ISO_DATE));
        System.out.println(now1);
        System.out.println(localDateTime2);
    }
}
