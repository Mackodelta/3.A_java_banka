package transfers;
import accounts.BankAccount;
import accounts.BusinessAccount;

public class TransferService {
    private final TransferLoggerService loggerService;
    private final TransactionFactory transactionFactory;

    public TransferService(TransferLoggerService loggerService, TransactionFactory transactionFactory) {
        this.loggerService = loggerService;
        this.transactionFactory = transactionFactory;
    }

    public void transfer(BankAccount from, BankAccount to, double amount) {
        if (from == null || to == null || from == to || amount <= 0) {
            return;
        }
        double fee = (from instanceof BusinessAccount) ? amount * 0.003 : 0.0;
        double total = amount + fee;
        if (from.getBalance() < total) {
            return;
        }

        from.setNewBalance(from.getBalance() - total);

        double received = from.getCurrency().convertTo(amount, to.getCurrency());
        to.setNewBalance(to.getBalance() + received);

        // Zaznamenání transakce do historie
        Transaction transaction = transactionFactory.createTransfer(from, to, amount, fee);
        loggerService.log(transaction);
    }

    public TransferLoggerService getLoggerService() {
        return loggerService;
    }
}
