package soze.software.industries.eMall;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

public class Product extends HigherarchyObject {

	public final String					name;

	public final MonetaryValue			price;

	public final Map<String, Object>	properties			= new HashMap<>(7);

	public final Set<ProductGroup>		parentProductGroups	= new HashSet<>();

	public Product(Long version, Date created, User createdBy, String name, MonetaryValue price) {
		super(version, created, createdBy);
		this.name = name;
		this.price = price;
	}

	public Product(User createdBy, String name, MonetaryValue price) {
		super(createdBy);
		this.name = name;
		this.price = price;
	}

	public <PropertyType> void addProperty(String name, PropertyType value) {
		properties.put(name, value);
	}

	@SuppressWarnings("unchecked")
	public <PropertyType> PropertyType getProperty(String name) {
		return (PropertyType) properties.get(name);
	}

	public MonetaryValue getNetPrice(SortedSet<ProductGroup> inclusionRoute) {
		MonetaryValue netPrice = price;
		for (ProductGroup productGroup : parentProductGroups) {
			netPrice = netPrice.subtract(productGroup.evaluateNetDeduction(netPrice));
		}
		return netPrice;
	}

	@Override
	public String toString() {
		return name + " " + price;
	}

}
