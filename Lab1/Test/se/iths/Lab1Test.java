package se.iths;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

//import java.util.Random;

public class Lab1Test {
	public static Lab1 Lab1Test;
	@BeforeClass
	public static void Start(){
		Lab1Test = new Lab1();
	}

	@Test
	public void testadd() {
		int result = Lab1Test.add(1, 2);
		assertEquals(3, result);
	}
	@Test
	public void testadd2() {
		int result = Lab1Test.add(-2, -2);
		assertEquals(-4, result);		
	}
	@Test
	public void testsubtract() {
		int result = Lab1Test.subtract(1, 2);
		assertEquals(-1, result);
	}
	@Test
	public void testmultiply() {
		int result = Lab1Test.multiply(100, 200);
		assertEquals(20000, result);
	}
	@Test
	public void testmultiply2() {
		int result = Lab1Test.multiply(-5, 5);
		assertEquals(-25, result);
	}
	@Test
	public void testdivide() {
		int result = Lab1Test.divide(10, 5);
		assertEquals(2, result);
	}
	@Test
	public void testreverse() {
		String result = Lab1Test.reverse("ABC");
		assertEquals("CBA", result);
	}
	@Test
	public void testquote() {
		Boolean a = false;
		Boolean b = true;
		Boolean c = true;
		Boolean d = true;
		Boolean e = true;
		Boolean f = true;
		Boolean g = true;
		Boolean h = true;
		
		for  (int number = 0; number < 100; number++) {
				String result = Lab1Test.quote();
			if (result.equals("We cannot solve our problems with the same thinking we used when we created them. - Albert Einstein")){
				a = true; 
			}
			if (result.equals("A fool thinks himself to be wise, but a wise man knows himself to be a fool. - William Shakespeare")){
				b = true; 
			}
			if (result.equals("You must be the change you wish to see in the world. - Mahatma Gandhi")){
				c = true; 
			}
			if (result.equals("In the End, we will remember not the words of our enemies, but the silence of our friends. - Martin Luther King, Jr.")){
				d = true; 
			}
			if (result.equals("Choose a job you love, and you will never have to work a day in your life. - Confucius")){
				e = true; 
			}
			if (result.equals("To expect the unexpected shows a thoroughly modern intellect. - Oscar Wilde")){
				f = true; 
			}
			if (result.equals("Without music, life would be a mistake. - Friedrich Nietzsche")){
				g = true; 
			}
			if (result.equals("I love deadlines. I like the whooshing sound they make as they fly by. - Douglas Adams")){
				h = true; 
			}

	
	}
		assertTrue("Did not find: We can not solve....", a);
		assertTrue("A fool thinks himself to be wise..", b);
		assertTrue("You must be the change you wish...", c);
		assertTrue("In the End, we will remember......", d);
		assertTrue("Choose a job you love.............", e);
		assertTrue("To expect the unexpected..........", f);
		assertTrue("Without music, life would be a....", g);
		assertTrue("I love deadlines. I like the......", h);
		
}
	@Test
	public void testgetcounter(){
		int startvalue = Lab1Test.getCounter();
		Lab1Test.add(1, 2);
		Lab1Test.subtract(4, 2);
		Lab1Test.multiply(1, 2);
		Lab1Test.divide(10, 5);
		Lab1Test.reverse("ABC");
		Lab1Test.quote();
		
		assertEquals(startvalue + 6, Lab1Test.getCounter());    
	                    						
	}
}	
