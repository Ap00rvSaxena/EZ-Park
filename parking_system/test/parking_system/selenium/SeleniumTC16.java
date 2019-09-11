package parking_system.selenium;

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

//manager delete reservation of user4
// not working

@RunWith(JUnitParamsRunner.class)
public class SeleniumTC16 extends Parking_SystemFunctions {
	private StringBuffer verificationErrors = new StringBuffer();
	public static String sAppURL, sSharedUIMapPath, test_delay, userUsername, userPassword, managerUsername, managerPassword, adminUsername, adminPassword, user4Username, user4Password;
	
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
		user4Username = prop.getProperty("user4_username");
		user4Password = prop.getProperty("user4_password");
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
	@FileParameters("test/Excel/TC16.csv")
	public void testSeleniumTC0015(int testCaseNo, String userReservationDelete) throws Exception {
	    driver.get(sAppURL);
	    
	    driver.findElement(By.xpath(prop.getProperty("Lnk_Login"))).click();

	    if (test_delay.equals("delay"))
	    	Thread.sleep(2_000);
	    
	    //select Login from Index page
	    login(driver, managerUsername,  managerPassword);
	    if (test_delay.equals("delay"))
	    	Thread.sleep(2_000);
	    
	    driver.findElement(By.cssSelector("span")).click();
	    if (test_delay.equals("delay"))
	    	Thread.sleep(2_000);
	    
	    searchUserwithFirstName(driver, userReservationDelete);
	    if (test_delay.equals("delay"))
	    	Thread.sleep(2_000);
	    
	    viewReservationToDelete(driver);
	    if (test_delay.equals("delay"))
	    	Thread.sleep(2_000);
	    
	    deleteReservation(driver);
	    if (test_delay.equals("delay"))
	    	Thread.sleep(2_000);
	    
	    //goes to Manager Homepage
	    driver.findElement(By.linkText(prop.getProperty("Lnk_mangerHome_onDeleteReser"))).click();
	    if (test_delay.equals("delay"))
	    	Thread.sleep(2_000);
	    
	    logout(driver);
	    if (test_delay.equals("delay"))
	    	Thread.sleep(2_000);
	    
	    //return to IndexPage
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