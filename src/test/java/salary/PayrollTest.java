package salary;

import org.junit.Test;
import salary.classify.HourlyClassification;
import salary.classify.PaymentClassification;
import salary.classify.SalariedClassification;
import salary.method.HoldMethod;
import salary.schdule.MonthlySchedule;

import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class PayrollTest {

    @Test
    public void testAddSalariedEmployee() {

        int empId = 1;
        AddSalariedEmployee t = new AddSalariedEmployee(empId, "Bob", "Home", 1000.00);
        t.execute();

        Employee e = PayrollDatabase.getEmployee(empId);

        assertTrue(e.getSchedule() instanceof MonthlySchedule);

        assertTrue(e.getClassification() instanceof SalariedClassification);

        assertTrue(e.getPaymentMethod() instanceof HoldMethod);
    }


    @Test
    public void testDeleteEmployee() {

        int empId = 1;
        AddSalariedEmployee t = new AddSalariedEmployee(empId, "Bob", "Home", 1000.00);
        t.execute();

        Employee e = PayrollDatabase.getEmployee(empId);

        assertNotNull(e);

        DeleteEmployeeTransaction d = new DeleteEmployeeTransaction(empId);
        d.execute();

        e = PayrollDatabase.getEmployee(empId);

        assertNull(e);
    }


    @Test
    public void testTimeCardTransaction() {

        int empId = 2;

        AddHourlyEmployee t = new AddHourlyEmployee(empId, "Home", "Bill", 15.25);
        t.execute();

        TimeCardTransaction tct = new TimeCardTransaction(new Date(2001, 10, 31), 8.0, empId);
        tct.execute();

        Employee e = PayrollDatabase.getEmployee(empId);

        PaymentClassification pc = e.getClassification();

        assertTrue(pc instanceof HourlyClassification);

        TimeCard timeCard = ((HourlyClassification)pc).getTimeCard(new Date(2001, 10, 31));

        assertEquals(8.0, timeCard.getHours(), 0);
    }

}
