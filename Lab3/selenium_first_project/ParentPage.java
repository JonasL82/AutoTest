package se.iths.selenium_first_project;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ParentPage {

protected static WebDriver driver;
	
	
	@Before
	public static void setup(){
	System.setProperty("webdriver.gecko.driver", "/Users/jonaslindberg/Tools/Geckodriver/geckodriver");
	driver = new FirefoxDriver();
	System.out.println("In setup............");
	}
}