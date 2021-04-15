package dataAccess;

import java.util.List;

import dataModel.Data;
/**
 * This interface is used to read any kind of files where the data are extracted. 
 * For a specific type of file a new class is created that impplements this interface and the abstract method 
 * readDataFromFile().
 * @author Marina Tedayem
 *
 */

public interface ReaderFromFile {
	
	public List<Data> readDataFromFile (String filename);
}
