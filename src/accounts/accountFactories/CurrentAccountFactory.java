package accounts.accountFactories;

import accounts.*;
import people.Owner;

import java.util.Objects;
import java.util.UUID;

public class CurrentAccountFactory implements BankAccountFactory {
    private final AccountNumberGeneratorFactory generatorFactory;

    public CurrentAccountFactory(AccountNumberGeneratorFactory generatorFactory) {
        this.generatorFactory = Objects.requireNonNull(generatorFactory, "generatorFactory must not be null");
    }

    @Override
    public BankAccount create(Owner owner, double balance) {
        AccountNumberGenerator generator = generatorFactory.createSimpleLogger();
        String accountNumber = generator.generate();
        CurrentAccount account = new CurrentAccount(owner, balance);
        account.setAccountNumber(accountNumber);
        return account;
    }
}
