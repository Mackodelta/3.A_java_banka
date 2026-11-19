package accounts.accountFactories;

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
    public StudentAccount create(Owner owner, double balance) {
        AccountNumberGenerator generator = generatorFactory.createSimpleLogger();
        StudentAccount account = new StudentAccount(owner, this.school);
        account.setAccountNumber(generator.generate());
        account.setNewBalance(balance);
        return account;
    }
}
