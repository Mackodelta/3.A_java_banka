import java.util.Random;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AccountNumberGenerator {
    private static final String BANK_CODE = "2010";
    private static final Random RANDOM = new Random();

    public static String generate() {
        // Generuje číslo od 1 000 000 000 do 9 999 999 999
        long number = 1_000_000_000L + (long) (RANDOM.nextDouble() * 9_000_000_000L);
        String accountNumber = number + "/" + BANK_CODE;
        logAccountCreation(accountNumber);
        return accountNumber;
    }

    private static void logAccountCreation(String accountNumber) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(timestamp + " - Account created: " + accountNumber);
    }
}
