package dataModel;

import java.util.List;

/**
 * The class WeatherDay describes how is the weather at a particular day. Each instance of this class has a number,
 * a maximal temperature and a minimal temperature. This class is used to process the data from the weather.csv file.
 * For each entry in this file a new object of the class WeatherDay will be created with the required attributes.
 * 
 * @author Marina Tedayem
 *
 */
public class WeatherDay implements Data{
	private String dayNumber;
	private double maxTemperature;
	private double minTemperature;
	
	//constructor to create a new object of this class
	public WeatherDay(String num, double maxTemp, double minTemp) {
		this.dayNumber = num;
		this.maxTemperature = maxTemp;
		this.minTemperature = minTemp;
	}
	
	//Getter and Setter for the attributes because they are private and can not be accessed from another class
	public String getNumber() {
		return dayNumber;
	}
	
	public void setNumber (String n) {
		this.dayNumber = n;
	}
	
	public double getMinTemperature() {
		return minTemperature;
	}
	
	public void setMinTemperature(double min) {
		this.minTemperature = min;
	}
	
	public double getMaxTemperature() {
		return maxTemperature;
	}
	
	public void setMaxTemperature(double max) {
		this.maxTemperature = max;
	}
	
	/**
	 * The method findMinimumSpread() receives a list of weather days as parameter and looks for the day with the smallest spread.
	 * The Spread here is the difference between the maximal temperature and the minimal temperature on a given day.
	 * First of all the spread of the first day in the list will be computed. This is the day at the index zero in the list.
	 * In the for-loop the spread of actual day at the index i will be computed and compared to the last stored spread. 
	 * Is the new computed spread smaller than the former, it becomes the new minimal spread and the number of this day will be determined.
	 * Otherwise the next day in the list will be processed.  
 	 * @param listofdays
	 * @return String minDay: number of the day with the smallest spread
	 */
	public static String findSmallestSpread(List<Data> listofdays) {
		//Get the first day of the list
		WeatherDay d = (WeatherDay) listofdays.get(0);
		//Get his minimal temperature
		double mintemp = d.getMinTemperature();
		//Get his maximal temperature
		double maxtemp = d.getMaxTemperature();
		//Compute his spread
		double minSpread = maxtemp - mintemp;		
		//Get his number
		String minDay = d.getNumber();
		//Process all days in the list to find the one with the smallest spread
		for (int i = 1; i < listofdays.size(); i++) {
			d = (WeatherDay) listofdays.get(i);
			mintemp = d.getMinTemperature();
			maxtemp = d.getMaxTemperature();
			double temp = maxtemp - mintemp;
			//Compare this actual spread with the former
			if (temp < minSpread) {
				minSpread = temp;
				minDay = d.getNumber();
			}
		}
			
		return minDay;
		
	}
}
