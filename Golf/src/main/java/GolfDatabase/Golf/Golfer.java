package GolfDatabase.Golf;

import java.util.ArrayList;

public class Golfer implements java.io.Serializable {
	private String fName, lName,team;
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
	public void setFirstName(String firstN) {
		this.fName= firstN;}
	
	public void setLastName(String lastN) {
		this.lName = lastN;
	}
	public void setTeam(String tema) {
		this.team = tema;
	}
	public String getTeam() {
		return team;
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
		return this.fName + " " + lName + " " +this.team+".";
	}
}
