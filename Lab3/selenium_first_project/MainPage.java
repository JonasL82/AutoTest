package se.iths.selenium_first_project;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends ParentPage {

	public static void testGoToDefaultStore(WebDriver driver) throws InterruptedException {
		
		driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/product/the-big-switch.html");
		
		assertEquals("Shopizer Demo - Default store", driver.getTitle());
		
	}
	//public void testAddToCart() throws InterruptedException {
		//WebElement add = driver.findElement(By.xpath( ".//*[@id='pageContainer']/div[2]/div[3]/div[2]/div/div[3]/div/div[1]/a/img"));
}