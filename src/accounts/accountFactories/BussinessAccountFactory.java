package accounts.accountFactories;

import accounts.*;
import people.Owner;

import java.util.Objects;
import java.util.UUID;

public class BussinessAccountFactory implements BankAccountFactory{
    private final AccountNumberGeneratorFactory generatorFactory;

    public BussinessAccountFactory(AccountNumberGeneratorFactory generatorFactory) {
        this.generatorFactory = Objects.requireNonNull(generatorFactory, "generatorFactory must not be null");
    }

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
