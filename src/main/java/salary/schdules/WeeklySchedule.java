package salary.schdules;

import org.apache.commons.lang3.time.DateUtils;

import java.util.Calendar;
import java.util.Date;

public class WeeklySchedule implements PaymentSchedule {

    @Override
    public boolean isPayDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
        return DateUtils.isSameDay(date, calendar.getTime());
    }

    @Override
    public Date getPayPeriodStartDate(Date payDate) {
        Calendar c = Calendar.getInstance();
        c.setTime(payDate); // 周五
        c.add(Calendar.WEEK_OF_MONTH, -1); // 上周五
        c.add(Calendar.DATE, 1); // 上周六
        return c.getTime();
    }
}
