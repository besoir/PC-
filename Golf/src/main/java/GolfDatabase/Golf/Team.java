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
		do {
			String garbage = fc.nextLine();
			String garbageSplitter[] = garbage.split("\\s+");
			Golfer temp = new Golfer(garbageSplitter[0], garbageSplitter[1]);
			if(golferList.size() != 0) {
				boolean exists = false;
				for(Golfer g:golferList) {
					if(g.getFullName().equals(temp.getFullName())) {
						g.addScore(garbageSplitter[2]);
						exists = true;
					}
				}
				if(exists == false) {
					temp.addScore(garbageSplitter[2]);
					golferList.add(temp);
				}
			} else {
				temp.addScore(garbageSplitter[2]);
				golferList.add(temp);
			}	
		} while((fc.hasNextLine()));
	}
	
	public void printAll() {
		for(Golfer g:golferList)
			System.out.println(g);
	}
}
