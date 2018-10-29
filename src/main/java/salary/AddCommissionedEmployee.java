package salary;

import salary.classify.CommissionedClassification;
import salary.classify.PaymentClassification;
import salary.schdule.BiweeklySchedule;
import salary.schdule.PaymentSchedule;

public class AddCommissionedEmployee extends AddEmployeeTransaction {

    private double salary;

    private double commisioneRate;

    public AddCommissionedEmployee(int empId, String itsAddress, String itsName, double salary, double commisioneRate) {
        super(empId, itsAddress, itsName);
        this.salary = salary;
        this.commisioneRate = commisioneRate;
    }

    @Override
    protected PaymentClassification getClassification() {
        return new CommissionedClassification(commisioneRate, salary);
    }

    @Override
    protected PaymentSchedule getSchedule() {
        return new BiweeklySchedule();
    }
}
