package salary.payrollapplication;

import salary.transactions.Transaction;

public interface TransactionSource {
    Transaction getTransaction();
}
