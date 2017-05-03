package se.iths;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;


public class TestMeasureConverter {
	public static MeasureConverter TestMeasureConverter;
	@BeforeClass
	public static void Start(){
		TestMeasureConverter = new MeasureConverter();
	}
	@Test
	public void testconvertWeight() {
		int result = TestMeasureConverter.convertWeight(10, true);	//Testing the convertWeight() with divide.
		assertEquals(3, result);
	}
	@Test
	public void testconvertWight2() {
		int result = TestMeasureConverter.convertWeight(10, false);	//Testing the convertWeight() with multiply.
		assertEquals(27, result);
	}
	@Test
	public void testconvertToFeet() {
		int cm = TestMeasureConverter.convertToFeet(100);	//Testing the convertToFeet() that divides the int value with 30.
		assertEquals(3, cm);
	}
}