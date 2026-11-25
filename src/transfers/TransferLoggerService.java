package transfers;

import Currency.CurrencyType;
import accounts.BankAccount;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TransferLoggerService {
    private final List<Transaction> transactions;

    public TransferLoggerService(List<Transaction> transactions) {
        this.transactions = Objects.requireNonNull(transactions, "transactions must not be null");
    }
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

    public void printStatement(BankAccount account, CurrencyType target) {
        System.out.println("Výpis účtu " + account.getAccountNumber()
                + " (měna účtu: " + account.getCurrency() + ")");
        for (Transaction t : getTransactionsForAccount(account)) {
            System.out.println("  " + t.format(target));
        }
        System.out.println("Zůstatek: " + account.formatBalance(target));
    }
}
