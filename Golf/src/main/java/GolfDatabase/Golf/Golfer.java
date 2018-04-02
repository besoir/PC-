package GolfDatabase.Golf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Golfer implements java.io.Serializable {
	private  SimpleStringProperty fName, lName,team;
	private ArrayList<Integer> golferScores;
	private int careerAverage,teamRanking;
	private SimpleIntegerProperty sc;
	private String regFName, regTeam;
	private String regLName;
	private HashMap<Integer, Match> match;
	private ArrayList<Integer> scoreList;
	
	public Golfer(String fName, String lName) {
		this.fName = new SimpleStringProperty(fName);
		this.lName = new SimpleStringProperty(lName);
		this.golferScores = new ArrayList<Integer>();
		this.regFName = fName;
		this.regLName = lName;
		match = new HashMap<>();
		scoreList = new ArrayList();
	}
	
	public void addScore(String scoreToAdd) {
		int addThis = Integer.parseInt(scoreToAdd);
		golferScores.add(addThis);
	}
	
	public void setFirstName(String firstN) {
		this.fName= new SimpleStringProperty(firstN);
		this.regFName = firstN;
	}
	
	public void setLastName(String lastN) {
		this.lName = new SimpleStringProperty(lastN);
		this.regLName = lastN;
	}
	
	public void setTeam(String tema) {
		this.regTeam = tema;
	}
	
	public void setHashMap(Match m) {
		Random r = new Random();
		Integer key = r.nextInt(9000) + 999;
		for(Integer i:scoreList) {
			if(key == scoreList.get(i)) {
				setHashMap(m);
			}
		}
		match.put(key, m);
		scoreList.add(key);
	}
	
	public void printMatches() {
		for(Integer i:scoreList)
			System.out.println(match.get(i));
	}
	
	public int getNumOfScores() {
		return scoreList.size();
	}
	
	public void setTeamProp() {
		this.team = new SimpleStringProperty(this.regTeam);
	}
	
	public String getTeam() {
		return regTeam;
	}
	
	public SimpleStringProperty TeamProperty() {
		return team;
	}

	public SimpleStringProperty fNameProperty() {
		return fName;
	}
	
	public SimpleStringProperty lNameProperty() {
		return lName;
	}
	public SimpleIntegerProperty scoreProperty() {
		sc = new SimpleIntegerProperty(this.golferScores.get(0));
		return sc;
		
	}
	 public int getScore() {
		 return this.golferScores.get(0);
	 }
	
	public String getFirstName() {
	    return this.regFName;	
	}
	
	public String getLastName() {
		 return this.regLName;
	}
	
	public String getFullName() {
		return fName + " " + lName;
	}
	
	@Override
	public String toString() {
		String output = this.regFName + " " + this.regLName + " " + this.regTeam;
		if(!(golferScores.size() == 0))
			output = output + " with a score of " +  golferScores.get(0) + ".";
		else 
			output = output + " has no scores... yet!";
		return output;
	}
}
