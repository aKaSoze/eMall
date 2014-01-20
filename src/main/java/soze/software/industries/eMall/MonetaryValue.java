package soze.software.industries.eMall;

import java.math.BigDecimal;

public class MonetaryValue {

	public final BigDecimal value;
	
	public final Currency currency;

	public MonetaryValue(BigDecimal value, Currency currency) {
		this.value = value;
		this.currency = currency;
	}
	
}
