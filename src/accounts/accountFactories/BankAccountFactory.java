package accounts.accountFactories;
import accounts.BankAccount;
import people.Owner;
public interface BankAccountFactory {
    BankAccount create(Owner owner, double balance);
}
