package GolfDatabase.Golf;

import java.util.ArrayList;

public class Team {
	private String teamName;
	private ArrayList<Golfer> golferList;
	
	public Team(String tName) {
		teamName = tName;
		this.golferList = new ArrayList<Golfer>();
	}
}
