package salary.schdule;

import org.apache.commons.lang3.time.DateUtils;

import java.util.Calendar;
import java.util.Date;

public class MonthlySchedule implements PaymentSchedule {

    @Override
    public boolean isPayDate(Date date) {
        return isLastDayOfMonth(date);
    }

    private boolean isLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE, 1); // 设置为当月1号
        calendar.add(Calendar.MONTH, 1); // 增加一个月
        calendar.add(Calendar.DATE, -1); // 减去一天， 变为当月最后一天
        return DateUtils.isSameDay(date, calendar.getTime());
    }
}
