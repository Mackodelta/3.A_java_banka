package accounts.serialization;

import accounts.BankAccount;

public interface AccountSerializationService<AcountType extends BankAccount> {
    String serialize(AcountType account);
}
