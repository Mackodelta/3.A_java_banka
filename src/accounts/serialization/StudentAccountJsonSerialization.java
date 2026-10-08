package accounts.serialization;

import accounts.StudentAccount;

public class StudentAccountJsonSerialization implements AccountSerializationService<StudentAccount>{
    @Override
    public String serialize(StudentAccount account) {
        if (account == null) return "{}";
        return String.format(
                "{\n" +
                        "  \"type\": \"STUDENT\",\n" +
                        "  \"uuid\": \"%s\",\n" +
                        "  \"accountNumber\": \"%s\",\n" +
                        "  \"owner\": \"%s\",\n" +
                        "  \"school\": \"%s\",\n" +
                        "  \"balance\": %.2f\n" +
                        "}",
                account.getUuid(),
                account.getAccountNumber(),
                account.getOwner(),
                account.getSchool(),
                account.getBalance()
        );
    }
}
