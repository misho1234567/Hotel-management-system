package builders;

import Hotel.extras.Breakfast;
import Hotel.extras.Extra;
import Hotel.extras.LateCheckout;
import Hotel.extras.NoExtra;
import Hotel.extras.Parking;
import Hotel.extras.Pet;
import Hotel.extras.Spa;

public class ExtraBuilder {
	int guests;
	int nights;
	
	public ExtraBuilder addGuests(int guests) {
		this.guests = guests;
		return this;
	}
	
	public ExtraBuilder addDays(int days) {
		this.nights = days;
		return this;
	}
	
	public Extra createExtra(int code) {

		if (code == 1) {
			return new Breakfast(12, nights, guests);
		} else if (code == 2) {
			return new Parking(8, nights) ;
		} else if(code == 3) {
			return new Pet(30);
		}else if(code == 4) {
			return new LateCheckout(20);
		}else if (code == 5) {
			return new Spa(18, nights, guests) ;
		} else if (code == 6){
			return new NoExtra(0);
		}else {
			return null;
		}
	}
	
//	public String getMenu() {
//		
//	}
}
