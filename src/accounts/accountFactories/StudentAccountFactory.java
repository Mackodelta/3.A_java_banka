package accounts.accountFactories;

import accounts.AccountNumberGenerator;
import accounts.BankAccount;
import accounts.StudentAccount;
import people.Owner;

public class StudentAccountFactory implements BankAccountFactory{
    private final String school;

    public StudentAccountFactory(String school) {
        this.school = school;
    }

    @Override
    public BankAccount create(Owner owner, double balance) {
        StudentAccount account = new StudentAccount(owner, this.school);
        account.setNewBalance(balance);
        account.setAccountNumber(AccountNumberGenerator.generate());
        return account;
    }
}
