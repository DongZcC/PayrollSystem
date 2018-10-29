package salary.classify;

import lombok.AllArgsConstructor;
import salary.TimeCard;

import java.util.*;

public class HourlyClassification implements PaymentClassification {

    private double hourlyRate;

    public HourlyClassification(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    private Map<Date, TimeCard> timeCards = new HashMap<>();

    @Override
    public double caculatePay(Date date) {
        return 0;
    }

    public void addTimeCard(TimeCard timeCard) {
        timeCards.put(timeCard.getDate(), timeCard);
    }

    public TimeCard getTimeCard(Date date) {
        return timeCards.get(date);
    }
}
