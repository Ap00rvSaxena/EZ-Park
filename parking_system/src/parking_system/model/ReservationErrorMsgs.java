package parking_system.model;

public class ReservationErrorMsgs {
	
	private String errorMsg = "";
	private String timeError="";
	private String permitError= "";
	private String cardNumberError= "";
	private String cvvError = "";
	
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String action) {
		if(action.equalsIgnoreCase("searchP")){
			if (!timeError.equals(""))
				this.errorMsg = "Please correct the following errors";
		}
		else if(action.equalsIgnoreCase("finalPayment")){
			if (!permitError.equals(""))
				this.errorMsg = "Please correct the following errors";
		}
		else{
			if (!cardNumberError.equals("") || !cvvError.equals(""))
				this.errorMsg = "Please correct the following errors";
		}
	}
	public String getTimeError() {
		return timeError;
	}
	public void setTimeError(String timeError) {
		this.timeError = timeError;
	}
	public String getPermitError() {
		return permitError;
	}
	public void setPermitError(String permitError) {
		this.permitError = permitError;
	}
	public String getCardNumberError() {
		return cardNumberError;
	}
	public void setCardNumberError(String cardNumberError) {
		this.cardNumberError = cardNumberError;
	}
	public String getCvvError() {
		return cvvError;
	}
	public void setCvvError(String cvvError) {
		this.cvvError = cvvError;
	}
}
