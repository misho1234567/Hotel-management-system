package Hotel.extras;

public  class Pet extends Extra {
	public Pet(double price) {
		super(price);
	}
	@Override
	public double getPrice() {
		return price;
	}
	@Override
	public String category() {
		// TODO Auto-generated method stub
		return "PET";
	}
}
