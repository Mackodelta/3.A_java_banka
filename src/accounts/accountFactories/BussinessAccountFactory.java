package accounts.accountFactories;

import accounts.*;
import people.Owner;

import java.util.UUID;

public class BussinessAccountFactory implements BankAccountFactory{
    private final AccountNumberGeneratorFactory generatorFactory = new AccountNumberGeneratorFactory(
            new SimpleAccountCreationLogger(),
            new TimestampedAccountCreationLogger()
    );

    @Override
    public BankAccount create(Owner owner, double balance) {
        AccountNumberGenerator generator = generatorFactory.createSimpleLogger();
        String uuid = UUID.randomUUID().toString();
        String accNum = generator.generate();

        BusinessAccount account = new BusinessAccount(uuid, accNum, owner);
        account.setNewBalance(balance);
        return account;
    }
}
