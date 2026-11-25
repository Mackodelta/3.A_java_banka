package accounts;

import Currency.CurrencyType;
import people.Owner;

public class BusinessAccount extends BankAccount {

    public BusinessAccount(String uuid, String accountNumber, Owner owner) {
        super(uuid, accountNumber, owner);
    }

    public BusinessAccount(Owner owner) {
        super(owner);
    }

    public BusinessAccount(Owner owner, double balance, CurrencyType currency) { super(owner, balance, currency); }

    public BusinessAccount(Owner owner, double balance) {
        super(owner, balance);
    }

    public BusinessAccount(String uuid, String accountNumber, Owner owner, double balance, CurrencyType currency) {
        super(uuid, accountNumber, owner, balance, currency);
    }
}
