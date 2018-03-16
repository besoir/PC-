package GolfDatabase.Golf;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class Section implements java.io.Serializable  {
	private HashMap<String,Team> teams;
	public Section() {
		teams = new HashMap<String,Team>();
	}
	
	public void createTeamsFromPdf() throws IOException {
		ArrayList<Golfer> golfers = new ArrayList<Golfer>();
		PDDocument document = null;
		document = PDDocument.load( new File("scores.pdf") );
        
		PDFTextStripper stripper = new PDFTextStripper();
        stripper.setSortByPosition( true );
        stripper.setStartPage( 0 );
        stripper.setEndPage( document.getNumberOfPages() );
        String output = stripper.getText(document);
        
        String regrexNumber = "^(\\d{1,2}\\.?)"; /// get rid of the 1. - 24. player number
        String lines[] = output.split("\\n");
        String regexName = "(^\\s+[a-zA-Z]+\\s+[a-zA-Z]+)"; //players name
        String regexSchool = "\\((.*?)\\)"; //schoolName
        
        Golfer placeHolder = new Golfer("temp","value");
        int count = 0; //since lines is an array so the even numbers refer to scores and 	
        
        for(String line : lines) {
        		line = line.replaceAll(regrexNumber, "");	
        		int tmp = count%2;
        			switch(tmp) {
        			case 0: // scores
        				String[] score = line.split(" ");	
        				System.out.println(score[score.length-1]+" players score");
        				if(score[score.length-1].equals("Scores")) {break;}
        				placeHolder.addScore(score[score.length-1]);
        				break;
        			case 1: // names
        				Matcher school =  Pattern.compile(regexSchool).matcher(line);
        				Matcher name = Pattern.compile(regexName).matcher(line);
        				while(name.find()) {
        					String playerName =name.group(0).trim();
        					String[] names = playerName.split("\\s+");
        					placeHolder.setFirstName(names[0]);
        					placeHolder.setLastName(names[1]);
        					System.out.println(names[0]+":"+ names[1]);
            			}
        				while(school.find()) {
        					String teamName = school.group(1).trim();
        					System.out.println("aa: "+teamName);
        					placeHolder.setTeam(teamName);
        					golfers.add(placeHolder);
        					if(!teams.containsKey(teamName)) {
        						teams.put(teamName, new Team(teamName));
            				}
        					placeHolder = new Golfer("temp","value");
        				}

        			break;
        			default: 
        			break;	
        			}
        		count++;
        }
        document.close();
		this.createPlayersFromPdf(golfers);	
	}
	private void createPlayersFromPdf(ArrayList<Golfer> playersFromPdf) {
		//will add the players to the team
		System.out.println(playersFromPdf.size()+ " size of unsorted array");
		for(Golfer gf : playersFromPdf) {
			if(teams.containsKey(gf.getTeam())) {
				teams.get(gf.getTeam()).addPlayer(gf);
			}
		}
	}

	public void printMap() { //prints the players of teams
		Iterator<Team> ait = teams.values().iterator();
		while(ait.hasNext()) {
			Team tmp = ait.next();
			System.out.println("the name of team  "+tmp.getTeamName());
			if(tmp.teamSize() >=1) {
				if(tmp.getTeamName().equalsIgnoreCase("Pittsford Sutherland")) {
					System.out.println("we got thge sutherlkan");
					System.out.println(tmp.teamSize());
					System.out.println(tmp.getPlayer(tmp.teamSize()-1)+" aaaaaa");
				}
			tmp.printAll();
			}
		}
	}

	public void addPlayer(Golfer gf , String teamName) {
		if(teams.containsKey(teamName)) {
			teams.get(teamName).addPlayer(gf);
		}
	}
}

