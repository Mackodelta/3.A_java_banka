package accounts.serialization.serializationFactories;

import accounts.BusinessAccount;
import accounts.serialization.*;

public class BusinessAccountSerializationFactory implements AccountSerializationFactory<BusinessAccount>{
    @Override
    public AccountSerializationService<BusinessAccount> createJsonService() {
        return new GsonAccountSerialization<>();
    }

    @Override
    public AccountSerializationService<BusinessAccount> createXmlService() {
        return new JacksonXmlAccountSerialization<>();
    }
}
