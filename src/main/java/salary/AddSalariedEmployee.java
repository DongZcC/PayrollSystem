package salary;


import salary.classify.PaymentClassification;
import salary.classify.SalariedClassification;
import salary.schdule.MonthlySchedule;
import salary.schdule.PaymentSchedule;

public class AddSalariedEmployee extends AddEmployeeTransaction {

    private double salary;


    public AddSalariedEmployee(int empId, String itsAddress, String itsName, double salary) {
        super(empId, itsAddress, itsName);
        this.salary = salary;
    }

    @Override
    protected PaymentClassification getClassification() {
        return new SalariedClassification(salary);
    }

    @Override
    protected PaymentSchedule getSchedule() {
        return new MonthlySchedule();
    }
}
