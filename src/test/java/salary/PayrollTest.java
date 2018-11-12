package salary;

import org.apache.commons.lang3.time.DateUtils;
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


    @Test
    public void testChangeMemberTransaction() {
        int empId = 2;
        int memberId = 7734;

        AddHourlyEmployee e = new AddHourlyEmployee(empId, "Home", "Bob", 15.25);
        e.execute();

        ChangeMemberTransaction c = new ChangeMemberTransaction(empId, memberId, 99.42);
        c.execute();

        Employee employee = PayrollDatabase.getEmployee(empId);
        assertNotNull(e);

        Affiliation af = employee.getAffiliation();

        assertTrue(af instanceof UnionAffiliation);

        UnionAffiliation naf = (UnionAffiliation) af;
        assertEquals(99.42, naf.getAmount(), 0.01);

        Employee member = PayrollDatabase.getUnionMember(memberId);

        assertNotNull(member);

        assertEquals(employee, member);
    }


    @Test
    public void testPaySingleSalariedEmployee() {
        int empId = 1;
        AddSalariedEmployee a = new AddSalariedEmployee(empId, "Home", "Bob", 1000.00);
        a.execute();

        Date date = new Date(2018 - 1900, 10, 30);
        PayDayTransaction pt = new PayDayTransaction(date);
        pt.execute();

        PayCheck pc = pt.getPayCheck(empId);
        assertNotNull(pc);

        assertEquals(pc.getPayDate(), date);
        assertEquals(1000, pc.getGrossPay(), 0.01);
        assertEquals(0, pc.getDecutions(), 0.01);
        assertEquals(1000, pc.getNetPay(), 0.01);
        assertEquals("Hold", pc.getField("Disposition"));
    }


    @Test
    public void testPaySingleSalariedEmployeeOnWrongDate() {
        int empId = 1;
        AddSalariedEmployee a = new AddSalariedEmployee(empId, "Home", "Bob", 1000.00);
        a.execute();

        Date date = new Date();
        PayDayTransaction pt = new PayDayTransaction(date);
        pt.execute();

        PayCheck pc = pt.getPayCheck(empId);
        assertNull(pc);
    }


    @Test
    public void testPaySingleHourlyEmployeeNoTimeCard() {
        int empId = 2;
        AddHourlyEmployee a = new AddHourlyEmployee(empId, "Home", "Bill", 15.25);
        a.execute();
        Date payDate = new Date(2018 - 1900, 10, 16);
        PayDayTransaction pt = new PayDayTransaction(payDate);
        pt.execute();
        ValidatePayCheck(pt, empId, payDate, 0.0);
    }

    private void ValidatePayCheck(PayDayTransaction pt, int empId, Date payDate, double pay) {
        PayCheck pc = pt.getPayCheck(empId);
        assertNotNull(pc);

        assertEquals(pc.getPayPeriodEndDate(), payDate);
        assertEquals(pay, pc.getGrossPay(), 0.001);
        assertEquals("Hold", pc.getField("Disposition"));
        assertEquals(0.0, pc.getDecutions(), 0.001);
        assertEquals(pay, pc.getNetPay(), 0.001);
    }


    @Test
    public void testPaySingleHourlyEmployeeOneTimeCard() {
        int empId = 2;
        AddHourlyEmployee a = new AddHourlyEmployee(empId, "Home", "Bill", 15.25);
        a.execute();

        Date payDate = new Date(2018 - 1900, 10, 16);

        TimeCardTransaction tc = new TimeCardTransaction(payDate, 2, empId);
        tc.execute();

        PayDayTransaction pc = new PayDayTransaction(payDate);
        pc.execute();

        ValidatePayCheck(pc, empId, payDate, 30.5);
    }


    @Test
    public void testPaySingleHourlyEmployeeOvertimeTimeCard() {
        int empId = 2;
        AddHourlyEmployee a = new AddHourlyEmployee(empId, "Home", "Bill", 15.25);
        a.execute();

        Date payDate = new Date(2018 - 1900, 10, 16);

        TimeCardTransaction tc = new TimeCardTransaction(payDate, 9.0, empId);
        tc.execute();

        PayDayTransaction pt = new PayDayTransaction(payDate);
        pt.execute();

        ValidatePayCheck(pt, empId, payDate, (8+1.5) * 15.25);
    }


    @Test
    public void testPaySingleHourlyEmployeeOnWrongDate() {
        int empId = 2;
        AddHourlyEmployee a = new AddHourlyEmployee(empId, "Home", "Bill", 15.25);
        a.execute();

        Date payDate = new Date(2018 - 1900, 10, 15);

        TimeCardTransaction tc = new TimeCardTransaction(payDate, 9.0, empId);
        tc.execute();

        PayDayTransaction pt = new PayDayTransaction(payDate);
        pt.execute();

        PayCheck pc = pt.getPayCheck(empId);

        assertNull(pc);
    }

    @Test
    public void testPaySingleHourlyEmployeeTwoTimeCards() {
        int empId = 2;
        AddHourlyEmployee a = new AddHourlyEmployee(empId, "Home", "Bill", 15.25);
        a.execute();

        Date payDate = new Date(2018 - 1900, 10, 16);

        TimeCardTransaction tc = new TimeCardTransaction(payDate, 9.0, empId);
        tc.execute();

        TimeCardTransaction tc2 = new TimeCardTransaction(DateUtils.addDays(payDate, -1), 8, empId);
        tc2.execute();

        PayDayTransaction pt = new PayDayTransaction(payDate);
        pt.execute();

        ValidatePayCheck(pt, empId, payDate, (16+1.5) * 15.25);
    }


    @Test
    public void testPaySingleHourlyEmployeeWithTimeCardsSpanningTowPayPeriods() {

    }
}
