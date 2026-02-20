package Hotel.extras;

public class LateCheckout extends Extra{

	public LateCheckout(int price) {
		super(price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public String category() {
		// TODO Auto-generated method stub
		return "LATE CHECKOUT";
	}
}
