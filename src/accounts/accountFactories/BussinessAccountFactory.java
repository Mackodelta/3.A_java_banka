package accounts.accountFactories;

import accounts.AccountNumberGenerator;
import accounts.BankAccount;
import accounts.BusinessAccount;
import people.Owner;

import java.util.UUID;

public class BussinessAccountFactory implements BankAccountFactory{
    @Override
    public BankAccount create(Owner owner, double balance) {
        String uuid = UUID.randomUUID().toString();
        String accNum = AccountNumberGenerator.generate();

        BusinessAccount account = new BusinessAccount(uuid, accNum, owner);
        account.setNewBalance(balance);
        return account;
    }
}
