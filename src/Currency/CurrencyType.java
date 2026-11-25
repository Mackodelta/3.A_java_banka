package Currency;

public enum CurrencyType {
    CZK(1.0),
    ROBUX(0.276);

    private final double rateToCzk;

    CurrencyType(double rateToCzk) {
        this.rateToCzk = rateToCzk;
    }

    public double convertTo(double amount, CurrencyType target) {
        return amount * this.rateToCzk / target.rateToCzk;
    }
}
