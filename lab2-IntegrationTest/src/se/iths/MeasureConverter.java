package se.iths;

public class MeasureConverter {
	public int convertWeight(int value, boolean tometric) {
		
		if(tometric) {
			return (int)(value/2.7);
		}
		else {
			return (int)(value*2.7);
		}
	}
	
	public int convertToFeet(int cm) {
		return cm / 30;
	}
}
