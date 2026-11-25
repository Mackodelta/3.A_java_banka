package accounts.accountFactories;

import Currency.CurrencyType;
import accounts.*;
import people.Owner;

import java.util.Objects;

public class StudentAccountFactory implements BankAccountFactory {
    private final String school;
    private final AccountNumberGeneratorFactory generatorFactory;
    public StudentAccountFactory(String school) {
        this(school, new AccountNumberGeneratorFactory(
                new SimpleAccountCreationLogger(),
                new TimestampedAccountCreationLogger()
        ));
    }

    public StudentAccountFactory(String school, AccountNumberGeneratorFactory generatorFactory) {
        this.school = Objects.requireNonNull(school, "school must not be null");
        this.generatorFactory = Objects.requireNonNull(generatorFactory, "generatorFactory must not be null");
    }

    @Override
    public StudentAccount create(Owner owner, double balance, CurrencyType currency) {
        AccountNumberGenerator generator = generatorFactory.createSimpleLogger();
        StudentAccount account = new StudentAccount(owner, this.school, balance, currency);
        account.setAccountNumber(generator.generate());
        return account;
    }
}
