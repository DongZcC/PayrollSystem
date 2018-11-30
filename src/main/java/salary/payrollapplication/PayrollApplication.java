package salary.payrollapplication;


import salary.transactions.Transaction;

public class PayrollApplication {

    // 主程序
    public static void main(String[] args) {
        TransactionSource tc = new TextParserTransactionSource();
        Transaction t = tc.getTransaction();
        t.execute();
    }
}
