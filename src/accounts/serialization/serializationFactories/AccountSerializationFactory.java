package accounts.serialization.serializationFactories;

import accounts.BankAccount;
import accounts.serialization.AccountSerializationService;

public interface AccountSerializationFactory <AccountType extends BankAccount>{
    AccountSerializationService<AccountType> createJsonService();
    AccountSerializationService<AccountType> createXmlService();
}
