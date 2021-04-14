package dataModel;

public class Team{
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

}
