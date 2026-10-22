package accounts.accountFactories;

import accounts.AccountNumberGenerator;
import accounts.CurrentAccount;

public class CurrentAccountFactory implements BankAccountFactory {
    @Override
    public CurrentAccount create(people.Owner owner, double balance) {
        CurrentAccount account = new CurrentAccount(owner, balance);
        account.setAccountNumber(AccountNumberGenerator.generate());
        return account;
    }
}
