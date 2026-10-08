package accounts.serialization;

import accounts.CurrentAccount;

public class CurrentAccountJsonSerialization implements AccountSerializationService<CurrentAccount>{
    @Override
    public String serialize(CurrentAccount account) {
        if (account == null) return "{}";
        return String.format(
                "{\n" +
                        "  \"type\": \"CURRENT\",\n" +
                        "  \"uuid\": \"%s\",\n" +
                        "  \"accountNumber\": \"%s\",\n" +
                        "  \"owner\": \"%s\",\n" +
                        "  \"balance\": %.2f\n" +
                        "}",
                account.getUuid(),
                account.getAccountNumber(),
                account.getOwner(),
                account.getBalance()
        );
    }
}
