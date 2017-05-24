package se.iths.selenium_first_project;

import static org.junit.Assert.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestHub {
	WebDriver driver;
	
	
	@Before
	public void setup() throws MalformedURLException{
		DesiredCapabilities capability = DesiredCapabilities.firefox();
		capability.setBrowserName("firefox");
		driver = new RemoteWebDriver( new URL("http://dockerselenium.azurewebsites.net/wd/hub"), capability);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://www.google.com");
	}
	@Test
	public void testGoToDefaultStore() throws InterruptedException {
	
		driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/product/the-big-switch.html");
		
		
		WebElement storeLink = driver.findElement(By.linkText("Default store"));

		
		storeLink.click();
		
		
		Thread.sleep(2000);
		
		
		assertEquals("Shopizer Demo - Default store", driver.getTitle());
		System.out.println(driver.getTitle());
		
		driver.close();
		}
		@Test
		public void testGoToBusiness() throws InterruptedException {
		driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/product/the-big-switch.html");
		WebElement businessLink = driver.findElement(By.linkText("Business"));
		businessLink.click();
		
		Thread.sleep(2000);
		
		WebElement business2Link = driver.findElement(By.className("lead"));
		business2Link.getText();
		assertEquals("Business", business2Link.getText());
		System.out.println(business2Link.getText());
		
		driver.close();
		}
		/*@Test
		public void testSortBy() throws InterruptedException {
			driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/category/business.html/ref=c:6");
			WebElement def = driver.findElement(By.xpath("//*[@value='item-name']"));
			
			Thread.sleep(2000);
			def.click();
			
			assertEquals("Name", def.getText());
			
			driver.close();
		}
		@Test
		public void testAddToCart() throws InterruptedException {
			driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/");
			WebElement add = driver.findElement(By.xpath( ".//*[@id='pageContainer']/div[2]/div[3]/div[2]/div/div[3]/div/div[1]/a/img"));
			add.click();
			
			Thread.sleep(2000);
			
			WebElement button = driver.findElement(By.xpath( ".//*[@id='input-2']/div/button"));
			button.click();
			System.out.println("Book Node Web Development has been added to shopping cart");
			
			Thread.sleep(2000);
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(0, -250);");
			
			Thread.sleep(2000);
			
			WebElement cart = driver.findElement(By.xpath(".//*[@id='open-cart']"));
			cart.click();
			
			WebElement book = driver.findElement(By.xpath(".//*[@id='2']/td[2]"));
			book.getText();
			assertEquals("1 Node Web Development", book.getText());
			
			driver.close();
		}
		@Test
		public void testCheckout() throws InterruptedException {
			driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/");
			WebElement add = driver.findElement(By.xpath( ".//*[@id='pageContainer']/div[2]/div[3]/div[2]/div/div[3]/div/div[1]/a/img"));
			add.click();
			
			Thread.sleep(2000);
			
			WebElement button = driver.findElement(By.xpath( ".//*[@id='input-2']/div/button"));
			button.click();
			System.out.println("Book Node Web Development has been added to shopping cart");
			
			Thread.sleep(2000);
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(0, -250);");
			
			Thread.sleep(2000);
			
			WebElement cart = driver.findElement(By.xpath(".//*[@id='open-cart']"));
			cart.click();
			
			WebElement co = driver.findElement(By.xpath(".//*[@id='miniCartDetails']/li/div/a"));
			co.click();
			
			Thread.sleep(2000);
			
			//WebDriverWait wait = new WebDriverWait(driver, 10);
			//wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='miniCartDetails']/li/div/a")));
			
			WebElement rev = driver.findElement(By.xpath(".//*[@id='main-content']/div/h1"));
			rev.getText();
			assertEquals("Review your order", rev.getText());
			
			driver.close();
		}*/
		
	}
	

