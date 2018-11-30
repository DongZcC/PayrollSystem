package salary.affiliations;

import org.apache.commons.lang3.time.DateUtils;
import salary.data.PayCheck;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UnionAffiliation implements Affiliation {

    private int memberId;

    private double amount;

    private Map<Date, ServiceCharge> serviceCharges = new HashMap<>();

    public UnionAffiliation(int memberId, double amount) {
        this.memberId = memberId;
        this.amount = amount;
    }

    public ServiceCharge getServiceCharge(Date date) {
        return serviceCharges.get(date);
    }

    public void addServiceCharge(ServiceCharge sc) {
        serviceCharges.put(sc.getDate(), sc);
    }


    public double getAmount() {
        return amount;
    }

    public int getMemberId() {
        return memberId;
    }

    @Override
    public double calculateDeductions(PayCheck pc) {

        // 计算周期内有几个周五
        int fridays = calculateFridayCount(pc);
        double unionfees = fridays * amount;
        double servicefees = calculateServiceFees(pc);
        return unionfees + servicefees;
    }

    private double calculateServiceFees(PayCheck pc) {
        double fees = 0;
        for (Map.Entry<Date, ServiceCharge> entry : serviceCharges.entrySet()) {
            if (isInPeriod(entry.getKey(), pc)) {
                fees += entry.getValue().getAmount();
            }
        }
        return fees;
    }

    private boolean isInPeriod(Date date, PayCheck pc) {
        Date startDate = DateUtils.addDays(pc.getPayPeriodStartDate(), -1);
        Date endDate = DateUtils.addDays(pc.getPayPeriodEndDate(), 1);
        return (date.before(endDate) && date.after(startDate));
    }

    private int calculateFridayCount(PayCheck pc) {
        Date startDate = pc.getPayPeriodStartDate();
        Date endDate = pc.getPayPeriodEndDate();
        int firdays = 0;
        Calendar c = Calendar.getInstance();
        c.setTime(startDate);
        // 当开始日期 小于等于 结束日期时
        while (c.getTime().before(DateUtils.addDays(endDate, 1))) {
            if (c.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
                // 周五了就直接加一周
                firdays++;
                c.add(Calendar.WEEK_OF_MONTH, 1);
            } else {
                // 加一天
                c.add(Calendar.DAY_OF_WEEK, 1);
            }
        }
        return firdays;
    }
}
