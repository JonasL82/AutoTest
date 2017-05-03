package se.iths;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestTimeConverter {
	public static TimeConverter TestTimeConverter;
	@BeforeClass
	public static void Start(){
		TestTimeConverter = new TimeConverter();
	}	
	@Test
    public void getMeridiemPM() {
       String result = TestTimeConverter.getMeridiem(13);
       assertEquals("PM", result);
	}
	@Test
    public void getMeridiemAM() {
       String result = TestTimeConverter.getMeridiem(5);
       assertEquals("AM", result);
	}
	@Test(expected=IllegalArgumentException.class)
    public void timeConverterIllegalArgument() {
       TestTimeConverter.getMeridiem(25);
	}
}	