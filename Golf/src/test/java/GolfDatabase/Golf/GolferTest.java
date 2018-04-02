package GolfDatabase.Golf;

import static org.junit.Assert.*;

import org.junit.Test;

public class GolferTest {
	private Golfer g;
	
	@Test
	public void testSetHashMap() {
		g = new Golfer("Tommy", "Hanley");
		Match m = new Match("Pebble Beach", "11/12/13", "72", "72");
		g.setHashMap(m);
		g.printMatches();
		assertEquals(1, g.getNumOfScores());
	}

}
