package transfers;

import accounts.BankAccount;
import java.time.LocalDateTime;

public class Transaction {
    private final String id;
    private final TransactionType type;
    private final BankAccount fromAccount;
    private final BankAccount toAccount;
    private final double amount;
    private final double fee;

    public Transaction(String id, TransactionType type,
                       BankAccount fromAccount, BankAccount toAccount, double amount, double fee) {
        this.id = id;
        this.type = type;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.fee = fee;
    }

    public String getId() { return id; }
    public TransactionType getType() { return type; }
    public BankAccount getFromAccount() { return fromAccount; }
    public BankAccount getToAccount() { return toAccount; }
    public double getAmount() { return amount; }
    public double getFee() { return fee; }

    @Override
    public String toString() {
        return "Transaction{" +
                ", type=" + type +
                ", from=" + (fromAccount != null ? fromAccount.getBalance() : "N/A") +
                ", to=" + (toAccount != null ? toAccount.getBalance() : "N/A") +
                ", amount=" + amount +
                ", fee=" + fee +
                '}';
    }
}
