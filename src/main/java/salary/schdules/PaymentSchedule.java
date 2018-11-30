package salary.schdules;

import java.util.Date;

public interface PaymentSchedule {

    boolean isPayDate(Date date);

    Date getPayPeriodStartDate(Date payDate);
}
