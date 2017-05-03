package se.iths;

/**
 * This class is the main class that should be tested in Lab2
 * @author Johan Ström
 *
 */
public class Americanizer {
	
	private MeasureConverter measureConverter;
	private TimeConverter timeConverter;
	
	public void setWeightConverter(MeasureConverter converter) {
		measureConverter = converter;
	}
	
	public void setTimeConverter(TimeConverter converter){
		timeConverter = converter;
	}
	
	public String convertTime(int hours) {
		String time = "";
		try {
			if(hours >= 12) {
				time = Integer.toString(hours - 12);
			}
			else {
				time = Integer.toString(hours);
			}
			time = time + " " + timeConverter.getMeridiem(hours);
		} catch(Exception e) {
			e.printStackTrace();
			return "";
		}
		return time;
	}
	
	public int convertToPound(int kg){
		return measureConverter.convertWeight(kg, true);
	}
	
	public String convertSpeach(String sentence) {
		return "yo dude!" + sentence + ", you know?";
	}
	
	public int convertToFeet(int cm) {
		return measureConverter.convertToFeet(cm);
	}
}
