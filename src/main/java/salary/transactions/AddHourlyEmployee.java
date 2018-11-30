package salary.transactions;

import salary.classifications.HourlyClassification;
import salary.classifications.PaymentClassification;
import salary.schdules.PaymentSchedule;
import salary.schdules.WeeklySchedule;
import salary.transactions.AddEmployeeTransaction;

public class AddHourlyEmployee extends AddEmployeeTransaction {


    private double hourlyRate;

    public AddHourlyEmployee(int empId, String itsAddress, String itsName, double hourlyRate) {
        super(empId, itsAddress, itsName);
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
