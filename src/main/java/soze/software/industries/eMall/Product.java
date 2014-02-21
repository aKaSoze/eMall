package soze.software.industries.eMall;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Product extends HigherarchyObject {

	public final String					name;

	public final MonetaryValue			price;

	public final Map<String, Object>	properties	= new HashMap<>(7);

	public final Set<ProductGroup>		parentProductGroups = new HashSet<>();

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

	public MonetaryValue getNetPrice() {
		for(ProductGroup productGroup: parentProductGroups) {
			MonetaryValue netDeduction = productGroup.evaluateNetDeduction();
		}
	}

	@Override
	public String toString() {
		return name + " " + price;
	}

}
