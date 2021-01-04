package week05d04;

public class ProductSenior {

    private final long price;
    private final Currency currency;

    public ProductSenior(long price, Currency currency) {
        if (!(currency == Currency.HUF || currency == Currency.USD)) {
            throw new IllegalArgumentException("Currency must be HUF or USD.");
        }
        this.price = price;
        this.currency = currency;
    }

    public long getPrice() {
        return price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public double convertPrice(Currency currency) {
        return price * this.currency.getExchangeRate() / currency.getExchangeRate();
    }

}
