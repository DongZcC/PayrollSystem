package salary.schdules;

import org.apache.commons.lang3.time.DateUtils;

import java.util.Calendar;
import java.util.Date;

public class BiweeklySchedule implements PaymentSchedule {

    @Override
    public boolean isPayDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        // 找到本周5
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
        // 减去2周
        calendar.add(Calendar.WEEK_OF_MONTH, -2);
        return DateUtils.isSameDay(date, calendar.getTime());
    }

    @Override
    public Date getPayPeriodStartDate(Date payDate) {
        return null;
    }
}
