package soze.software.industries.eMall;

public class MonetaryValue {

    public final RealNumber value;

    public final Currency   currency;

    public MonetaryValue(RealNumber value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }

    @Override
    public String toString() {
        return value + " " + currency;
    }

    public MonetaryValue add(MonetaryValue netAdition) {
        return new MonetaryValue(value.add(evaluateInTheSameCurrency(netAdition)), currency);
    }

    public MonetaryValue subtract(MonetaryValue netDeduction) {
        return new MonetaryValue(value.subtract(evaluateInTheSameCurrency(netDeduction)), currency);
    }

    private RealNumber evaluateInTheSameCurrency(MonetaryValue netDeduction) {
        return netDeduction.value.multiply(netDeduction.currency.getConversionRate(currency));
    }
}
