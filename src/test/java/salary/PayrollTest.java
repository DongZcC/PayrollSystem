package salary;

import org.junit.Test;
import salary.classify.HourlyClassification;
import salary.classify.PaymentClassification;
import salary.classify.SalariedClassification;
import salary.method.HoldMethod;
import salary.schdule.MonthlySchedule;
import salary.schdule.PaymentSchedule;
import salary.schdule.WeeklySchedule;

import java.util.Date;

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

        TimeCard timeCard = ((HourlyClassification) pc).getTimeCard(new Date(2001, 10, 31));

        assertEquals(8.0, timeCard.getHours(), 0);
    }


    @Test
    public void testAddServiceCharge() {
        int empId = 2;
        AddHourlyEmployee t = new AddHourlyEmployee(empId, "Home", "Bill", 15.25);

        t.execute();

        Employee e = PayrollDatabase.getEmployee(empId);
        assertNotNull(e);

        int memberId = 86;
        UnionAffiliation af = new UnionAffiliation(memberId, 12.5);

        e.setAffiliation(af);

        PayrollDatabase.addUnionMember(memberId, e);

        ServiceChargeTransaction sct = new ServiceChargeTransaction(new Date(2011, 11, 01), memberId, 12.95);
        sct.execute();

        ServiceCharge sc = af.getServiceCharge(new Date(2011, 11, 01));

        assertNotNull(sc);

        assertEquals(12.95, sc.getAmount(), 0.01);
    }


    @Test
    public void testChangeNameTransaction() {
        int empId = 2;
        AddHourlyEmployee a = new AddHourlyEmployee(empId, "home", "bob", 8);
        a.execute();

        Employee e = PayrollDatabase.getEmployee(empId);

        assertEquals("bob", e.getName());

        ChangeNameTransaction c = new ChangeNameTransaction(empId, "jack");

        c.execute();
        assertEquals("jack", e.getName());
    }


    @Test
    public void testChangeHourlyTransaction() {
        int empId = 3;
        AddCommissionedEmployee t = new AddCommissionedEmployee(empId, "Home", "Bob", 1000, 3.2);
        t.execute();

        ChangeHourlyTransaction c = new ChangeHourlyTransaction(empId, 27.52);
        c.execute();

        Employee e = PayrollDatabase.getEmployee(empId);

        PaymentClassification pc = e.getClassification();

        assertTrue(pc instanceof HourlyClassification);

        HourlyClassification hc = (HourlyClassification) pc;

        assertEquals(27.52, hc.getHourlyRate(), 0.01);

        PaymentSchedule ps = e.getSchedule();

        assertTrue(ps instanceof WeeklySchedule);
    }

}
