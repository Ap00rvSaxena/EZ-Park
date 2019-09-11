package parking_system.model;

public class ParkingDetails {

	private static final long serialVersionUID = 3L;
	private String parkingAreaName;
	private String type;
	private int floor;
	private int capacity;
	private int reserved;
	private int available;
	
	public void setParking(String parkingAreaName, String type, int floor, int capacity, int reserved, int available) {
		setParkingAreaName(parkingAreaName);
		setType(type);
		setFloor(floor);
		setCapacity(capacity);
		setReserved(reserved);
		setAvailable(available);
	}

	public String getParkingAreaName() {
		return parkingAreaName;
	}

	public void setParkingAreaName(String parkingAreaName) {
		this.parkingAreaName = parkingAreaName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getReserved() {
		return reserved;
	}

	public void setReserved(int reserved) {
		this.reserved = reserved;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

}
