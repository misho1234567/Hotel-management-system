package Hotel;

public class BusinessRoom extends Room{

	int freeMeetingHours;
	BusinessRoom(int id, int capacity, double baseRate, int freeMeetingHours) {
		super(id, capacity, baseRate);
		// TODO Auto-generated constructor stub
		this.freeMeetingHours = freeMeetingHours;
	}
	BusinessRoom(int capacity, double baseRate, int freeMeetingHours) {
		super(capacity, baseRate);
		// TODO Auto-generated constructor stub
		this.freeMeetingHours = freeMeetingHours;
	}
	@Override
	public double nightlyRate(Stay stay) {
		double output = baseRate;
		if( stay.isWorkTrip == true ) {
			output += output * 12 / 100;
		}
		return output;
	}

	@Override
	public String category(){
		return "BUSSINES ROOM";
	}
	@Override
	protected String rateNote(Stay stay) {
		if(stay.isWorkTrip == true ) {
			return "(WORK +12%)";
		}else {
			return "";
		}
	}
}
