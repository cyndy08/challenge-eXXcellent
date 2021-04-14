package dataAccess;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dataModel.Data;
import dataModel.Team;
import dataModel.WeatherDay;

/**
 * This class is used to read data from a file and create object of a particular class.
 * If the file is a csv.file, the delimiter that will be used is a comma. The delimiter can be changed depending on the file that is read.
 * All method in this class are static so that they can be called without creating an object.
 * @author Marina Tedayem
 *
 */
public class ReaderFromFileCSV {
	final static String DELIMITER = ",";
	
	/**
	 * 
	 * @param filename
	 * @return List of created WeatherDay
	 */
	public static List<Data> readDataFromFile (String filename) {
		List<Data> list = new ArrayList<>();
		try (BufferedReader buffer = new BufferedReader(new FileReader(filename))){
			//Read the first line of the file and skip it
			buffer.readLine();
			String line = null;
			// Go through the file until all lines are read
			while( (line=buffer.readLine()) != null) {
				//Get all the attributes of a particular day from the file
				List<String> attributes = Arrays.asList(line.split(DELIMITER));
				WeatherDay d = null;
				Team t = null;
				if (filename.contains("weather")) {
					//Create a new Object of the class WeatherDay with these attributes
					d = createDay(attributes);
					//Add this new Day to the list
					list.add(d);
				}
				else if (filename.contains("football")) {
					//Create a new Object of the class Team with these attributes
					t = createTeam(attributes);
					//Add this new Day to the list
					list.add(t);
				}
				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * This method receives a list of String as parameter and uses the element of the list to create a new object of the class Team.
	 * @param list
	 * @return new object of the class Team
	 */
	public static Team createTeam(List<String> list) {
		String name = list.get(0);
		int goals = Integer.parseInt(list.get(5));
		int goalsAllowed = Integer.parseInt(list.get(6));
		
		return new Team (name, goals, goalsAllowed);
	}
	/**
	 * This method receives a list of String as parameter and uses the element of the list to create a new object of the class WeatherDay.
	 * @param list
	 * @return new object the class WeatherDay
	 */
	public static WeatherDay createDay(List<String> list) {
		String number = list.get(0);
		double maxTemp = Double.parseDouble(list.get(1));
		double minTemp = Double.parseDouble(list.get(2));
		
		return new WeatherDay (number, maxTemp, minTemp);
	}
	public static int findPositionColumn(String filename, String columname) {
		int position = 0;
		
		return position;
	}
	
	
}
