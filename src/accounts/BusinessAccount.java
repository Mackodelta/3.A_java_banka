package accounts;

import people.AccountOwner;

public class BusinessAccount extends BankAccount{
    public BusinessAccount(AccountOwner owner) {
        super(owner);
    }
    @Override
    public void sub(double amount){
        System.out.println("Sub amount is " + amount);

        double newBalance = balance - amount*1.01;

        if (newBalance < 0) {
            throw new RuntimeException("Balance is negative");
        }

        this.balance = newBalance;
    }
}
