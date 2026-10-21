package accounts.serialization.serializationFactories;

import accounts.CurrentAccount;
import accounts.serialization.*;

public class CurrentAccountSerializationFactory implements AccountSerializationFactory<CurrentAccount>{
    @Override
    public AccountSerializationService<CurrentAccount> createJsonService() {
        return new GsonAccountSerialization<>();
    }
    @Override
    public AccountSerializationService<CurrentAccount> createXmlService() {
        return new JacksonXmlAccountSerialization<>();
    }
}
