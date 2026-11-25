package accounts;

import Currency.CurrencyType;
import notifiers.EmailNotifier;
import notifiers.Notifier;
import people.Owner;
import transfers.Withdraw;

// kod banky  2010

public abstract class BankAccount implements Withdraw {
    protected String uuid = java.util.UUID.randomUUID().toString();
    protected String accountNumber;
    protected Owner owner;
    protected double balance;
    protected CurrencyType currency = CurrencyType.CZK;

    protected Notifier notifier = new EmailNotifier();

    public BankAccount(String uuid, String accountNumber, Owner owner) {
        this.uuid = uuid;
        this.accountNumber = accountNumber;
        this.owner = owner;
    }

    public BankAccount(Owner owner) {
        this.owner = owner;
        this.balance = 0;
    }

    public BankAccount(Owner owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }
    // NOVÝ
    public BankAccount(Owner owner, double balance, CurrencyType currency) {
        this.owner = owner;
        this.balance = balance;
        this.currency = currency;
    }

    public BankAccount(String uuid, String accountNumber, Owner owner, double balance, CurrencyType currency) {
        this.uuid = uuid;
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
        this.currency = currency;
    }

    // NOVÉ metody
    public CurrencyType getCurrency() {
        return currency;
    }

    public double getBalanceIn(CurrencyType target) {
        return currency.convertTo(balance, target);
    }

    // řádek do výpisu: měna účtu + přepočet do jedné další měny
    public String formatBalance(CurrencyType target) {
        return String.format("%.2f %s (≈ %.2f %s)",
                balance, currency, getBalanceIn(target), target);
    }

    public String getUuid() {
        return uuid;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Owner getOwner() {
        return owner;
    }

    @Override
    public void setNewBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }
}
