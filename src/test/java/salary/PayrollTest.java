package salary;

import org.junit.Test;
import salary.classify.SalariedClassification;
import salary.method.HoldMethod;
import salary.schdule.MonthlySchedule;

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
}
