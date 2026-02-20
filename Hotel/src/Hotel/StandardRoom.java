package Hotel;

public class StandardRoom extends Room{

	StandardRoom(int capacity, double baseRate) {
		super(capacity, baseRate);
	}
	StandardRoom(int id, int capacity, double baseRate) {
		super(id, capacity, baseRate);
	}
	@Override
	public double nightlyRate(Stay stay) {
		double output = baseRate;
		if(stay.season.equals("PEAK")) {
			output += output * 0.15;
		}
		return output;
	}
	@Override
	public String category(){
		return "STANDART ROOM";
	}
	@Override
	protected String rateNote(Stay stay) {
		if(stay.season.equals("PEAK")) {
		return "(PEAK +15%)";
		}
		return "";
	}
}
