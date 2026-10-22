package accounts.accountFactories;

import accounts.StudentAccount;
import accounts.BankAccountFactory;
import accounts.Owner;

public class StudentAccountFactory implements BankAccountFactory {
    private final String school;

    public StudentAccountFactory(String school) {
        this.school = school;
    }

    @Override
    public StudentAccount create(Owner owner, double balance) {
        StudentAccount account = new StudentAccount(owner, this.school);
        account.setAccountNumber(AccountNumberGenerator.generate());
        return account;
    }
}
