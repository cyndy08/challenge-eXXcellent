package dataAccess;

import java.util.List;

import dataModel.WeatherDay;

public interface ReaderFromFile {
	
	public List<WeatherDay> readDataFromFile (String filename);
}
