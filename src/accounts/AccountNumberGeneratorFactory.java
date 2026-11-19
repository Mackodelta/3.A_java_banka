package accounts;

import java.util.Objects;

public class AccountNumberGeneratorFactory {
        private final AccountCreationLogger simpleLogger;
        private final AccountCreationLogger timestampedLogger;

        public AccountNumberGeneratorFactory(
                AccountCreationLogger simpleLogger,
                AccountCreationLogger timestampedLogger) {
            this.simpleLogger = Objects.requireNonNull(simpleLogger, "simpleLogger must not be null");
            this.timestampedLogger = Objects.requireNonNull(timestampedLogger, "timestampedLogger must not be null");
        }

        public AccountNumberGenerator createSimpleLogger() {
            return new AccountNumberGenerator(simpleLogger);
        }

        public AccountNumberGenerator createTimestampedLogger() {
            return new AccountNumberGenerator(timestampedLogger);
        }
}
