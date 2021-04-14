package dataModel;

import java.util.List;

/**
 * This class implements the interface Data and describes a team in the football.csv file. Each team has a name, a number a goals
 * scored by them and a number of goals scored against them. Other attributes from the file are not required to solve this challenge
 * and therefore will not be processed. For each entry in the football.csv file an object of the class Team will be created.
 * @author Marina Tedayem
 *
 */
public class Team implements Data{
	private String teamName;
	private int goals;
	private int goalsAllowed;
	
	public Team (String n, int g, int allowed) {
		this.teamName = n;
		this.goals = g;
		this.goalsAllowed = allowed;
	}
	
	//Getter and Setter
	public String getName() {
		return teamName;
	}
	
	public void setName(String newname) {
		this.teamName = newname;
	}
	
	public int getGoals() {
		return goals;
	}
	
	public void setGoals(int newgoals) {
		this.goals = newgoals;
	}
	
	public int getGoalsAllowed() {
		return goalsAllowed;
	}
	
	public void setGoalsAllowed(int newAllowed) {
		this.goalsAllowed = newAllowed;
	}
	
	/**
	 * This method works similarly to the function findSmallestSpread() in the class WeatherDay. It looks for the team with the smallest
	 * absolute difference between the goals scored by the team and the goals scored against the team. It receives a list of teams
	 * as parameters and returns the name of the team with the smallest spread.
	 * @param listofteams
	 * @return
	 */
	public static String findSmallestSpread(List<Data> listofteams) {
		//Get the first team of the list
		Team t = (Team) listofteams.get(0);
		//Get his number of goals scored
		int goals = t.getGoals();
		//Get the number of goals scored against them
		int goalsAllowed = t.getGoalsAllowed();
		//Compute the difference
		int difference = diff(goals, goalsAllowed);		
		//Get his number
		String minTeam = t.getName();
		//Process all days in the list to find the one with the smallest spread
		for (int i = 1; i < listofteams.size(); i++) {
			t = (Team) listofteams.get(i);
			goals = t.getGoals();
			goalsAllowed = t.getGoalsAllowed();
			int temp = diff(goals, goalsAllowed);
			//Compare this actual spread with the former
			if (temp < difference) {
				difference = temp;
				minTeam = t.getName();
			}
		}
			
		return minTeam;
		
	}
	
	/**
	 * This method computes the absolute difference of two given integers. Because we do not want the difference to be negative,
	 * the given integers are compared before the calculation. 
	 * @param a
	 * @param b
	 * @return absolute difference between a and b.
	 */
	public static int diff(int a, int b) {
		if (a < b) {
			return b - a;
		}
		return a - b;
	}
}
