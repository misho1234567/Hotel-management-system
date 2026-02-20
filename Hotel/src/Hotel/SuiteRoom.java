package Hotel;

public class SuiteRoom extends Room{

	boolean seaView; 
	SuiteRoom(int id, int capacity, double baseRate, boolean seaView) {
		super(id, capacity, baseRate);
		// TODO Auto-generated constructor stub
		this.seaView = seaView;
	}
	SuiteRoom( int capacity, double baseRate, boolean seaView) {
		super(capacity, baseRate);
		// TODO Auto-generated constructor stub
		this.seaView = seaView;
	}
	

	@Override
	public double nightlyRate(Stay stay) {
		double output = baseRate;
		if(seaView == true) {
			output += output * 0.25;
		}
		if(stay.nights >= 5) {
			output -= output * 0.1;
		}
		return output;
	}
	@Override
	protected String rateNote(Stay stay) {
		if(seaView == true && stay.getNights() >= 5) {
			return "(VIEW +25%), (LONG -10%)";
		}else if(seaView == true) {
			return "(VIEW +25%)";
		}else if(stay.getNights() >= 5) {
			return "(LONG -10%)";
		}else {
			return "";
		}
	}

}
