package parking_system.functions;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Parking_SystemFunctions {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public void register (WebDriver driver, String username, String firstName, String lastName, String email, String password, String role, String utaid, String phone, String streetaddress, String city, String state, String zipcode, String vehiclenumber, String permit){
		driver.findElement(By.name(prop.getProperty("Txt_Register_username"))).clear();
		driver.findElement(By.name(prop.getProperty("Txt_Register_username"))).sendKeys(username);
		driver.findElement(By.name(prop.getProperty("Txt_Register_firstName"))).clear();
		driver.findElement(By.name(prop.getProperty("Txt_Register_firstName"))).sendKeys(firstName);
		driver.findElement(By.name(prop.getProperty("Txt_Register_lastName"))).clear();
		driver.findElement(By.name(prop.getProperty("Txt_Register_lastName"))).sendKeys(lastName);
		driver.findElement(By.name(prop.getProperty("Txt_Register_email"))).clear();
		driver.findElement(By.name(prop.getProperty("Txt_Register_email"))).sendKeys(email);
		driver.findElement(By.name(prop.getProperty("Txt_Register_password"))).clear();
		driver.findElement(By.name(prop.getProperty("Txt_Register_password"))).sendKeys(password);
		new Select(driver.findElement(By.name(prop.getProperty("Lst_Register_role")))).selectByVisibleText(role);
		driver.findElement(By.name(prop.getProperty("Txt_Register_utaid"))).clear();
		driver.findElement(By.name(prop.getProperty("Txt_Register_utaid"))).sendKeys(utaid);
		driver.findElement(By.name(prop.getProperty("Txt_Register_phone"))).clear();
		driver.findElement(By.name(prop.getProperty("Txt_Register_phone"))).sendKeys(phone);
		driver.findElement(By.name(prop.getProperty("Txt_Register_streetaddress"))).clear();
		driver.findElement(By.name(prop.getProperty("Txt_Register_streetaddress"))).sendKeys(streetaddress);
		driver.findElement(By.name(prop.getProperty("Txt_Register_city"))).clear();
		driver.findElement(By.name(prop.getProperty("Txt_Register_city"))).sendKeys(city);
		driver.findElement(By.name(prop.getProperty("Txt_Register_state"))).clear();
		driver.findElement(By.name(prop.getProperty("Txt_Register_state"))).sendKeys(state);
		driver.findElement(By.name(prop.getProperty("Txt_Register_zipcode"))).clear();
		driver.findElement(By.name(prop.getProperty("Txt_Register_zipcode"))).sendKeys(zipcode);
		driver.findElement(By.name(prop.getProperty("Txt_Register_vehiclenumber"))).clear();
		driver.findElement(By.name(prop.getProperty("Txt_Register_vehiclenumber"))).sendKeys(vehiclenumber);
		new Select(driver.findElement(By.name(prop.getProperty("Lst_Register_permit")))).selectByVisibleText(permit);
		driver.findElement(By.xpath(prop.getProperty("Btn_Register_registerUser"))).click();
	}
	
	public void login (WebDriver driver, String UserName, String Password){
		driver.findElement(By.name(prop.getProperty("Txt_Login_username"))).clear();
	    driver.findElement(By.name(prop.getProperty("Txt_Login_username"))).sendKeys(UserName);
		driver.findElement(By.name(prop.getProperty("Txt_Login_password"))).clear();
	    driver.findElement(By.name(prop.getProperty("Txt_Login_password"))).sendKeys(Password);
	    driver.findElement(By.xpath(prop.getProperty("Btn_Login_login"))).click();
	}
	
	
	public void searchUser (WebDriver driver, String UserName)
	{
		 driver.findElement(By.xpath(prop.getProperty("Lnk_SearchUser"))).click();
		 driver.findElement(By.name(prop.getProperty("Btn_Search_User"))).sendKeys(UserName);
		 driver.findElement(By.xpath(prop.getProperty("Lnk_SearchSubmit"))).click();
		    
	}
	
	public void searchUserwithFirstName (WebDriver driver, String FirstName)
	{
		 driver.findElement(By.name(prop.getProperty("Btn_Search_User"))).sendKeys(FirstName);
		 driver.findElement(By.xpath(prop.getProperty("Lnk_SearchSubmit"))).click();   
	}
	
	public void viewReservation (WebDriver driver)
	{
		 driver.findElement(By.name(prop.getProperty("Radio_Btn_Select_User"))).click();
		 driver.findElement(By.xpath(prop.getProperty("Btn_View_Reservation"))).click();
		 driver.findElement(By.name(prop.getProperty("Radio_Btn_Select_Reservation"))).click();
		 driver.findElement(By.xpath(prop.getProperty("Btn_Mark_Violations"))).click();
		   
	}
	
	
	public void setViolations (WebDriver driver, String violation)
	{
		
		 new Select(driver.findElement(By.name(prop.getProperty("Select_Violation")))).selectByVisibleText(violation);
		 driver.findElement(By.xpath(prop.getProperty("Btn_Update_Reservation"))).click();	   
	}
	

	
	
	public void viewUser (WebDriver driver)
	{
		 driver.findElement(By.name(prop.getProperty("Radio_Btn_Select_User"))).click();
		  driver.findElement(By.xpath(prop.getProperty("Btn_Revoke_User"))).click();
		   
	}
	
	
	
	public void setUserStatus (WebDriver driver, String UserStatus,String adminComments )
	{
	    new Select(driver.findElement(By.name(prop.getProperty("Select_Status")))).selectByVisibleText(UserStatus);
	    driver.findElement(By.name(prop.getProperty("Enter_Comments"))).sendKeys(adminComments);
	    driver.findElement(By.xpath(prop.getProperty("Btn_Update_User"))).click();
	}
	
	public void searchParking(WebDriver driver, String starttime, String endtime) {
	    driver.findElement(By.id(prop.getProperty("Txt_Start_time"))).clear();
	    driver.findElement(By.id(prop.getProperty("Txt_Start_time"))).sendKeys(starttime);
	    driver.findElement(By.id(prop.getProperty("Txt_End_time"))).clear();
	    driver.findElement(By.id(prop.getProperty("Txt_End_time"))).sendKeys(endtime);
	    driver.findElement(By.xpath(prop.getProperty("Btn_SearchParking"))).click();
	    
	}
	
	public void selectParking(WebDriver driver) {

		 driver.findElement(By.xpath(prop.getProperty("Select_Parking_Area"))).click();
		 selectAllOptions(driver);
		 driver.findElement(By.cssSelector(prop.getProperty("Btn_Reserve"))).click();		
	}
	
	public void selectInvalidParking(WebDriver driver) {

		 driver.findElement(By.xpath(prop.getProperty("Select_Invalid_Parking_Area"))).click();
		 driver.findElement(By.xpath(prop.getProperty("Select_Parking_Options"))).click();
		 driver.findElement(By.cssSelector(prop.getProperty("Btn_Reserve"))).click();		
	}
	
	public void payForParking(WebDriver driver, String creditcard, String year, String cvv) {
		
		driver.findElement(By.name(prop.getProperty("Txt_Card"))).clear(); 
	    driver.findElement(By.name(prop.getProperty("Txt_Card"))).sendKeys(creditcard);
	    new Select(driver.findElement(By.name(prop.getProperty("Txt_Year")))).selectByVisibleText(year);
	    driver.findElement(By.name(prop.getProperty("Txt_Cvv"))).clear();
	    driver.findElement(By.name(prop.getProperty("Txt_Cvv"))).sendKeys(cvv);
	    driver.findElement(By.cssSelector(prop.getProperty("Btn_PayParking"))).click();
	}

	public void logout (WebDriver driver){
	    driver.findElement(By.linkText(prop.getProperty("Lnk_Logout"))).click();
	}
	
	public void searchSpot(WebDriver driver, String spotID){
	    driver.findElement(By.name(prop.getProperty("Txt_searchSpotID"))).clear();
	    driver.findElement(By.name(prop.getProperty("Txt_searchSpotID"))).sendKeys(spotID);
	    driver.findElement(By.cssSelector(prop.getProperty("Btn_submit_search"))).click();
	}
	
	public void toggleSpot(WebDriver driver){
		driver.findElement(By.cssSelector(prop.getProperty("Btn_submit_Deactivate_Spot"))).click();
	}
	
	public void selectAllOptions(WebDriver driver){
		driver.findElement(By.name(prop.getProperty("Rad_Select_History"))).click();
	    driver.findElement(By.xpath(prop.getProperty("Rad_Select_Cart"))).click();
	    driver.findElement(By.xpath(prop.getProperty("Rad_Select_Camera"))).click();
	}
	
	public void addParkingArea (WebDriver driver, String parkingArea,String Floor,String Capacity)
	{
		
		 driver.findElement(By.name(prop.getProperty("Txt_parking_area_name"))).clear();
	     driver.findElement(By.name(prop.getProperty("Txt_parking_area_name"))).sendKeys(parkingArea);
	     driver.findElement(By.name(prop.getProperty("Txt_floor"))).clear();
	     driver.findElement(By.name(prop.getProperty("Txt_floor"))).sendKeys(Floor);
	     driver.findElement(By.name(prop.getProperty("Txt_capacity"))).clear();
	     driver.findElement(By.name(prop.getProperty("Txt_capacity"))).sendKeys(Capacity);
	     driver.findElement(By.cssSelector(prop.getProperty("Btn_Add_Edit_ParkingArea"))).click();
   
	}

	public void editParkingArea (WebDriver driver, String parkingArea,String Floor,String Capacity,String Reserved,String Available)
	{
		 driver.findElement(By.name(prop.getProperty("Txt_parking_area_name"))).clear();
	     driver.findElement(By.name(prop.getProperty("Txt_parking_area_name"))).sendKeys(parkingArea);
	     driver.findElement(By.name(prop.getProperty("Txt_floor"))).clear();
	     driver.findElement(By.name(prop.getProperty("Txt_floor"))).sendKeys(Floor);
	     driver.findElement(By.name(prop.getProperty("Txt_capacity"))).clear();
	     driver.findElement(By.name(prop.getProperty("Txt_capacity"))).sendKeys(Capacity);
	     driver.findElement(By.name(prop.getProperty("Txt_reserved"))).clear();
	     driver.findElement(By.name(prop.getProperty("Txt_reserved"))).sendKeys(Reserved);
	     driver.findElement(By.name(prop.getProperty("Txt_available"))).clear();
	     driver.findElement(By.name(prop.getProperty("Txt_available"))).sendKeys(Available);
	     driver.findElement(By.cssSelector(prop.getProperty("Btn_Add_Edit_ParkingArea"))).click();
   
	}
	
	public void searchUserLastName (WebDriver driver, String lastName)
	{
		new Select(driver.findElement(By.name(prop.getProperty("Select_search_filter")))).selectByVisibleText("Last Name");
	    driver.findElement(By.name(prop.getProperty("Btn_Search_User"))).clear();
	    driver.findElement(By.name(prop.getProperty("Btn_Search_User"))).sendKeys(lastName);
	    driver.findElement(By.cssSelector(prop.getProperty("Btn_submit_search"))).click();
		    
	}
	
	public void searchUserUTAID (WebDriver driver, String UTAID)
	{
		new Select(driver.findElement(By.name(prop.getProperty("Select_search_filter")))).selectByVisibleText("UTA ID");
	    driver.findElement(By.name(prop.getProperty("Btn_Search_User"))).clear();
	    driver.findElement(By.name(prop.getProperty("Btn_Search_User"))).sendKeys(UTAID);
	    driver.findElement(By.cssSelector(prop.getProperty("Btn_submit_search"))).click();
		    
	}
	
	public void editUser (WebDriver driver, String firstName, String lastName, String email, String password, String utaid, String phone, String streetaddress, String city, String state, String zipcode, String vehiclenumber)
	{
		driver.findElement(By.name(prop.getProperty("Txt_Register_firstName"))).clear();
	    driver.findElement(By.name(prop.getProperty("Txt_Register_firstName"))).sendKeys(firstName);
	    driver.findElement(By.name(prop.getProperty("Txt_Register_lastName"))).clear();
	    driver.findElement(By.name(prop.getProperty("Txt_Register_lastName"))).sendKeys(lastName);
	    driver.findElement(By.name(prop.getProperty("Txt_Register_email"))).clear();
	    driver.findElement(By.name(prop.getProperty("Txt_Register_email"))).sendKeys(email);
	    driver.findElement(By.name(prop.getProperty("Txt_Register_password"))).clear();
	    driver.findElement(By.name(prop.getProperty("Txt_Register_password"))).sendKeys(password);
	    driver.findElement(By.name(prop.getProperty("Txt_Register_utaid"))).clear();
	    driver.findElement(By.name(prop.getProperty("Txt_Register_utaid"))).sendKeys(utaid);
	    driver.findElement(By.name(prop.getProperty("Txt_Register_phone"))).clear();
	    driver.findElement(By.name(prop.getProperty("Txt_Register_phone"))).sendKeys(phone);
	    driver.findElement(By.name(prop.getProperty("Txt_Register_streetaddress"))).clear();
	    driver.findElement(By.name(prop.getProperty("Txt_Register_streetaddress"))).sendKeys(streetaddress);
	    driver.findElement(By.name(prop.getProperty("Txt_Register_city"))).clear();
	    driver.findElement(By.name(prop.getProperty("Txt_Register_city"))).sendKeys(city);
	    driver.findElement(By.name(prop.getProperty("Txt_Register_state"))).clear();
	    driver.findElement(By.name(prop.getProperty("Txt_Register_state"))).sendKeys(state);
	    driver.findElement(By.name(prop.getProperty("Txt_Register_zipcode"))).clear();
	    driver.findElement(By.name(prop.getProperty("Txt_Register_zipcode"))).sendKeys(zipcode);
	    driver.findElement(By.name(prop.getProperty("Txt_Register_vehiclenumber"))).clear();
	    driver.findElement(By.name(prop.getProperty("Txt_Register_vehiclenumber"))).sendKeys(vehiclenumber);
	    driver.findElement(By.xpath(prop.getProperty("Btn_Update_Details"))).click();
	    
	}
	
	public void viewStatus (WebDriver driver)
	{
		driver.findElement(By.linkText(prop.getProperty("Lnk_View_Status"))).click();
	}
	
	public void viewReservationToDelete (WebDriver driver){
		driver.findElement(By.name(prop.getProperty("Select_user_toDelete"))).click();
		driver.findElement(By.xpath(prop.getProperty("ViewReserrvation_toDelete"))).click();
	}
	
	public void deleteReservation (WebDriver driver)
	{	    	    
	    driver.findElement(By.name(prop.getProperty("Select_Reservation_fromList_toDelete"))).click();
	    driver.findElement(By.xpath(prop.getProperty("Delete_selected_Reservation"))).click();
	}
	
	public void updateReservation(WebDriver driver , String updatedValue) {
		
	    driver.findElement(By.name(prop.getProperty("Txt_Register_vehiclenumber"))).clear();
	    driver.findElement(By.name(prop.getProperty("Txt_Register_vehiclenumber"))).sendKeys(updatedValue);
	    driver.findElement(By.xpath(prop.getProperty("Btn_Update_Reservation"))).click();
	}
	
}
