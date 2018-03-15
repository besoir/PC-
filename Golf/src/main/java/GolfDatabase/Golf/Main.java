package GolfDatabase.Golf;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		Team t = new Team("Thomas");
	t.readFile("scores.txt");
	t.testPdfParser();
	t.printAll();
	Section section5 = new Section();
	section5.createTeamsFromPdf();
	section5.printMap();
	}

}
