package accounts.accountFactories;

import accounts.*;
import people.Owner;

public class StudentAccountFactory implements BankAccountFactory {
    private final AccountNumberGeneratorFactory generatorFactory = new AccountNumberGeneratorFactory(
            new SimpleAccountCreationLogger(),
            new TimestampedAccountCreationLogger()
    );
    private final String school;

    public StudentAccountFactory(String school) {
        this.school = school;
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
