package accounts.serialization;

import accounts.BusinessAccount;

public class BusinessAccountJsonSerialization implements AccountSerializationService<BusinessAccount>{
    @Override
    public String serialize(BusinessAccount account) {
        if (account == null) return "{}";
        return String.format(
                "{\n" +
                        "  \"type\": \"BUSINESS\",\n" +
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
