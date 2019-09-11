package parking_system.selenium;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import parking_system.functions.Parking_SystemFunctions;

@RunWith(JUnitParamsRunner.class)
public class SeleniumTC01 extends Parking_SystemFunctions {
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
	@FileParameters("test/Excel/TC01.csv")
	public void testSeleniumTC1(int testCaseNo, String username, String firstName, String lastName, String email, String password, String role, String utaid, String phone, String streetaddress, String city, String state, String zipcode, String vehiclenumber, String permit) throws Exception {
	    driver.get(sAppURL);
	    //select Register from Index page
	    driver.findElement(By.xpath(prop.getProperty("Lnk_Register"))).click();
	    //driver.findElement(By.xpath(prop.getProperty("Btn_Register_registerUser"))).click();
	    // Register an Empty Form for USER role
	    register(driver, "",  "",  "",  "",  "",  role,  "",  "",  "",  "",  "",  "",  "",  "BASIC");
	    // verify error messages
	    assertTrue(driver.findElement(By.name(prop.getProperty("Lbl_Register_ErrorMessage"))).getAttribute("value").equals("Please correct the following errors"));
	    assertTrue(driver.findElement(By.name(prop.getProperty("Lbl_Register_userNameError"))).getAttribute("value").equals("Please provide username"));
	    assertTrue(driver.findElement(By.name(prop.getProperty("Lbl_Register_userFirstNameError"))).getAttribute("value").equals("Please provide First name"));
	    assertTrue(driver.findElement(By.name(prop.getProperty("Lbl_Register_userLastNameError"))).getAttribute("value").equals("Please provide Last name"));
	    assertTrue(driver.findElement(By.name(prop.getProperty("Lbl_Register_userEmailError"))).getAttribute("value").equals("Please provide Email"));
	    assertTrue(driver.findElement(By.name(prop.getProperty("Lbl_Register_userPasswordError"))).getAttribute("value").equals("Please provide password"));
	    assertTrue(driver.findElement(By.name(prop.getProperty("Lbl_Register_utaIDerror"))).getAttribute("value").equals("UTA ID must be 10 digits in length"));
	    assertTrue(driver.findElement(By.name(prop.getProperty("Lbl_Register_phoneError"))).getAttribute("value").equals("Phone number must be 10 digits in length"));
	    assertTrue(driver.findElement(By.name(prop.getProperty("Lbl_Register_streetAddError"))).getAttribute("value").equals("Please provide street address"));
	    assertTrue(driver.findElement(By.name(prop.getProperty("Lbl_Register_cityError"))).getAttribute("value").equals("Please provide city name"));
	    assertTrue(driver.findElement(By.name(prop.getProperty("Lbl_Register_stateError"))).getAttribute("value").equals("Please provide state name"));
	    assertTrue(driver.findElement(By.name(prop.getProperty("Lbl_Register_zipCodeError"))).getAttribute("value").equals("Please provide Zip code."));
	    //Followed by Register for USER role with all valid Entries
	    register(driver, username, firstName, lastName, email, password,  role,  utaid,  phone,  streetaddress,  city,  state,  zipcode,  vehiclenumber,  permit);
	    // Verify Links on Index Page
	    assertTrue(isElementPresent(By.xpath(prop.getProperty("Lnk_Index"))));
	    assertTrue(driver.findElement(By.xpath(prop.getProperty("Lnk_Index"))).getText().equals("Arlington Parking, Inc."));
	    assertTrue(driver.findElement(By.xpath(prop.getProperty("Lnk_Register"))).getText().equals("Register"));
	    assertTrue(driver.findElement(By.xpath(prop.getProperty("Lnk_Login"))).getText().equals("Login"));
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
	private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }
}