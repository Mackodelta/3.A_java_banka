package transfers;

import accounts.BankAccount;
import java.time.LocalDateTime;
import java.util.UUID;

public class TransactionFactory {
    public Transaction createTransfer(BankAccount from, BankAccount to, double amount, double fee) {
        return new Transaction(
                UUID.randomUUID().toString(),
                TransactionType.TRANSFER,
                from,
                to,
                amount,
                fee
        );
    }

    public Transaction createWithdraw(BankAccount from, double amount, double fee) {
        return new Transaction(
                UUID.randomUUID().toString(),
                TransactionType.WITHDRAW,
                from,
                null,
                amount,
                fee
        );
    }

    public Transaction createDeposit(BankAccount to, double amount) {
        return new Transaction(
                UUID.randomUUID().toString(),
                TransactionType.DEPOSIT,
                null,
                to,
                amount,
                0.0
        );
    }
}
