package soze.software.industries.eMall;

public enum Currency {

	USD(new RealNumber(1)),
	RON(new RealNumber(0.22)),
	EUR(new RealNumber(0.73));

	private final RealNumber	conversionParity;

	private Currency(RealNumber conversionParity) {
		this.conversionParity = conversionParity;
	}

	public RealNumber getConversionRate(Currency otherCurrency) {
		return conversionParity.divide(otherCurrency.conversionParity);
	}

}
