package parking_system.selenium;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import junitparams.FileParameters;
import parking_system.functions.Parking_SystemFunctions;

@RunWith(JUnitParamsRunner.class)
public class SeleniumTC05 extends Parking_SystemFunctions {
	private StringBuffer verificationErrors = new StringBuffer();
	public static String sAppURL, sSharedUIMapPath, test_delay,managerUsername,managerPassword;
	
	@Before
	public void setUp() throws Exception {
		//Magic Code HERE
		System.setProperty("webdriver.firefox.marionette", "C:\\GeckoSelenium\\");
	    driver = new FirefoxDriver();
	    
	    //Load Configuration File
	    
	    prop = new Properties();
	    
	    prop.load(new FileInputStream("./Login/Login.properties"));
	    managerUsername = prop.getProperty("manager_username");
		managerPassword = prop.getProperty("manager_password");
	    
	    prop.load(new FileInputStream("./Configuration/HA_Configuration.properties"));
	    sAppURL = prop.getProperty("sAppURL");
	    sSharedUIMapPath = prop.getProperty("SharedUIMap");
	    test_delay = prop.getProperty("test_delay");
	    
	    //Load SharedUI Map
	    prop.load(new FileInputStream(sSharedUIMapPath));
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	@Test
	@FileParameters("test/Excel/TC05.csv")	
	public void testAddParking(String parkingArea,String Floor,String Capacity) throws Exception {
	    driver.get(sAppURL);{
	
	
	    //select Login from Index page
	    driver.findElement(By.xpath(prop.getProperty("Lnk_Login"))).click();

	    // Login with Valid Manager credentials
	    login(driver, managerUsername,  managerPassword);
	  
	    if (test_delay.equals("delay"))
	    	Thread.sleep(2_000);
	   
	    //All fields blank and click on submit button
	    driver.findElement(By.xpath(prop.getProperty("Lnk_AddParkingArea"))).click();
	    
	    driver.findElement(By.cssSelector(prop.getProperty("Btn_Add_Edit_ParkingArea"))).click();
	   
	    if (test_delay.equals("delay"))
	    	Thread.sleep(2_000);
	    
	    // verify error messages
	    assertTrue(driver.findElement(By.name(prop.getProperty("Lbl_ParkinArea_ErrorMessage"))).getAttribute("value").equals("Please correct the following errors"));
	    assertTrue(driver.findElement(By.name(prop.getProperty("Lbl_Register_userFirstNameError"))).getAttribute("value").equals("Please provide ParkingArea Name"));
	    assertTrue(driver.findElement(By.xpath(prop.getProperty("Lbl_Floor_Error"))).getAttribute("value").equals("Please provide Floor"));
	    assertTrue(driver.findElement(By.xpath(prop.getProperty("Lbl_Capacity_Error"))).getAttribute("value").equals("Please provide Capacity"));
	   
	    if (test_delay.equals("delay"))
	    	Thread.sleep(2_000);
	    
	    // Add Parking Area
	    addParkingArea(driver,parkingArea,Floor,Capacity);
	  
	    if (test_delay.equals("delay"))
	    	Thread.sleep(2_000);
	    
	    
	    //Manager Logout
	    logout(driver);
	    if (test_delay.equals("delay"))
	    	Thread.sleep(2_000);
	    //return to HomePage
	    driver.findElement(By.xpath(prop.getProperty("Lnk_Login_Homepage"))).click();
	    if (test_delay.equals("delay"))
	    	Thread.sleep(2_000);
	    }
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