package accounts.serialization.serializationFactories;

import accounts.StudentAccount;
import accounts.serialization.*;

public class StudentAccountSerializationFactory implements AccountSerializationFactory<StudentAccount>{
    @Override
    public AccountSerializationService<StudentAccount> createJsonService() {
        return new GsonAccountSerialization<>();
}

    @Override
    public AccountSerializationService<StudentAccount> createXmlService() {
        return new JacksonXmlAccountSerialization<>();
    }
}
