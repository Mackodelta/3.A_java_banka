package transfers;
import accounts.BankAccount;
import accounts.BusinessAccount;

public class TransferService {
    public void transfer(BankAccount from, BankAccount to, double amount) {
        if (from == null || to == null || from == to || amount <= 0) {
            return;
        }
        double fee = (from instanceof BusinessAccount) ? amount * 0.003 : 0.0;
        double total = amount + fee;
        if (from.getBalance() < total) {
            return;
        }
        from.setNewBalance(from.getBalance() - total);
        to.setNewBalance(to.getBalance() + amount);
    }
}
