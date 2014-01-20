package soze.software.industries.eMall;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ProductGroup extends PersistentObject {

	public final String				name;

	public final Set<ProductGroup>	parents		= new HashSet<>(1);
	public final Set<ProductGroup>	childs		= new HashSet<>(7);	;

	public final MonetaryValue		flatPriceDistortion;
	public final BigDecimal			percentagePriceDistortion;

	public final Set<Product>		products	= new HashSet<>(7);

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

	@Override
	public String toString() {
		StringBuilder toString = new StringBuilder("ProductGroup name=" + name + ", flatPriceDistortion=" + flatPriceDistortion + ", percentagePriceDistortion=" + percentagePriceDistortion);

		toString.append("\n |");
		toString.append("\n \\");

		String offset = " ";

		for (Product product : products) {
			toString.append("\n" + offset + "- " + product);
		}

		return toString.toString();
	}

}
