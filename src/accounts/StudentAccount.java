package accounts;

import Currency.CurrencyType;
import people.Owner;

public class StudentAccount extends BankAccount {
    private String school;

    public StudentAccount(Owner owner, String school) {
        super(owner);

        this.school = school;
    }

    public StudentAccount(Owner owner, String school, double balance, CurrencyType currency) {
        super(owner, balance, currency);
        this.school = school;
    }

    public StudentAccount(Owner owner, double balance) {
        super(owner, balance);
    }

    public String getSchool() {
        return this.school;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
