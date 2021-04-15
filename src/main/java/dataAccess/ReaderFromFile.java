package dataAccess;

import java.util.List;

import dataModel.Data;

public interface ReaderFromFile {
	
	public List<Data> readDataFromFile (String filename);
}
