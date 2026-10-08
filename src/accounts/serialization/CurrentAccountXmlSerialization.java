package accounts.serialization;

import accounts.CurrentAccount;

public class CurrentAccountXmlSerialization implements AccountSerializationService<CurrentAccount>{
    @Override
    public String serialize(CurrentAccount account) {
        if (account == null) {
            return "<currentAccount />";
        }

        return String.format(
                "<currentAccount>\n" +
                        "    <uuid>%s</uuid>\n" +
                        "    <accountNumber>%s</accountNumber>\n" +
                        "    <owner>%s</owner>\n" +
                        "    <balance>%.2f</balance>\n" +
                        "</currentAccount>",
                account.getUuid(),
                account.getAccountNumber(),
                account.getOwner(),
                account.getBalance()
        );
    }
}
