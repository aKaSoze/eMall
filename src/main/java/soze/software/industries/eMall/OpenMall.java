package soze.software.industries.eMall;

import static soze.software.industries.eMall.Currency.RON;

import java.math.BigDecimal;

public class OpenMall {

	public static void main(String[] args) {

		User user = new User("Kaiser", "Soze");
		MonetaryValue rogAsusPrice = new MonetaryValue(BigDecimal.valueOf(8499.99), RON);

		Product rogAsus = new Product(user, "Laptop Asus", rogAsusPrice);
		rogAsus.addProperty("screen size", "17''");
		rogAsus.addProperty("number of cores", 4L);

		MonetaryValue razerPrice = new MonetaryValue(BigDecimal.valueOf(4300), RON);
		Product noteBookRazer = new Product(user, "Notebook Razer Extreme", razerPrice);

		MonetaryValue flatPriceDistortion = new MonetaryValue(BigDecimal.valueOf(-400), RON);
		ProductGroup productGroup = new ProductGroup(user, "Laptops/Notebook", flatPriceDistortion, BigDecimal.valueOf(-3));

		productGroup.products.add(rogAsus);
		productGroup.products.add(noteBookRazer);

		ProductGroup compProductGroup = new ProductGroup(user, "Computers", flatPriceDistortion, BigDecimal.valueOf(-3));
		compProductGroup.childs.add(productGroup);
		
		System.out.println(productGroup);
		
	}

}
