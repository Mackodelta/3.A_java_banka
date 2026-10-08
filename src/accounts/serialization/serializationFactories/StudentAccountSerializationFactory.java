package accounts.serialization.serializationFactories;

import accounts.StudentAccount;
import accounts.serialization.AccountSerializationService;
import accounts.serialization.StudentAccountJsonSerialization;
import accounts.serialization.StudentAccountXmlSerialization;

public class StudentAccountSerializationFactory implements AccountSerializationFactory<StudentAccount>{@Override
public AccountSerializationService<StudentAccount> createJsonService() {
    return new StudentAccountJsonSerialization();
}

    @Override
    public AccountSerializationService<StudentAccount> createXmlService() {
        return new StudentAccountXmlSerialization();
    }
}
