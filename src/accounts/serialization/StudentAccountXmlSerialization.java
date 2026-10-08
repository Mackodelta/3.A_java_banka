package accounts.serialization;

import accounts.StudentAccount;

public class StudentAccountXmlSerialization implements AccountSerializationService<StudentAccount> {
    @Override
    public String serialize(StudentAccount account) {
        if (account == null) return "<studentAccount />";
        return String.format(
                "<studentAccount>\n" +
                        "    <uuid>%s</uuid>\n" +
                        "    <accountNumber>%s</accountNumber>\n" +
                        "    <owner>%s</owner>\n" +
                        "    <school>%s</school>\n" +
                        "    <balance>%.2f</balance>\n" +
                        "</studentAccount>",
                account.getUuid(),
                account.getAccountNumber(),
                account.getOwner(),
                account.getSchool(),
                account.getBalance()
        );
    }
}
