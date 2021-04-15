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
public class ReaderFromFileCSV implements ReaderFromFile {
	final static String DELIMITER = ",";
	//Needed column names in the weather.csv file
	final static String COLUMN_DAY = "Day";
	final static String COLUMN_MAX = "MxT";
	final static String  COLUMN_MIN = "MnT";
	
	//Needed column names in the football.csv file
	final static String COLUMN_TEAM = "Team";
	final static String COLUMN_GOALS = "Goals";
	final static String COLUMN_GOALS_ALLOWED = "Goals Allowed";
	
	//constructor
	public ReaderFromFileCSV(){
		
	}
	/**
	 * The following method reads the passed csv.file and returns a list of objects of the interface Data.
	 * If the actual file is the weather.csv file then objects of the class WeatherDay are created with the values
	 * of the columns day, MxT and MnT. 
	 * If the file is the football.csv file, in this case objects of the class Team are created using the values of
	 * the column name, goals and goals Allowed. Each created object is added to the list that will be returned at the
	 * end of the function.
	 * @param filename
	 * @return List of created Data
	 */
	public List<Data> readDataFromFile (String filename) {
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
					d = createDay(attributes, filename);
					//Add this new Day to the list
					list.add(d);
				}
				else if (filename.contains("football")) {
					//Create a new Object of the class Team with these attributes
					t = createTeam(attributes, filename);
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
	 * Here the method findPositionColumn() is used to determine the index of the column that will be used. The name of a team is in 
	 * the column "team", the goals scored by a team are in the column "goals" and the goals scored against a team are in "goals Allowed".
	 * The extracted values are used to create a new object of the class Team that is returned.
	 * @param list
	 * @param filename
	 * @return new object of the class Team
	 */
	public Team createTeam(List<String> list, String filename) {
		String name = list.get(findPositionColumn(filename, COLUMN_TEAM));
		int goals = Integer.parseInt(list.get(findPositionColumn(filename, COLUMN_GOALS)));
		int goalsAllowed = Integer.parseInt(list.get(findPositionColumn(filename, COLUMN_GOALS_ALLOWED)));
		
		return new Team (name, goals, goalsAllowed);
	}
	/**
	 * This method receives a list of String as parameter and uses the element of the list to create a new object of the class WeatherDay.
	 * To determine the position of each column in the file, the function findPositionColumn() is used. The number of a day is stored in the
	 * column "day", the maximal temperature is in "MxT" and the minimal Temperature is in the column "MnT". The extracted values are used to 
	 * create a new object of the class WeatherDay that is returned at the end of the function.
	 * @param list
	 * @param filename
	 * @return new object the class WeatherDay
	 */
	public  WeatherDay createDay(List<String> list, String filename) {
		String number = list.get(findPositionColumn(filename, COLUMN_DAY));
		double maxTemp = Double.parseDouble(list.get(findPositionColumn(filename, COLUMN_MAX)));
		double minTemp = Double.parseDouble(list.get(findPositionColumn(filename, COLUMN_MIN)));
		
		return new WeatherDay (number, maxTemp, minTemp);
	}
	
	/**
	 * This method determines the position of a given column in a given file. First of all the given file will be read using a 
	 * BufferedReader and a FileReader. Because we only want to determine the index of a given position, the whole file does not
	 * need to be read. Only the first line is read and the output is written in a list. With a for-loop we search in this list for
	 * the given column. Is the column found then its position is stored, the loop is stopped and the position is returned.
	 *  Otherwise the function returns -1, meaning that the given column does not exist in the given file.
	 * @param filename
	 * @param columname
	 * @return position of a column in a file
	 */
	public int findPositionColumn(String filename, String columname) {
		int position = -1;
		try (BufferedReader buffer = new BufferedReader(new FileReader(filename))){
			//Read only the first line and save the output in a list of string.
			String line = buffer.readLine();
			List<String> columns = Arrays.asList(line.split(DELIMITER));
			for (int i = 0; i < columns.size(); i++) {
				//If the column is found
				if (columns.get(i).equals(columname)) {
					position = i;
					break;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return position;
	}
	
	
}
