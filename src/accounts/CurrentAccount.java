package accounts;

import Currency.CurrencyType;
import people.Owner;

public class CurrentAccount extends BankAccount {

    public CurrentAccount(Owner owner) {
        super(owner);
    }

    public CurrentAccount(Owner owner, double balance) {
        super(owner, balance);
    }

    public CurrentAccount(Owner owner, double balance, CurrencyType currency) { super(owner, balance, currency); }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
