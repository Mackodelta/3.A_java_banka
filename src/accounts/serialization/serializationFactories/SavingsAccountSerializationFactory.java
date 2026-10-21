package accounts.serialization.serializationFactories;

import accounts.SavingsAccount;
import accounts.serialization.*;

public class SavingsAccountSerializationFactory implements AccountSerializationFactory<SavingsAccount>{
    @Override
    public AccountSerializationService<SavingsAccount> createJsonService() {
        return new GsonAccountSerialization<>();
    }

    @Override
    public AccountSerializationService<SavingsAccount> createXmlService() {
        return new JacksonXmlAccountSerialization<>();
    }
}
