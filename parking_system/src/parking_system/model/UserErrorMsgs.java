package parking_system.model;

public class UserErrorMsgs {
	
	private String errorMsg;
	private String userNameError;
	private String userFirstNameError;
	private String userLastNameError;
	private String userEmailError;
	private String userPasswordError;
	private String utaIDerror;
	private String phoneError;
	private String streetAddError;
	private String cityError;
	private String stateError;
	private String zipCodeError;
	private String vehicleNumberError;
	
	private String searchError;
	
	public UserErrorMsgs() {
		//super();
		this.errorMsg = "";
		this.userNameError = "";
		this.userFirstNameError = "";
		this.userLastNameError = "";
		this.userEmailError = "";
		this.userPasswordError = "";
		this.utaIDerror = "";
		this.phoneError = "";
		this.streetAddError = "";
		this.cityError = "";
		this.stateError = "";
		this.zipCodeError = "";
		this.vehicleNumberError = "";
		this.searchError = "";
	}

	
	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String action) {
		if(action.equalsIgnoreCase("saveUser") || action.equalsIgnoreCase("updateUserInDB"))
		{
			if(!userNameError.equals("") || !userFirstNameError.equals("") || !userLastNameError.equals("")|| !userEmailError.equals("") 
			|| !userPasswordError.equals("") || !utaIDerror.equals("") || !phoneError.equals("") || !streetAddError.equals("")
			|| !cityError.equals("") || !stateError.equals("") || !zipCodeError.equals("") || !vehicleNumberError.equals(""))
			{
				this.errorMsg = "Please correct the following errors";
			}
		}
				
		else if(action.equals("loginUser")){
			if(!userNameError.equals("") || !userPasswordError.equals("")){
				this.errorMsg="Please enter your details";
			}
			
		}
		
		else{ //if(action.equals("searchUser"))
			if(!searchError.equals("")){
				this.errorMsg="Please enter search details";
			}
			
		}
		
	}

	public String getUserNameError() {
		return userNameError;
	}

	public void setUserNameError(String userNameError) {
		this.userNameError = userNameError;
	}

	public String getUserFirstNameError() {
		return userFirstNameError;
	}

	public void setUserFirstNameError(String userFirstNameError) {
		this.userFirstNameError = userFirstNameError;
	}

	public String getUserLastNameError() {
		return userLastNameError;
	}

	public void setUserLastNameError(String userLastNameError) {
		this.userLastNameError = userLastNameError;
	}

	public String getUserEmailError() {
		return userEmailError;
	}

	public void setUserEmailError(String userEmailError) {
		this.userEmailError = userEmailError;
	}

	public String getUserPasswordError() {
		return userPasswordError;
	}

	public void setUserPasswordError(String userPasswordError) {
		this.userPasswordError = userPasswordError;
	}

	public String getUtaIDerror() {
		return utaIDerror;
	}

	public void setUtaIDerror(String utaIDerror) {
		this.utaIDerror = utaIDerror;
	}

	public String getPhoneError() {
		return phoneError;
	}

	public void setPhoneError(String phoneError) {
		this.phoneError = phoneError;
	}

	public String getStreetAddError() {
		return streetAddError;
	}

	public void setStreetAddError(String streetAddError) {
		this.streetAddError = streetAddError;
	}

	public String getCityError() {
		return cityError;
	}

	public void setCityError(String cityError) {
		this.cityError = cityError;
	}

	public String getStateError() {
		return stateError;
	}

	public void setStateError(String stateError) {
		this.stateError = stateError;
	}

	public String getZipCodeError() {
		return zipCodeError;
	}

	public void setZipCodeError(String zipCodeError) {
		this.zipCodeError = zipCodeError;
	}

	public String getVehicleNumberError() {
		return vehicleNumberError;
	}

	public void setVehicleNumberError(String vehicleNumberError) {
		this.vehicleNumberError = vehicleNumberError;
	}
	
	public String getSearchError() {
		return searchError;
	}

	public void setSearchError(String searchError) {
		this.searchError = searchError;
	}
	
	
	
	
	
}
