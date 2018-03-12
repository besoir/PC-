package GolfDatabase.Golf;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Team t = new Team("Thomas");
		t.readFile("scores.txt");
		t.printAll();
	}

}
