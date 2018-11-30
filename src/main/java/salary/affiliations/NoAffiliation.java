package salary.affiliations;

import salary.data.PayCheck;

public class NoAffiliation implements Affiliation {


    // NULL OBJECT MODEL
    @Override
    public double calculateDeductions(PayCheck pc) {
        return 0;
    }

}
