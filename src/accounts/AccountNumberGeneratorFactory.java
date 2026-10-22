package accounts;

public class AccountNumberGeneratorFactory {
    public static AccountNumberGenerator createSimpleLogger() {
        return new AccountNumberGenerator(new SimpleAccountCreationLogger());
    }
    public static AccountNumberGenerator createTimestampedLogger() {
        return new AccountNumberGenerator(new TimestampedAccountCreationLogger());
    }
}
