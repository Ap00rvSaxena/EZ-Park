package parking_system.model;

public class ParkingArea {

	private static final long serialVersionUID = 3L;
	private String parking_area_name;
	private String type;
	private String floor;
	private String capacity;
	private String reserved;
	private String available;
	
	public String getReserved() {
		return reserved;
	}

	public void setReserved(String reserved) {
		this.reserved = reserved;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}
		
	/*private String search = "";	
	
	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}
*/
	public String getParking_area_name() {
		return parking_area_name;
	}

	public void setParking_area_name(String parking_area_name) {
		this.parking_area_name = parking_area_name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getfloor() {
		return floor;
	}

	public void setfloor(String floor) {
		this.floor = floor;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	
	public void setParkingArea(String parking_area_name, String type, String floor, String capacity,String reserved,String available) {
		setParking_area_name(parking_area_name);
		setType(type);
		setfloor(floor);
		setCapacity(capacity);
		setReserved(reserved);
		setAvailable(available);
	}
	
	
	public void  validateParkingArea(String action, ParkingArea parkingArea, ParkingAreaErrorMsgs errorMsg){			
			errorMsg.setParkingAreaNameError(validateParkingAreaName(action, parkingArea.getParking_area_name()));
			errorMsg.setFloorError(validateFloor(action, parkingArea.getfloor()));
			errorMsg.setCapacityError(validateCapacity(action, parkingArea.getCapacity()));
			errorMsg.setReservedErro(validateReserved(action, parkingArea.getReserved()));
			errorMsg.setAvailableError(validateAvailable(action, parkingArea.getAvailable()));
			errorMsg.setErrorMsg(action);		
		}
	
	private String validateParkingAreaName(String action, String name){
		String msg="";
			if(name.equals("")){
				msg="Please provide ParkingArea Name";
				
			}
			else if(name.length()<3){
				msg="ParkingArea name should be at least 3 letter long";
			}
		return msg;
	}

	private String validateFloor(String action, String floor){
		String msg="";
			if(floor.equals("")){
				msg="Please provide Floor";	
			}		
			else if (!isTextAnInteger(floor)){
				msg = "Floor can not be Alphabet";
			}
		return msg;
	}

	private String validateCapacity(String action, String capacity){
		String msg="";
		if(capacity.equals("")){
			msg="Please provide Capacity";	
		}		
		else if (!isTextAnInteger(capacity)){
			msg = "Capacity can not be Alphabet";
		}
		return msg;
	}
	
	private String validateReserved(String action, String reserved){
		String msg="";
		
		if(action.equalsIgnoreCase("updateParkingAreaInDB")){
			
			if(reserved.equals("")){
				msg="Please provide Reserved";	
			}		
			else if (!isTextAnInteger(reserved)){
				msg = "Reserved can not be Alphabet";
			}
			 			
		}
		
		return msg;
	}
	
	private String validateAvailable(String action, String available){
		String msg="";
		
		if(action.equalsIgnoreCase("updateParkingAreaInDB")){
			
			if(available.equals("")){
				msg="Please provide Available";	
			}		
			else if (!isTextAnInteger(available)){
				msg = "Available can not be Alphabet";
			}

		}
		
		return msg;
	}
	
	private boolean isTextAnInteger (String string) {
        boolean result;
		try
        {
            Long.parseLong(string);
            result=true;
        } 
        catch (NumberFormatException e) 
        {
            result=false;
        }
		return result;
	}	
}
