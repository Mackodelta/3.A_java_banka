package accounts.serialization.serializationFactories;

import accounts.CurrentAccount;
import accounts.serialization.AccountSerializationService;
import accounts.serialization.CurrentAccountJsonSerialization;
import accounts.serialization.CurrentAccountXmlSerialization;

public class CurrentAccountSerializationFactory implements AccountSerializationFactory<CurrentAccount>{
    @Override
    public AccountSerializationService<CurrentAccount> createJsonService() {
        return new CurrentAccountJsonSerialization();
    }
    @Override
    public AccountSerializationService<CurrentAccount> createXmlService() {
        return new CurrentAccountXmlSerialization();
    }
}
