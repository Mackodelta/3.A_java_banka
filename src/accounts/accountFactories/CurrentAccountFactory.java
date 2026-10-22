package accounts.accountFactories;

import accounts.CurrentAccount;
import accounts.BankAccountFactory;
import accounts.Owner;

public class CurrentAccountFactory implements BankAccountFactory {
    @Override
    public CurrentAccount create(Owner owner, double balance) {
        CurrentAccount account = new CurrentAccount(owner, balance);
        account.setAccountNumber(AccountNumberGenerator.generate());
        return account;
    }
}
