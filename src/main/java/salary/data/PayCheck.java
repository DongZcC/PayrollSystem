package salary.data;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class PayCheck {

    private double grossPay;

    private double decutions;

    private double netPay;

    private Date payPeriodStartDate;

    private Date payDate;

    private Map<String, String> fields = new HashMap<>();

    public PayCheck(Date payPeriodStartDate, Date payDate) {
        this.payPeriodStartDate = payPeriodStartDate;
        this.payDate = payDate;
    }

    public String getField(String key) {
        return fields.get(key);
    }

    public void putFields(String k, String v) {
        fields.put(k, v);
    }

    public Date getPayPeriodEndDate() {
        return payDate;
    }
}
