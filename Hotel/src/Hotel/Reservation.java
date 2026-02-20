package Hotel;

import java.util.ArrayList;
import java.util.List;

import Hotel.extras.Extra;
import builders.ExtraBuilder;

public class Reservation {

	Room room;
	int nights;
	int guests;
	String customerName;
	
	
	Reservation(Room room ,String customerName, int nights, int guests){
		this.room = room;
		this.customerName = customerName;
		this.nights = nights;
		this.guests = guests;
	}
	double roomCost() {
		return room.baseRate * nights;
	}
	
//	double extrasCost() {
//		
//	}

	

}
