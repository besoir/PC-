package GolfDatabase.Golf;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Team {
	private String teamName;
	private ArrayList<Golfer> golferList;
	
	public Team(String tName) {
		teamName = tName;
		this.golferList = new ArrayList<Golfer>();
	}
	
	public void readFile(String fileName) throws FileNotFoundException {
		File toRead = new File(fileName);
		Scanner fc = new Scanner(toRead);
		while(!(fc.hasNextLine())) {
			String garbage = fc.nextLine();
			String garbageSplitter[] = garbage.split(" ");
			Golfer temp = new Golfer(garbageSplitter[0], garbageSplitter[1]);
			for(Golfer g:golferList) {
				if(g.equals(temp))
					g.addScore(garbageSplitter[2]);
				else {
					temp.addScore(garbageSplitter[2]);
					golferList.add(temp);
				}
			}
		}
	}
}
