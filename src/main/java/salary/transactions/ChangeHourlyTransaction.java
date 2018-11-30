package salary.transactions;

import salary.classifications.HourlyClassification;
import salary.classifications.PaymentClassification;
import salary.schdules.PaymentSchedule;
import salary.schdules.WeeklySchedule;

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
