package salary.schdule;

import java.util.Date;

public class MonthlySchedule implements PaymentSchedule {
    @Override
    public boolean isPayDate(Date date) {
        return false;
    }
}
