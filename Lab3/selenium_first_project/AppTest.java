package se.iths.selenium_first_project;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait; 

public class AppTest  {
	WebDriver driver;
 
	@Before
	public void init(){
    	System.setProperty("webdriver.gecko.driver", "/Users/jonaslindberg/Tools/Geckodriver/geckodriver");
        driver = new FirefoxDriver();
        driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop");

        }

	@Test
	public void bookTest(){
		 WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Book");
        element.click();
        
    
     
       /* (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("Book");
            }
        });*/
        //System.out.println(driver.getTitle());
     // assertEquals("Book - Sök på Google", driver.getTitle());
       // driver.quit();
    } 
}
