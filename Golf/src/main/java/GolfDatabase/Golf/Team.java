package GolfDatabase.Golf;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

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
	
	public void testPdfParser() throws IOException {
		PDDocument document = null;
		document = PDDocument.load( new File("scores") );
        PDFTextStripper stripper = new PDFTextStripper();
        stripper.setSortByPosition( true );
        stripper.setStartPage( 0 );
        stripper.setEndPage( document.getNumberOfPages() );
        String output = stripper.getText(document);
        
        String regrexNumber = "^(\\d{1,2}\\.?)"; /// get rid of the 1. - 24. player number
        String lines[] = output.split("\\n");
        String regexName = "(^\\s+[a-zA-Z]+\\s+[a-zA-Z]+)"; //players name
        String regexSchool = "\\((.*?)\\)"; //schoolName
       
        
        Golfer atmp = new Golfer("place","holder");
        int count = 0; //since lines is an array so the even numbers refer to scores and 	
        
        
        for(String line : lines) {
        line = line.replaceAll(regrexNumber, "");	
        	int tmp = count%2;
        		switch(tmp) {
        		case 0: // scores
        			String[] score = line.split(" ");	
        			System.out.println(score[score.length-1]+" players score");
        			if(score[score.length-1].equals("Scores")) {break;}
        			atmp.addScore(score[score.length-1]);
        			break;
        		case 1: // names
        			Matcher school =  Pattern.compile(regexSchool).matcher(line);
        			Matcher name = Pattern.compile(regexName).matcher(line);
        			while(name.find()) {
            			System.out.println(name.group(0)+"  name?");
            			String[] names = name.group(0).split("\\s+");
            			atmp.setFirstName(names[1]);
            			atmp.setLastName(names[2]);
            			this.golferList.add(atmp);
            			atmp = new Golfer("place","holder");	
            			}
        			while(school.find()) {
            		
            			System.out.println(school.group(1)+" school name?");
            			atmp.setTeam(school.group(1));
            			
            		}
            		
        			
        			break;
        		default: break;	}
        		count++;}
       
        
        
        document.close();
        
    }
    

		

	
	
	public void printAll() {
		for(Golfer g:golferList)
			System.out.println(g);
	}
}
