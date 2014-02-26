package soze.software.industries.eMall;

public class MonetaryValue {

	public final RealNumber	value;

	public final Currency	currency;

	public MonetaryValue(RealNumber value, Currency currency) {
		this.value = value;
		this.currency = currency;
	}

	@Override
	public String toString() {
		return value + " " + currency;
	}

	public MonetaryValue subtract(MonetaryValue netDeduction) {
		return new MonetaryValue(value.subtract(netDeduction.value.multiply(netDeduction.currency.getConversionRate(currency))), currency);
	}
}
