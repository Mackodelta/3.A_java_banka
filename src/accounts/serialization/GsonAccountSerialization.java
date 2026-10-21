package accounts.serialization;

import accounts.BankAccount;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonAccountSerialization<bankAccount extends BankAccount> implements AccountSerializationService<bankAccount> {
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public String serialize(bankAccount account) {
        if (account == null) {
            return "{}";
        }
        return gson.toJson(account);
    }
}
