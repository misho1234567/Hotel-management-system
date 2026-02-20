package Hotel;

import java.util.ArrayList;
import java.util.List;

import Hotel.extras.Extra;

public class Stay {

	int nights;
	int guests;
	String season; // (ENUM: LOW, MID, PEAK)
	boolean isWorkTrip;
	List<Extra> extras = new ArrayList<>();
	Reservation reservation;
	Room room;
	String customerName;
	List<Stay> stays = new ArrayList<>();
	public void addStay(Stay stay) {
		stays.add(stay);
	}
	public void addExtra(Extra extra) {
		extras.add(extra);
	}
	public Stay(int nights, int guests, String season, boolean isWorkTrip, List<Extra> extras, Room room, String customerName){
		this.nights = nights;
		this.guests = guests;
		this.season = season;
		this.isWorkTrip = isWorkTrip;
		this.room = room;
		this.customerName = customerName;
	}
	
	public Stay(int nights, int guests, String season, boolean isWorkTrip, List<Extra> extras, Room room,String customerName, Reservation reservation) {
		this(reservation.nights, reservation.guests, season, isWorkTrip, extras,reservation.room, reservation.customerName);
		this.reservation = reservation;
	}
	
	public List<Extra> getExtras() {
		return extras;
	}
	public void setExtras(List<Extra> extras) {
		this.extras = extras;
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public List<Stay> getStays() {
		return stays;
	}
	public void setStays(List<Stay> stays) {
		this.stays = stays;
	}
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getNights() {
		return nights;
	}
	public void setNights(int nights) {
		if(nights >= 1)
		this.nights = nights;
	}
	public int getGuests() {
		return guests;
	}
	public void setGuests(int guests) {
		if(guests >= 1)
		this.guests = guests;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public boolean isWorkTrip() {
		return isWorkTrip;
	}
	public void setWorkTrip(boolean isWorkTrip) {
		this.isWorkTrip = isWorkTrip;
	}
	public double roomCost() {
		double price = 0;
		for(int i = 0; i < stays.size(); i++) {
			price = room.nightlyRate(stays.get(i)) * getNights();
		}
		return price;
	}
	public double extrasCost() {
		double sum = 0; 
		for(int i = 0; i < extras.size();i++) {
			sum += extras.get(i).getPrice();
			
		}
		return sum;
	}
	double totalPrice() {
		return roomCost() + extrasCost();
	}
	public List<String> printInvoice(){
		List<String> invoices = new ArrayList<>();
		for(int i = 0; i < stays.size(); i ++) {
			String invoice = "=========== HOTEL INVOICE ===========" + "\n" +
						 "Customer: " + getCustomerName() + "\n" +
						 "Stay: " + "nights: " + getNights()  + ", guests: " + getGuests() +  ", season: " + getSeason() + ", work trip: " + isWorkTrip() + "\n" +
						 "-------------------------------------" + "\n" +
						 "ROOM:" + "\n" +
					 	 "#" + (i+1) + " " + room.category() + ", room id: " + room.id + ", cap: "+ room.capacity + ", Base:" + room.baseRate + ", Rate:" + room.nightlyRate(stays.get(i)) + room.rateNote(stays.get(i)) + "\n" +
					 	 "Room cost: " + roomCost() + " EURO." + "\n" +
					 	"-------------------------------------" +  "\n" +
						"EXTRAS:" + "\n";
					 		for(int j = 0; j < extras.size()-1;j++) {
					 			invoice += "-" + extras.get(j).category() + "(" + extras.get(j).getPrice() + ")" + "\n";
					 		}
						invoice += "Extras cost: " + extrasCost()+ "\n"+
					 	"TOTAL: " + totalPrice() + " EURO." + "\n"+
						"=====================================";

				invoices.add(invoice);		 
		}				 
		return invoices;
	}
}
