package salary.classifications;

import org.apache.commons.lang3.time.DateUtils;
import salary.data.PayCheck;
import salary.data.TimeCard;

import java.util.*;

public class HourlyClassification implements PaymentClassification {

    private double hourlyRate;

    public HourlyClassification(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    private Map<Date, TimeCard> timeCards = new HashMap<>();

    @Override
    public double caculatePay(PayCheck pc) {
        double result = 0.0;
        Date endDate = pc.getPayPeriodEndDate();
        Date startDate = pc.getPayPeriodStartDate();
        for (Map.Entry<Date, TimeCard> entry : timeCards.entrySet()) {
            // 判断是否在支付区间的函数， 不应该在计算薪水的类中
            if (isInPayPeriod(entry.getValue(), startDate, endDate)) {
                result += calculatePayForTimeCard(entry.getValue());
            }
        }
        return result;
    }

    private double calculatePayForTimeCard(TimeCard tc) {
        double hours = tc.getHours();
        double overtime = Math.max(0.0, hours - 8);
        double straightTime = hours - overtime;
        return straightTime * hourlyRate + overtime * hourlyRate * 1.5;
    }

    private boolean isInPayPeriod(TimeCard tc, Date startDate, Date endDate) {
        return (tc.getDate().before(DateUtils.addDays(endDate, 1)) && tc.getDate().after(startDate));
    }

    public void addTimeCard(TimeCard timeCard) {
        timeCards.put(timeCard.getDate(), timeCard);
    }

    public TimeCard getTimeCard(Date date) {
        return timeCards.get(date);
    }

    public double getHourlyRate() {
        return hourlyRate;
    }
}
