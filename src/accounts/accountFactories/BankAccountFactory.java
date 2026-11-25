package accounts.accountFactories;
import Currency.CurrencyType;
import accounts.BankAccount;
import people.Owner;
public interface BankAccountFactory {
    BankAccount create(Owner owner, double balance, CurrencyType currency);

    default BankAccount create(Owner owner, double balance) {
        return create(owner, balance, CurrencyType.CZK);
    }
}
