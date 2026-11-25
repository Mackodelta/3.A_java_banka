package transfers;

import Currency.CurrencyType;
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

    public CurrencyType getCurrency() {
        return fromAccount != null ? fromAccount.getCurrency() : toAccount.getCurrency();
    }

    // řádek výpisu: měna účtu + přepočet do další měny
    public String format(CurrencyType target) {
        CurrencyType c = getCurrency();
        return String.format("%-8s | %10.2f %s (≈ %.2f %s) | poplatek %.2f %s",
                type, amount, c, c.convertTo(amount, target), target, fee, c);
    }

    @Override
    public String toString() {
        return String.format("Transaction{type=%s, amount=%.2f %s, fee=%.2f %s}",
                type, amount, getCurrency(), fee, getCurrency());
    }
}
