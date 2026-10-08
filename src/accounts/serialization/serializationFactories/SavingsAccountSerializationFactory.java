package accounts.serialization.serializationFactories;

import accounts.SavingsAccount;
import accounts.serialization.AccountSerializationService;
import accounts.serialization.SavingsAccountJsonSerialization;
import accounts.serialization.SavingsAccountXmlSerialization;

public class SavingsAccountSerializationFactory implements AccountSerializationFactory<SavingsAccount>{
    @Override
    public AccountSerializationService<SavingsAccount> createJsonService() {
        return new SavingsAccountJsonSerialization();
    }

    @Override
    public AccountSerializationService<SavingsAccount> createXmlService() {
        return new SavingsAccountXmlSerialization();
    }
}
