package salary;

import java.util.Date;

public class NoAffiliation implements Affiliation {


    // NULL OBJECT MODEL
    @Override
    public double calculateDeductions(PayCheck pc) {
        return 0;
    }

}
