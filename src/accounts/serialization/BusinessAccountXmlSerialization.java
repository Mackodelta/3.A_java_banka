package accounts.serialization;

import accounts.BusinessAccount;

public class BusinessAccountXmlSerialization implements AccountSerializationService<BusinessAccount> {
    @Override
    public String serialize(BusinessAccount account) {
        if (account == null) return "<businessAccount />";
        return String.format(
                "<businessAccount>\n" +
                        "    <uuid>%s</uuid>\n" +
                        "    <accountNumber>%s</accountNumber>\n" +
                        "    <owner>%s</owner>\n" +
                        "    <balance>%.2f</balance>\n" +
                        "</businessAccount>",
                account.getUuid(),
                account.getAccountNumber(),
                account.getOwner(),
                account.getBalance()
        );
    }
}