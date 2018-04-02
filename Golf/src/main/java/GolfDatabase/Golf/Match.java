package GolfDatabase.Golf;

public class Match {
	private String date, course, par, score;
	
	public Match(String c, String d, String p, String s) {
		this.date = d;
		this.course = c;
		this.par = p;
		this.score = s;
	}
	
	public String[] getMatch() {
		String[] ar = {date, course, par, score};
		return ar;
	}
	
	@Override
	public String toString() {
		return "Course: " + course + " played on " + date + " with a par of " + par + " and a score of " + score;
	}
}