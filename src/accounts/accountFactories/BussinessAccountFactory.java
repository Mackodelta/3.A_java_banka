package accounts.accountFactories;

import accounts.AccountNumberGenerator;
import accounts.AccountNumberGeneratorFactory;
import accounts.BankAccount;
import accounts.BusinessAccount;
import people.Owner;

import java.util.UUID;

public class BussinessAccountFactory implements BankAccountFactory{
    @Override
    public BankAccount create(Owner owner, double balance) {
        AccountNumberGenerator generator = AccountNumberGeneratorFactory.createSimpleLogger();
        String uuid = UUID.randomUUID().toString();
        String accNum = generator.generate();

        BusinessAccount account = new BusinessAccount(uuid, accNum, owner);
        account.setNewBalance(balance);
        return account;
    }
}
