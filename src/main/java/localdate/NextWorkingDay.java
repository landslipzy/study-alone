package localdate;

import java.time.DayOfWeek;
import java.time.temporal.*;

/**
 * @author zhongying
 * @description
 * @date 2020/10/30
 */
public class NextWorkingDay implements TemporalAdjuster {
    @Override
    public Temporal adjustInto(Temporal temporal) {
        DayOfWeek week = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
        int addDay = 1;
        if (week == DayOfWeek.FRIDAY) {
            addDay = 3;
        }
        if (week == DayOfWeek.SATURDAY) {
            addDay = 2;
        }

        return temporal.plus(addDay, ChronoUnit.DAYS);
    }
}
