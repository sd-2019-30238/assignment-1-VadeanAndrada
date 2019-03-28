package factory;

public class DiscountFactory {

	public static Discount getDiscount(String furnitureName, String typeDiscount) {
		switch (typeDiscount) {
		case "20%":
			return new WithDiscount20(furnitureName);
		case "50%":
			return new WithDiscount50(furnitureName);
		case "1+1":
			return new WithDiscount1Plus1(furnitureName);
		case "fara":
			return new WithoutDiscount();
		default:
			return null;

		}
	}
}
