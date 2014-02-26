package soze.software.industries.eMall;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ProductGroup extends HigherarchyBranchObject {

	public final String			name;

	public final MonetaryValue	flatPriceDistortion;
	public final BigDecimal		percentagePriceDistortion;

	private final Set<Product>	products	= new HashSet<>(7);

	public ProductGroup(Long version, Date created, User createdBy, String name, MonetaryValue flatPriceDistortion, BigDecimal percentagePriceDistortion) {
		super(version, created, createdBy);
		this.name = name;
		this.flatPriceDistortion = flatPriceDistortion;
		this.percentagePriceDistortion = percentagePriceDistortion;
	}

	public ProductGroup(User createdBy, String name, MonetaryValue flatPriceDistortion, BigDecimal percentagePriceDistortion) {
		super(createdBy);
		this.name = name;
		this.flatPriceDistortion = flatPriceDistortion;
		this.percentagePriceDistortion = percentagePriceDistortion;
	}

	public void addProduct(Product product) {
		products.add(product);
		childs.add(product);
	}

	@Override
	public String toString() {
		StringBuilder toStringBuilder = new StringBuilder("ProductGroup [name=").append(name).append(", flatPriceDistortion=").append(flatPriceDistortion).append(", percentagePriceDistortion=")
				.append(percentagePriceDistortion).append("%").append("]");
		return toStringBuilder.toString();
	}

	public MonetaryValue evaluateNetDeduction() {
		// TODO Auto-generated method stub
		return null;
	}

	public MonetaryValue evaluateNetDeduction(MonetaryValue price) {
		// TODO Auto-generated method stub
		return null;
	}
}
