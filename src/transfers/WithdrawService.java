package transfers;
import accounts.BankAccount;
import accounts.BusinessAccount;
import accounts.StudentAccount;
import notifiers.ConsoleNotifier;
import notifiers.Notifier;

public class WithdrawService {

    private static final float BUSINESS_ACCOUNT_SUB_FEE = 0.1f;
    private static final float STUDENT_ACCOUNT_LIMIT = -5000;

    private final Notifier notifier = new ConsoleNotifier();
    private final TransferLoggerService loggerService;
    private final TransactionFactory transactionFactory;

    public WithdrawService() {
        this(new TransferLoggerService(), new TransactionFactory());
    }

    public WithdrawService(TransferLoggerService loggerService, TransactionFactory transactionFactory) {
        this.loggerService = loggerService;
        this.transactionFactory = transactionFactory;
    }

    public void withdraw(Withdraw withdrawObject, double amount) {
        this.notifier.notify("Sub amount is " + amount);

        double fee = (withdrawObject instanceof BusinessAccount) ? amount * BUSINESS_ACCOUNT_SUB_FEE : 0.0;
        double newBalance = withdrawObject.getBalance() - amount - fee;

        if (newBalance < this.getWithdrawLimit(withdrawObject)) {
            throw new RuntimeException("Withdrawal limit reached");
        }

        withdrawObject.setNewBalance(newBalance);

        // Zaznamenání výběru
        if (withdrawObject instanceof BankAccount bankAccount) {
            Transaction transaction = transactionFactory.createWithdraw(bankAccount, amount, fee);
            loggerService.log(transaction);
        }
    }

    public void addToBalance(Withdraw withdrawObject, double amount) {
        // Oprava přičítání
        double newBalance = withdrawObject.getBalance() + amount;
        withdrawObject.setNewBalance(newBalance);

        // Zaznamenání vkladu
        if (withdrawObject instanceof BankAccount bankAccount) {
            Transaction transaction = transactionFactory.createDeposit(bankAccount, amount);
            loggerService.log(transaction);
        }
    }

    private double getWithdrawLimit(Withdraw withdrawObject) {
        if (withdrawObject instanceof StudentAccount) {
            return STUDENT_ACCOUNT_LIMIT;
        }
        return 0;
    }

    public TransferLoggerService getLoggerService() {
        return loggerService;
    }
}
