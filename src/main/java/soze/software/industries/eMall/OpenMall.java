package soze.software.industries.eMall;

import static soze.software.industries.eMall.Currency.RON;

public class OpenMall {

	public static void main(String[] args) {

		User user = new User("Kaiser", "Soze");
		MonetaryValue rogAsusPrice = new MonetaryValue(new RealNumber(8499.99), RON);

		Product rogAsus = new Product(user, "Laptop Asus", rogAsusPrice);
		rogAsus.addProperty("screen size", "17''");
		rogAsus.addProperty("number of cores", 4L);

		MonetaryValue razerPrice = new MonetaryValue(new RealNumber(4300), RON);
		Product noteBookRazer = new Product(user, "Notebook Razer Extreme", razerPrice);

		MonetaryValue flatPriceDistortion = new MonetaryValue(new RealNumber(-400), RON);
		ProductGroup productGroup = new ProductGroup(user, "Laptops/Notebook", flatPriceDistortion, new RealNumber(-3));

		productGroup.addProduct(rogAsus);
		productGroup.addProduct(noteBookRazer);

		ProductGroup compProductGroup = new ProductGroup(user, "Computers", flatPriceDistortion, new RealNumber(-1.5));
		compProductGroup.childs.add(productGroup);

		System.out.println(compProductGroup.toString(0L));
	}

}
