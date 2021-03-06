package salary.payrolldatabase;

import lombok.Getter;
import lombok.Setter;
import salary.affiliations.Affiliation;
import salary.data.PayCheck;
import salary.classifications.PaymentClassification;
import salary.methods.PaymentMethod;
import salary.schdules.PaymentSchedule;

import java.util.Date;


@Getter
@Setter
public class Employee {

    private Integer empId;

    private String name;

    private String address;

    private PaymentClassification classification;

    private PaymentSchedule schedule;

    private PaymentMethod paymentMethod;

    private Affiliation affiliation;

    public boolean isPayDate(Date date) {
        return schedule.isPayDate(date);
    }

    public void payDate(PayCheck pc) {
        double grossPay = classification.caculatePay(pc);
        double deductions = affiliation.calculateDeductions(pc);
        double netPay = grossPay - deductions;
        pc.setGrossPay(grossPay);
        pc.setDecutions(deductions);
        pc.setNetPay(netPay);
        paymentMethod.pay(pc);
    }

    public Date getPayPeriodStartDate(Date payDate) {
        return schedule.getPayPeriodStartDate(payDate);
    }
}
