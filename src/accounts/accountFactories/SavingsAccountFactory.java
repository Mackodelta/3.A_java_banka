package accounts.accountFactories;

import accounts.AccountNumberGenerator;
import accounts.AccountNumberGeneratorFactory;
import accounts.BankAccount;
import accounts.SavingsAccount;
import people.Owner;

import java.util.UUID;

public class SavingsAccountFactory implements BankAccountFactory{
    @Override
    public BankAccount create(Owner owner, double balance) {
        AccountNumberGenerator generator = AccountNumberGeneratorFactory.createSimpleLogger();
        String uuid = UUID.randomUUID().toString();
        String accNum = generator.generate();

        SavingsAccount account = new SavingsAccount(uuid, accNum, owner);
        account.setNewBalance(balance);
        return account;
    }
}
