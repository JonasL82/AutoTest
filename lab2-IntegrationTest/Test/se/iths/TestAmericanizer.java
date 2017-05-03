package se.iths;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestAmericanizer {

	public static Americanizer TestAmericanizer;
	@BeforeClass
	public static void Start(){
		TestAmericanizer = new Americanizer();
		MeasureConverter mc = new MeasureConverter();
		TestAmericanizer.setWeightConverter(mc);
		TimeConverter tc = new TimeConverter();
		TestAmericanizer.setTimeConverter(tc);
	}
	@Test
	public void TestconvertToPound() {
		int result = TestAmericanizer.convertToPound(10);
		assertEquals(3, result);
	}
	@Test
	public void TestconvertToFeet() {
		int result = TestAmericanizer.convertToFeet(30);
		assertEquals(1, result);
	}
	@Test
	public void TestconvertSpeach() {
		String result = TestAmericanizer.convertSpeach("Hellowsan");
		assertEquals("yo dude!" + "Hellowsan" + ", you know?", result);
	}
	@Test
	public void TestconvertTime() {
		String result = TestAmericanizer.convertTime(5);
		assertEquals("5 AM", result);
	}
	@Test
	public void TestconvertTime2() {
		String result = TestAmericanizer.convertTime(15);
		assertEquals("3 PM", result);
	}
	//e.printStackTrace() will return an empty string. 
}
