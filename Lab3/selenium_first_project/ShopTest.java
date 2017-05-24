package se.iths.selenium_first_project;

import static org.junit.Assert.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ShopTest {
	WebDriver driver;
	
	
	@Before
	public void setup(){
	System.setProperty("webdriver.gecko.driver", "/Users/jonaslindberg/Tools/Geckodriver/geckodriver"); //geckodriver för att kunna hitta sidan. Sedan vart man lagt geckodriver.
	driver = new FirefoxDriver(); //För vilken webläsare man vill använda.
	}
	@Test
	public void testGoToDefaultStore() throws InterruptedException { // Testar så att Defaultstore finns med på förstasidan.

		driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/product/the-big-switch.html"); //Säger till driver vilken sida du vill öppna.
		
		WebElement storeLink = driver.findElement(By.linkText("Default store")); //Sök på element för funktionen du vill testa.
		
		storeLink.click(); //klickar på länken.
		
		Thread.sleep(2000); //Sätter den i sleep så att den ska hinna med
		
		assertEquals("Shopizer Demo - Default store", driver.getTitle()); //Gör testet
		System.out.println(driver.getTitle());
		
		driver.close();
		}
		@Test
		public void testGoToBusiness() throws InterruptedException { //Testar att gå till Business
		driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/product/the-big-switch.html");
		WebElement businessLink = driver.findElement(By.linkText("Business"));
		businessLink.click();
		
		WebDriverWait w = new WebDriverWait(driver, 10);
		w.until(ExpectedConditions.elementToBeClickable(By.className("lead")));
		
		WebElement business2Link = driver.findElement(By.className("lead"));
		business2Link.getText();
		assertEquals("Business", business2Link.getText());
		System.out.println(business2Link.getText());
		
		driver.close();
		}
		@Test
		public void testGoToContactUs() { // Testar att gå till ContactUs
		driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/");
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 250);");
		
		WebDriverWait w = new WebDriverWait(driver, 10);
		w.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='footer-section']/div[2]/div/div[3]/div/ul/li[4]/a")));
		
		WebElement contactLink = driver.findElement(By.xpath(".//*[@id='footer-section']/div[2]/div/div[3]/div/ul/li[4]/a"));
		contactLink.click();
		
		System.out.println("Geocode was not successful for the following reason: ZERO_RESULTS");
		//Result = "Geocode was not successful for the following reason: ZERO_RESULTS"
		
		driver.close();
		}
		@Test
		public void testSignIn() throws InterruptedException { // Testar att logga in som en användare som inte finns
			driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/");
			WebElement sign = driver.findElement(By.xpath(".//*[@id='customerAccount']/button"));
			sign.click();
			
			WebElement usern = driver.findElement(By.id("signin_userName"));
			usern.sendKeys("Jonas");
			
			WebElement passw = driver.findElement(By.id("signin_password"));
			passw.sendKeys("12345");
			
			WebElement login = driver.findElement(By.xpath(".//*[@id='login-button']"));
			login.click();
			
			Thread.sleep(2000);
			
			WebElement error = driver.findElement(By.xpath(".//*[@id='loginError']"));
			assertEquals("Login Failed. Username or Password is incorrect.", error.getText());
			System.out.println(error.getText());
			
			driver.close();
		}
		@Test
		public void testSortBy() throws InterruptedException { //Testar sort by funktionen under business och ser att Name finns där
			driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/category/business.html/ref=c:6");
			WebElement def = driver.findElement(By.xpath("//*[@value='item-name']"));
			def.click();
			
			assertEquals("Name", def.getText());
			
			driver.close();
		}
		@Test
		public void testAddToCart() throws InterruptedException { //Testar att lägga till bok
			driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/");
			WebElement add = driver.findElement(By.xpath( ".//*[@id='pageContainer']/div[2]/div[3]/div[2]/div/div[3]/div/div[1]/a/img"));
			add.click();
			
			WebDriverWait w = new WebDriverWait(driver, 10);
			w.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='input-2']/div/button")));
			
			WebElement button = driver.findElement(By.xpath( ".//*[@id='input-2']/div/button"));
			button.click();
			System.out.println("Book Node Web Development has been added to shopping cart");
			
			
			//Scroll up
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(0, -250);");
			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='open-cart']")));
			
			WebElement cart = driver.findElement(By.xpath(".//*[@id='open-cart']"));
			cart.click();
			
			WebElement book = driver.findElement(By.xpath(".//*[@id='2']/td[2]"));
			book.getText();
			assertEquals("1 Node Web Development", book.getText());
			
			driver.close();
		}
		@Test
		public void testCheckout() throws InterruptedException { //Testar checkout funktionen
			driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/");
			WebElement add = driver.findElement(By.xpath( ".//*[@id='pageContainer']/div[2]/div[3]/div[2]/div/div[3]/div/div[1]/a/img"));
			add.click();
			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath( ".//*[@id='input-2']/div/button")));
			
			WebElement button = driver.findElement(By.xpath( ".//*[@id='input-2']/div/button"));
			button.click();
			System.out.println("Book Node Web Development has been added to shopping cart");
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(0, -250);");
			
			WebDriverWait wai = new WebDriverWait(driver, 10);
			wai.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='open-cart']")));
			
			WebElement cart = driver.findElement(By.xpath(".//*[@id='open-cart']"));
			cart.click();
			
			WebElement co = driver.findElement(By.xpath(".//*[@id='miniCartDetails']/li/div/a"));
			co.click();
			
			WebDriverWait wa = new WebDriverWait(driver, 10);
			wa.until(ExpectedConditions.elementToBeClickable(By.className("cart-title")));
			
			WebElement rev = driver.findElement(By.className("cart-title"));
			rev.getText();
			assertEquals("Review your order", rev.getText());
			
			driver.close();
		}
		@Test
		public void testRemove() throws InterruptedException { //Testar remove funktionen
			driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/");
			WebElement add = driver.findElement(By.xpath( ".//*[@id='pageContainer']/div[2]/div[3]/div[2]/div/div[3]/div/div[1]/a/img"));
			add.click();
			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath( ".//*[@id='input-2']/div/button")));
			
			WebElement button = driver.findElement(By.xpath( ".//*[@id='input-2']/div/button"));
			button.click();
			System.out.println("Book Node Web Development has been added to shopping cart");
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(0, -250);");
			
			WebDriverWait wai = new WebDriverWait(driver, 10);
			wai.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='open-cart']")));
			
			WebElement cart = driver.findElement(By.xpath(".//*[@id='open-cart']"));
			cart.click();
		
			WebElement co = driver.findElement(By.xpath(".//*[@id='miniCartDetails']/li/div/a"));
			co.click();
			
			WebDriverWait w = new WebDriverWait(driver, 10);
			w.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='mainCartTable']/tbody/tr[1]/td[5]/button")));
			
			WebElement r = driver.findElement(By.xpath(".//*[@id='mainCartTable']/tbody/tr[1]/td[5]/button"));
			r.click();
			
			WebDriverWait er = new WebDriverWait(driver, 10);
			er.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='pageContainer']/table/tbody/tr[1]/td[2]/h3")));
			
			WebElement error = driver.findElement(By.xpath(".//*[@id='pageContainer']/table/tbody/tr[1]/td[2]/h3"));
			error.getText();
			assertEquals("An error occurred in this request", error.getText());
			System.out.println(error.getText());
			
			driver.close();
	}
	@Test
	public void testRemoveBook() throws InterruptedException { //Testar att ta bort bok
		driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/");
		WebElement add = driver.findElement(By.xpath( ".//*[@id='pageContainer']/div[2]/div[3]/div[2]/div/div[3]/div/div[1]/a/img"));
		add.click();
		
		WebDriverWait w = new WebDriverWait(driver, 10);
		w.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='input-2']/div/button")));
		
		WebElement button = driver.findElement(By.xpath( ".//*[@id='input-2']/div/button"));
		button.click();
		System.out.println("Book Node Web Development has been added to shopping cart");
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, -250);");
		
		WebElement shop = driver.findElement(By.xpath(".//*[@id='open-cart']"));
		shop.click();
		
		WebElement x = driver.findElement(By.xpath(".//*[@id='2']/td[4]/button"));
		x.click();
		
		WebElement shop2 = driver.findElement(By.xpath(".//*[@id='open-cart']"));//Får göra det två gånger för att det ska fungera.
		shop2.click();
		
		WebElement x2 = driver.findElement(By.xpath(".//*[@id='2']/td[4]/button"));//Får göra det två gånger för att det ska fungera.
		x2.click();
		
		WebElement zero = driver.findElement(By.xpath(".//*[@id='miniCartSummary']"));
		zero.getText();
		assertEquals("SHOPPING CART (0)", zero.getText());
		
		System.out.println(zero.getText());
		
	}		
}	

