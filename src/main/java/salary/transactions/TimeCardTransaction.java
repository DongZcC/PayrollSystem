package salary.transactions;

import lombok.AllArgsConstructor;
import salary.payrolldatabase.Employee;
import salary.payrolldatabase.PayrollDatabase;
import salary.data.TimeCard;
import salary.classifications.HourlyClassification;

import java.util.Date;

@AllArgsConstructor
public class TimeCardTransaction implements Transaction {

    private Date date;

    private double hours;

    private int empId;

    @Override
    public void execute() {
        Employee e = PayrollDatabase.getEmployee(empId);
        if (e != null) {
            TimeCard timeCard = new TimeCard(date, hours);
            if (e.getClassification() instanceof HourlyClassification) {
                HourlyClassification hc = (HourlyClassification) e.getClassification();
                hc.addTimeCard(timeCard);
            } else {
                throw new RuntimeException("Tried to add timeCard to non-hourly employee");
            }
        } else {
            throw new RuntimeException("No such employee");
        }
    }
}
