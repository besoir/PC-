package GolfDatabase.Golf;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Section section5;
		ObjectInputStream in; 
		Team t = new Team("Thomas");

		//so the catch and try is the worst way to check if the file has any data on it.
		// I apologize for it but it is first time messing with serialization.
		try{
			 in = new ObjectInputStream(new FileInputStream("abcd"));
			section5 =(Section)in.readObject();
			System.out.println("inside try");
			
		}
		catch(ClassNotFoundException e) {
			//means we haven't written to the file
			section5 = new Section();
			System.out.println("inside the catch");
			section5.createTeamsFromPdf();
		}
		catch(InvalidClassException e2) {System.out.println("inside the catch e2");
		section5 = new Section();
		System.out.println("inside the catch");
		section5.createTeamsFromPdf();}
		
		catch(IOException e3){
			
			System.out.println("inside the catch e3");
			section5 = new Section();
			System.out.println("inside the catch");
			section5.createTeamsFromPdf();}
		
// we can add the multiple paths -- check scores for each time ,export a teams scores		
		//t.readFile("scores.txt");
		//t.testPdfParser();
		//t.printAll();
		System.out.println("zz");

	section5.printMap();
	FileOutputStream file = new FileOutputStream("abcd");
	ObjectOutputStream out = new ObjectOutputStream(file);
	System.out.println("about to add");
	//section5.addPlayer(new Golfer("please","be gentle"),"Webster Thomas");
	out.writeObject(section5);
	System.out.println("zz"); 
	out.close();
	file.close();
	
	

	
	
	
	}

}