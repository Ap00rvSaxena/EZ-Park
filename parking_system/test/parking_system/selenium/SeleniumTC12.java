package parking_system.selenium;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import parking_system.functions.Parking_SystemFunctions;

//update user-profile by manager, admin

@RunWith(JUnitParamsRunner.class)
public class SeleniumTC12 extends Parking_SystemFunctions {
	private StringBuffer verificationErrors = new StringBuffer();
	public static String sAppURL, sSharedUIMapPath, test_delay;
	
	@Before
	public void setUp() throws Exception {
		//Magic Code HERE
		System.setProperty("webdriver.firefox.marionette", "C:\\GeckoSelenium\\");
	    driver = new FirefoxDriver();
	    
	    //Load Configuration File
	    prop = new Properties(); 
	    prop.load(new FileInputStream("./Configuration/HA_Configuration.properties"));
	    sAppURL = prop.getProperty("sAppURL");
	    sSharedUIMapPath = prop.getProperty("SharedUIMap");
	    test_delay = prop.getProperty("test_delay");
	    
	    //Load SharedUI Map 
	    prop.load(new FileInputStream(sSharedUIMapPath));
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	
	@Test
	@FileParameters("test/Excel/TC12.csv")
	public void testSeleniumTC0012(int testCaseNo, String userName, String pass, String userSearchName, String firstName, String lastName, String email, String password, String utaid, String phone, String streetaddress, String city, String state, String zipcode, String vehiclenumber) throws Exception {
	    driver.get(sAppURL);
	    
	    driver.findElement(By.xpath(prop.getProperty("Lnk_Login"))).click();

	    if (test_delay.equals("delay"))
	    	Thread.sleep(2_000);
	    
	    //select Login from Index page
	    login(driver, userName,  pass);
	    
	    if (test_delay.equals("delay"))
	    	Thread.sleep(2_000);
	    
	    // search a user by first name
	    searchUser(driver, userSearchName);
	    
	    if (test_delay.equals("delay"))
	    	Thread.sleep(2_000);
	    
	    // select the first search result
	    driver.findElement(By.name(prop.getProperty("Radio_Btn_Select_User"))).click();
	    driver.findElement(By.xpath(prop.getProperty("Btn_Revoke_User"))).click();
	    
	    if (test_delay.equals("delay"))
	    	Thread.sleep(2_000);
	    
//Make all the fields blank to check the validations
	    
	    driver.findElement(By.name("firstName")).clear();
	    driver.findElement(By.name("firstName")).sendKeys("");
	    driver.findElement(By.name("lastName")).clear();
	    driver.findElement(By.name("lastName")).sendKeys("");
	    driver.findElement(By.name("email")).clear();
	    driver.findElement(By.name("email")).sendKeys("");
	    driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).sendKeys("");
	    driver.findElement(By.name("utaid")).clear();
	    driver.findElement(By.name("utaid")).sendKeys("");
	    driver.findElement(By.name("phone")).clear();
	    driver.findElement(By.name("phone")).sendKeys("");
	    driver.findElement(By.name("streetaddress")).clear();
	    driver.findElement(By.name("streetaddress")).sendKeys("");
	    driver.findElement(By.name("city")).clear();
	    driver.findElement(By.name("city")).sendKeys("");
	    driver.findElement(By.name("state")).clear();
	    driver.findElement(By.name("state")).sendKeys("");
	    driver.findElement(By.name("zipcode")).clear();
	    driver.findElement(By.name("zipcode")).sendKeys("");
	    driver.findElement(By.name("vehiclenumber")).clear();
	    driver.findElement(By.name("vehiclenumber")).sendKeys("");
	    driver.findElement(By.xpath(prop.getProperty("Btn_Update_Details"))).click();
	    
	    
	    if (test_delay.equals("delay"))
	    	Thread.sleep(2_000);
	    
	    // Check all the error messages
	     assertTrue(driver.findElement(By.name(prop.getProperty("Lbl_Register_ErrorMessage"))).getAttribute("value").equals("Please correct the following errors"));
	     assertTrue(driver.findElement(By.name(prop.getProperty("Lbl_Register_userFirstNameError"))).getAttribute("value").equals("Please provide First name"));
	     assertTrue(driver.findElement(By.name(prop.getProperty("Lbl_Register_userLastNameError"))).getAttribute("value").equals("Please provide Last name"));
	     assertTrue(driver.findElement(By.name(prop.getProperty("Lbl_Register_userEmailError"))).getAttribute("value").equals("Please provide Email"));
	     assertTrue(driver.findElement(By.name(prop.getProperty("Lbl_Register_userPasswordError"))).getAttribute("value").equals("Please enter password"));
	     assertTrue(driver.findElement(By.name(prop.getProperty("Lbl_Register_utaIDerror"))).getAttribute("value").equals("UTA ID must be 10 digits in length"));
	     assertTrue(driver.findElement(By.name(prop.getProperty("Lbl_Register_phoneError"))).getAttribute("value").equals("Phone number must be 10 digits in length"));
	     assertTrue(driver.findElement(By.name(prop.getProperty("Lbl_Register_streetAddError"))).getAttribute("value").equals("Please provide street address"));
	     assertTrue(driver.findElement(By.name(prop.getProperty("Lbl_Register_cityError"))).getAttribute("value").equals("Please provide city name"));
	     assertTrue(driver.findElement(By.name(prop.getProperty("Lbl_Register_stateError"))).getAttribute("value").equals("Please provide state name"));
	     assertTrue(driver.findElement(By.name(prop.getProperty("Lbl_Register_zipCodeError"))).getAttribute("value").equals("Please provide Zip code."));
	     assertTrue(driver.findElement(By.name(prop.getProperty("Lbl_Register_vehicleNumberError"))).getAttribute("value").equals("Please provide your vehicle number"));
	     
	     if (test_delay.equals("delay"))
		    	Thread.sleep(2_000);
	     
	    // call to edit user function
	    editUser(driver, firstName, lastName, email, password, utaid, phone, streetaddress, city, state, zipcode, vehiclenumber);
	 
	    if (test_delay.equals("delay"))
	    	Thread.sleep(2_000);
	   
	    logout(driver);
	    
	    if (test_delay.equals("delay"))
	    	Thread.sleep(2_000);
	    //return to HomePage
	    driver.findElement(By.xpath(prop.getProperty("Lnk_Login_Homepage"))).click();
	    if (test_delay.equals("delay"))
	    	Thread.sleep(2_000);
	     
	}
	
	@After
	public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	    }
}