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
import org.openqa.selenium.support.ui.Select;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import parking_system.functions.Parking_SystemFunctions;

@RunWith(JUnitParamsRunner.class)
public class SeleniumTC08 extends Parking_SystemFunctions {
	private StringBuffer verificationErrors = new StringBuffer();
	public static String sAppURL, sSharedUIMapPath, test_delay,adminUsername, adminPassword;;
	
	@Before
	public void setUp() throws Exception {
		//Magic Code HERE
		System.setProperty("webdriver.firefox.marionette", "C:\\GeckoSelenium\\");
	    driver = new FirefoxDriver();
	    
	    //Load Configuration File
	    prop = new Properties();
	    prop.load(new FileInputStream("./Login/Login.properties"));
	    adminUsername = prop.getProperty("admin_username");
		adminPassword = prop.getProperty("admin_password");
	    
	    
	    prop.load(new FileInputStream("./Configuration/HA_Configuration.properties"));
	    sAppURL = prop.getProperty("sAppURL");
	    sSharedUIMapPath = prop.getProperty("SharedUIMap");
	    test_delay = prop.getProperty("test_delay");
	    
	    //Load SharedUI Map
	    prop.load(new FileInputStream(sSharedUIMapPath));
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	@Test
	@FileParameters("test/Excel/TC08.csv")	
	public void testSeleniumTC1(String UserName,String UserStatus,String adminComments) throws Exception {
	    driver.get(sAppURL);
	    //select Login from Index page
	    driver.findElement(By.xpath(prop.getProperty("Lnk_Login"))).click();

	    // Login with Valid Manager credentials
	    login(driver, adminUsername,  adminPassword);
	    if (test_delay.equals("delay"))
	    	Thread.sleep(2_000);
	    
	    
	    searchUser(driver, UserName);
	    if (test_delay.equals("delay"))
	    	Thread.sleep(2_000);
	    
	    viewUser(driver);
	    if (test_delay.equals("delay"))
	    	Thread.sleep(2_000);
	    
	    setUserStatus(driver,UserStatus,adminComments);
	    if (test_delay.equals("delay"))
	    	Thread.sleep(2_000);
	    
	
	    //Admin Logout
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