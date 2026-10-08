package accounts.serialization;

import accounts.SavingsAccount;

public class SavingsAccountXmlSerialization implements AccountSerializationService<SavingsAccount> {
    @Override
    public String serialize(SavingsAccount account) {
        if (account == null) return "<savingsAccount />";
        return String.format(
                "<savingsAccount>\n" +
                        "    <uuid>%s</uuid>\n" +
                        "    <accountNumber>%s</accountNumber>\n" +
                        "    <owner>%s</owner>\n" +
                        "    <balance>%.2f</balance>\n" +
                        "</savingsAccount>",
                account.getUuid(),
                account.getAccountNumber(),
                account.getOwner(),
                account.getBalance()
        );
    }
}