package GolfDatabase.Golf;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		Team t = new Team("Thomas");
		t.readFile("scores.txt");
		t.testPdfParser();
		t.printAll();
	
	}

}
