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
public class SeleniumTC02 extends Parking_SystemFunctions {
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
	@FileParameters("test/Excel/TC02.csv")
	public void testSeleniumTC1(int testCaseNo, String invalidUsername, String invalidPass, String username,String pass) throws Exception {
	    driver.get(sAppURL);
	    //select Login from Index page
	    driver.findElement(By.xpath(prop.getProperty("Lnk_Login"))).click();
	    // Login an Empty Form
	    login(driver, "",  "");
	    // verify error messages
	    assertTrue(driver.findElement(By.name(prop.getProperty("Lbl_Login_userNameError"))).getAttribute("value").equals("Please enter username"));
	    assertTrue(driver.findElement(By.name(prop.getProperty("Lbl_Login_userPasswordError"))).getAttribute("value").equals("Please enter password"));
	    // Followed By Login with invalid USER credentials
	    login(driver, invalidUsername, invalidPass);
	    // verify error messages
	    assertTrue(driver.findElement(By.id(prop.getProperty("Lbl_Login_greetingField"))).getAttribute("value").equals("User Not Found!"));
	    // Followed By Login with Valid USER credentials
	    login(driver, username,  pass);
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