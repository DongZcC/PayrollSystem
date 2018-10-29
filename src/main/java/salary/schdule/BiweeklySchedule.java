package salary.schdule;

import java.util.Date;

public class BiweeklySchedule implements PaymentSchedule {
    @Override
    public boolean isPayDate(Date date) {
        return false;
    }
}
