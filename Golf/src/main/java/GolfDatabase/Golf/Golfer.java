package GolfDatabase.Golf;

import java.util.ArrayList;

public class Golfer {
	private String fName, lName;
	private ArrayList<Integer> golferScores;
	
	public Golfer(String fName, String lName) {
		this.fName = fName;
		this.lName = lName;
		this.golferScores = new ArrayList<Integer>();
	}
	
	public void addScore(String scoreToAdd) {
		int addThis = Integer.parseInt(scoreToAdd);
		golferScores.add(addThis);
	}
}
