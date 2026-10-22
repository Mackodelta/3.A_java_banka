package accounts.accountFactories;

import accounts.AccountNumberGenerator;
import accounts.AccountNumberGeneratorFactory;
import accounts.BankAccount;
import accounts.CurrentAccount;
import people.Owner;

import java.util.UUID;

public class CurrentAccountFactory implements BankAccountFactory {
    @Override
    public BankAccount create(Owner owner, double balance) {
        AccountNumberGenerator generator = AccountNumberGeneratorFactory.createSimpleLogger();
        String accountNumber = generator.generate();
        CurrentAccount account = new CurrentAccount(owner, balance);
        account.setAccountNumber(accountNumber);
        return account;
    }
}
