package accounts.accountFactories;

import accounts.*;
import people.Owner;

import java.util.UUID;

public class SavingsAccountFactory implements BankAccountFactory{
    private final AccountNumberGeneratorFactory generatorFactory = new AccountNumberGeneratorFactory(
            new SimpleAccountCreationLogger(),
            new TimestampedAccountCreationLogger()
    );

    @Override
    public BankAccount create(Owner owner, double balance) {
        AccountNumberGenerator generator = generatorFactory.createSimpleLogger();
        String uuid = UUID.randomUUID().toString();
        String accNum = generator.generate();

        SavingsAccount account = new SavingsAccount(uuid, accNum, owner);
        account.setNewBalance(balance);
        return account;
    }
}
