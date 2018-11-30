package salary.transactions;


import salary.classifications.PaymentClassification;
import salary.classifications.SalariedClassification;
import salary.schdules.MonthlySchedule;
import salary.schdules.PaymentSchedule;
import salary.transactions.AddEmployeeTransaction;

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
