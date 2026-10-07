package transfers;

import accounts.BankAccount;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TransferLoggerService {
    private final List<Transaction> transactions = new ArrayList<>();

    public void log(Transaction transaction) {
        if (transaction != null) {
            this.transactions.add(transaction);
        }
    }

    public List<Transaction> getAllTransactions() {
        return Collections.unmodifiableList(this.transactions);
    }

    public List<Transaction> getTransactionsForAccount(BankAccount account) {
        return transactions.stream()
                .filter(t -> t.getFromAccount() == account || t.getToAccount() == account)
                .collect(Collectors.toList());
    }
}
