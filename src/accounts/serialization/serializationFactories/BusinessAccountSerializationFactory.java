package accounts.serialization.serializationFactories;

import accounts.BusinessAccount;
import accounts.serialization.AccountSerializationService;
import accounts.serialization.BusinessAccountJsonSerialization;
import accounts.serialization.BusinessAccountXmlSerialization;

public class BusinessAccountSerializationFactory implements AccountSerializationFactory<BusinessAccount>{
    @Override
    public AccountSerializationService<BusinessAccount> createJsonService() {
        return new BusinessAccountJsonSerialization();
    }

    @Override
    public AccountSerializationService<BusinessAccount> createXmlService() {
        return new BusinessAccountXmlSerialization();
    }
}
