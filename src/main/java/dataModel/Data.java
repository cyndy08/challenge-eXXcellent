package dataModel;

import java.util.List;

/**
 * This interface is implemented by the classes WeatherDay and Team.
 * The abstract method findSmallestSpread() will be implented differently according to the class
 * @author Marina Tedayem
 *
 */
public interface Data {
	
	public String findSmallestSpread(List<Data> listofdays);
}
