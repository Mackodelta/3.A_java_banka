package accounts.accountFactories;

import accounts.AccountNumberGenerator;
import accounts.BankAccount;
import accounts.CurrentAccount;
import people.Owner;

public class CurrentAccountFactory implements BankAccountFactory{
    @Override
    public BankAccount create(Owner owner, double balance) {
        CurrentAccount account = new CurrentAccount(owner, balance);
        account.setAccountNumber(AccountNumberGenerator.generate());
        return account;
    }
}
