package GolfDatabase.Golf;

import java.util.ArrayList;

public class Golfer {
	private String fName, lName;
	private ArrayList<Integer> golferScores;
	private int careerAverage,teamRanking;
	
	public Golfer(String fName, String lName) {
		this.fName = fName;
		this.lName = lName;
		this.golferScores = new ArrayList<Integer>();
	}
	
	public void addScore(String scoreToAdd) {
		int addThis = Integer.parseInt(scoreToAdd);
		golferScores.add(addThis);
	}
	
	public String getFirstName() {
		return fName;
	}
	
	public String getLastName() {
		return lName;
	}
	
	public String getFullName() {
		return fName + " " + lName;
	}
	@Override
	public String toString() {
		return this.fName + " " + lName + " " + golferScores.get(0);
	}
}
