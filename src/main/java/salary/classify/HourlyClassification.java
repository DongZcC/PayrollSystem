package salary.classify;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.time.DateUtils;
import salary.PayCheck;
import salary.TimeCard;

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
        // 计算一周的时间
        Date endDate = pc.getPayPeriodEndDate();
        Date startDate = DateUtils.addDays(endDate, -6);

        for (Map.Entry<Date, TimeCard> entry : timeCards.entrySet()) {
            if (entry.getKey().before(DateUtils.addDays(endDate, 1)) && entry.getKey().after(startDate)) {
                if (entry.getValue().getHours() > 8) {
                    result += hourlyRate * 8 + (entry.getValue().getHours() - 8) * hourlyRate * 1.5;
                } else {
                    result += hourlyRate * entry.getValue().getHours();
                }

            }
        }
        return result;
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
