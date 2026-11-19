package accounts.accountFactories;

import accounts.*;
import people.Owner;

import java.util.UUID;

public class CurrentAccountFactory implements BankAccountFactory {
    private final AccountNumberGeneratorFactory generatorFactory = new AccountNumberGeneratorFactory(
            new SimpleAccountCreationLogger(),
            new TimestampedAccountCreationLogger()
    );

    @Override
    public BankAccount create(Owner owner, double balance) {
        AccountNumberGenerator generator = generatorFactory.createSimpleLogger();
        String accountNumber = generator.generate();
        CurrentAccount account = new CurrentAccount(owner, balance);
        account.setAccountNumber(accountNumber);
        return account;
    }
}
