package Hotel.extras;

public class Breakfast extends Extra {
	int guests;
	int days;
	public Breakfast(double price, int days, int guests) {
		super(price);
		this.days = days;
		this.guests = guests;
	}
	
	@Override
	public double getPrice() {
		return price * days * guests;
	}

	@Override
	public String category() {
		// TODO Auto-generated method stub
		return "BREAKFAST";
	}
}
