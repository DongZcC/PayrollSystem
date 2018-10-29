package salary;

import salary.classify.HourlyClassification;
import salary.classify.PaymentClassification;
import salary.schdule.PaymentSchedule;
import salary.schdule.WeeklySchedule;

public class AddHourlyEmployee extends  AddEmployeeTransaction{


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
