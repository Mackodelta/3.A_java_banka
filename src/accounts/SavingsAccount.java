package accounts;

import people.AccountOwner;

public class SavingsAccount extends BankAccount{
    public SavingsAccount(AccountOwner owner, double balance) {
        super(owner, balance);
    }
    @Override
    public void add(double amount){
        System.out.println("Add amount is " + amount);

        this.balance = this.balance + (amount * 1.005);
    }
}
