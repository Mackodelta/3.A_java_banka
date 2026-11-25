package accounts.accountFactories;

import Currency.CurrencyType;
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
    public BankAccount create(Owner owner, double balance, CurrencyType currency) {
        AccountNumberGenerator generator = generatorFactory.createSimpleLogger();
        CurrentAccount account = new CurrentAccount(owner, balance, currency);
        account.setAccountNumber(generator.generate());
        return account;
    }
}
