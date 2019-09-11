package parking_system.model;

public class ParkingAreaErrorMsgs {
	
	private String errorMsg;
	private String ParkingAreaNameError;
	private String reservedErro;
	private String availableError;
	private String floorError;
	private String capacityError;
		
	public ParkingAreaErrorMsgs() {
		this.errorMsg = "";
	}
	
	public String getReservedErro() {
		return reservedErro;
	}
	public void setReservedErro(String reservedErro) {
		this.reservedErro = reservedErro;
	}
	public String getAvailableError() {
		return availableError;
	}
	public void setAvailableError(String availableError) {
		this.availableError = availableError;
	}

	public String getCapacityError() {
		return capacityError;
	}
	public void setCapacityError(String capacityError) {
		this.capacityError = capacityError;
	}


	public String getFloorError() {
		return floorError;
	}
	public void setFloorError(String floorError) {
		this.floorError = floorError;
	}


	public String getParkingAreaNameError() {
		return ParkingAreaNameError;
	}


	public void setParkingAreaNameError(String parkingAreaNameError) {
		ParkingAreaNameError = parkingAreaNameError;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String action) {
		
		if(action.equalsIgnoreCase("saveParkingArea"))
		{

			if(!ParkingAreaNameError.equals("")||!floorError.equals("")||!capacityError.equals(""))
			{
				this.errorMsg = "Please correct the following errors";
			}
		
		}
		
		else if(action.equals("updateParkingAreaInDB"))
		{
			if(!ParkingAreaNameError.equals("")||!floorError.equals("")||!capacityError.equals("")||!reservedErro.equals("")||!availableError.equals(""))
			{
				this.errorMsg = "Please correct the following errors";
			}
			
		}
			
	}
}
