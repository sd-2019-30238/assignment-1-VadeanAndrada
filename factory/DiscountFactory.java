package factory;

public class DiscountFactory {

	public static Discount getDiscount(String typeDiscount) {
		switch (typeDiscount) {
		case "20%":
			return new WithDiscount20();
		case "50%":
			return new WithDiscount50();
		case "1+1":
			return new WithDiscount1Plus1();
		case "fara":
			return new WithoutDiscount();
		default:
			return null;

		}
	}
}
