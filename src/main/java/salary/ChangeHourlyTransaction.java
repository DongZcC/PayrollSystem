package salary;

import salary.ChangeClassificationTransaction;
import salary.classify.HourlyClassification;
import salary.classify.PaymentClassification;
import salary.schdule.PaymentSchedule;
import salary.schdule.WeeklySchedule;

public class ChangeHourlyTransaction extends ChangeClassificationTransaction {


    private double hourlyRate;

    public ChangeHourlyTransaction(int empId, double hourlyRate) {
        super(empId);
        this.hourlyRate = hourlyRate;
    }

    @Override
    protected PaymentClassification getClassification() {
        return new HourlyClassification(hourlyRate);
    }

    @Override
    protected PaymentSchedule getSchedule() {
        return new WeeklySchedule();
    }
}
