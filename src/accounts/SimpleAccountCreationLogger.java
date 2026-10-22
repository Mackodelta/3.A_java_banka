package accounts;

public class SimpleAccountCreationLogger implements AccountCreationLogger{
    @Override
    public void log(String accountNumber) {
        System.out.println("Account created: " + accountNumber);
    }
}
