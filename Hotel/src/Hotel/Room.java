package Hotel;

abstract class Room {

	int id;
	int capacity;
	double baseRate;
	static int nextId = 1;
	
	Room(int capacity, double baseRate){
		this.capacity = capacity;
		this.baseRate = baseRate;
		nextId++;
		id = nextId;
	}
	Room(int id, int capacity, double baseRate){
		this.capacity = capacity;
		this.baseRate = baseRate;
		if(id > nextId) {
			this.id = id;
			nextId = id;
		}
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		if(capacity >= 1) {
			this.capacity = capacity;
		}
	}
	public double getBaseRate() {
		return baseRate;
	}
	public void setBaseRate(double baseRate) {
		if(baseRate > 0) {
			this.baseRate = baseRate;
		}
	}
	int IdReturn(){
		return id; 
	}
	int CapacityReturn() {
		return capacity;
	}
	double BaseRateReturn() {
		return baseRate;
	}
	public abstract double nightlyRate(Stay stay);
	public String category() {
		return "ROOM";
	}
	protected String rateNote(Stay stay) {
		return "";
	}
	
	
}
