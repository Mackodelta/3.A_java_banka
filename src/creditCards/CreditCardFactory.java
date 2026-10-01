package creditCards;

import people.Owner;

public class CreditCardFactory {
    public static CreditCard create(Owner owner, double balance) {
        return new CreditCard(owner, balance);
    }

    /**
     * Vytvoří kartu s nulovým počátečním zůstatkem.
     */
    public static CreditCard createDefault(Owner owner) {
        return new CreditCard(owner, 0.0);
    }
}
