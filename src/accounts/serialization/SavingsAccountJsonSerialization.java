package accounts.serialization;

import accounts.SavingsAccount;

public class SavingsAccountJsonSerialization implements AccountSerializationService<SavingsAccount>{
    @Override
    public String serialize(SavingsAccount account) {
        if (account == null) return "{}";
        return String.format(
                "{\n" +
                        "  \"type\": \"SAVINGS\",\n" +
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
