package GolfDatabase.Golf;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		Team t = new Team("Thomas");
		t.readFile("scores.txt");
		t.testPdfParser();
		t.printAll();
<<<<<<< HEAD
		Section section5 = new Section();
		section5.createTeamsFromPdf();
		section5.printMap();
		section5.printAllTeams();
=======
	
>>>>>>> 07dbe30d9db45ab31e7bf3c2154fec7c2f9faf17
	}

}
