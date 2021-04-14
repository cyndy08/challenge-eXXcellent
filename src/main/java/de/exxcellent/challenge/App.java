package de.exxcellent.challenge;

import java.util.List;

import dataAccess.ReaderFromFileCSV;
import dataModel.Data;
import dataModel.Team;
import dataModel.WeatherDay;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
	
	final static String SYSTEMPATH = ".\\src\\main\\resources\\de\\exxcellent\\challenge\\";
	
    public static void main(String... args) {

        // Read the weather.csv file and get the list of weather days
    	List<Data> list1 = ReaderFromFileCSV.readDataFromFile(SYSTEMPATH + args[0]);
    	List<Data> list2 = ReaderFromFileCSV.readDataFromFile(SYSTEMPATH + args[1]);
    	
    	// Find the day with the smallest temperature spread and store his number in the variable dayWithSmallestTempSpread
        String dayWithSmallestTempSpread = WeatherDay.findSmallestSpread(list1);
       // Your day analysis function call …
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
        
        //Find the team with the smallest goal spread and store his name in the variable teamWithSmallestGoalSpread
        String teamWithSmallestGoalSpread = Team.findSmallestSpread(list2); 
        // Your goal analysis function call …
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
        
    }
}
