package accounts;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimestampedAccountCreationLogger implements AccountCreationLogger{
    @Override
    public void log(String accountNumber) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(timestamp + " - Account created: " + accountNumber);
    }
}
