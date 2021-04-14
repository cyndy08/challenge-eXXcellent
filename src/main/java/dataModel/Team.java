package dataModel;

import java.util.List;

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
	public static int diff(int a, int b) {
		if (a < b) {
			return b - a;
		}
		return a - b;
	}
}
