package Hotel.extras;

public abstract class Extra {
	double price;
	public Extra(double price) {
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}
	public abstract String category();
	
	
}
