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
public class SeleniumTC03 extends Parking_SystemFunctions {
	private StringBuffer verificationErrors = new StringBuffer();
	public static String sAppURL, sSharedUIMapPath, test_delay, userUsername, userPassword, managerUsername, managerPassword, adminUsername, adminPassword;
	
	@Before
	public void setUp() throws Exception {
		//Magic Code HERE
		System.setProperty("webdriver.firefox.marionette", "C:\\GeckoSelenium\\");
	    driver = new FirefoxDriver();
	    
	    //Load Login Credentials File
	    prop = new Properties();
	    prop.load(new FileInputStream("./Login/Login.properties"));
	    userUsername = prop.getProperty("user_username");
	    userPassword = prop.getProperty("user_password");
		managerUsername = prop.getProperty("manager_username");
		managerPassword = prop.getProperty("manager_password");
		adminUsername = prop.getProperty("admin_username");
		adminPassword = prop.getProperty("admin_password");
		//Load Configuration File
	    prop.load(new FileInputStream("./Configuration/HA_Configuration.properties"));
	    sAppURL = prop.getProperty("sAppURL");
	    sSharedUIMapPath = prop.getProperty("SharedUIMap");
	    test_delay = prop.getProperty("test_delay");
	    
	    //Load SharedUI Map
	    prop.load(new FileInputStream(sSharedUIMapPath));
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	@Test
	@FileParameters("test/Excel/TC03.csv")
	public void testSeleniumTC1(int testCaseNo, String errorStartTime, String errorEndTime, String startTime, String endTime, String cardNumber, String year, String cvv) throws Exception {
		driver.get(sAppURL);
	    //select Login from Index page
	    driver.findElement(By.xpath(prop.getProperty("Lnk_Login"))).click();
	 
	    // Login with Valid USER credentials
	    login(driver, userUsername,  userPassword);
	     
	    if (test_delay.equals("delay"))
	    	Thread.sleep(2_000);
	    
	    driver.findElement(By.xpath(prop.getProperty("Btn_Reservation_requestReserv"))).click();
	    
	    // searching for a parking with Invalid Time Entry
	    searchParking(driver, errorStartTime, errorEndTime);
	    assertTrue(driver.findElement(By.name(prop.getProperty("Lbl_SearchParking_ErrorMsg"))).getAttribute("value").equals("Please correct the following errors"));
	    assertTrue(driver.findElement(By.name(prop.getProperty("Lbl_SearchParking_TimeErrorMsg"))).getAttribute("value").equals("End time should be greater than start time"));

	    // Followed by searching for a parking with valid Time Entries
	    searchParking(driver, startTime, endTime);
	   
	    if (test_delay.equals("delay"))
	    	Thread.sleep(2_000);
	    
	    selectInvalidParking(driver);
	    assertTrue(driver.findElement(By.xpath(prop.getProperty("Lbl_SelectParking_ErrorMsg"))).getAttribute("value").equals("Please correct the following errors"));
	    assertTrue(driver.findElement(By.xpath(prop.getProperty("Lbl_SelectParking_PermitErrorMsg"))).getAttribute("value").equals("BASIC User can only book an BASIC Parking type"));
	    
	    selectParking(driver);
	    
	    if (test_delay.equals("delay"))
	    	Thread.sleep(2_000);
	    //Submit and Empty Payment Page
	    payForParking(driver, "", "2016", "");
	    assertTrue(driver.findElement(By.name(prop.getProperty("Lbl_Payment_ErrorMsg"))).getAttribute("value").equals("Please correct the following errors"));
	    assertTrue(driver.findElement(By.xpath(prop.getProperty("Lbl_Payment_CardError"))).getAttribute("value").equals("Please provide your Card number"));
	    assertTrue(driver.findElement(By.xpath(prop.getProperty("Lbl_Payment_CVVMsg"))).getAttribute("value").equals("Please provide your CVV number"));
	    
	    //Followed by a valid submission
	    payForParking(driver, cardNumber, year, cvv);
	    if (test_delay.equals("delay"))
	    	Thread.sleep(2_000);
	    driver.findElement(By.linkText("Parking System")).click(); 
	    if (test_delay.equals("delay"))
	    	Thread.sleep(2_000);
	    //USER Logout
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