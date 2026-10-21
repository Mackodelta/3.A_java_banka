package accounts.serialization;

import accounts.BankAccount;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class JacksonXmlAccountSerialization<bankAccount extends BankAccount> implements AccountSerializationService<bankAccount> {
    private final XmlMapper xmlMapper = new XmlMapper();

    @Override
    public String serialize(bankAccount account) {
        if (account == null) {
            return "<account />";
        }

        try {
            // Jackson automaticky přečte gettery účtu a sestaví korektní XML
            return xmlMapper.writeValueAsString(account);
        } catch (Exception e) {
            throw new RuntimeException("Chyba při XML serializaci účtu", e);
        }
    }
}
