package Hotel.extras;

public class Parking extends Extra {
	int nights;
	public Parking(int price, int nights) {
		super(price);
		this.nights = nights;
	}
	@Override
	public double getPrice() {
		return price * nights;
	}
	@Override
	public String category() {
		// TODO Auto-generated method stub
		return "PARKING";
	}
}
