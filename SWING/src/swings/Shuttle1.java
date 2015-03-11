package swings;

import java.util.List;


public class Shuttle1 extends Figuren{

	public Shuttle1() {
		name = "Der Retter";
		this.size.x = 5;
		this.size.y = 2;
		hitMask = new char[getTotalSize()];
		erzeugeAussehen();
		this.resetAussehen();
	}
	
	private void erzeugeAussehen() {
		
		char [] aussehen = new char[getTotalSize()];
		
		aussehen[0] = ' ';
		aussehen[1] = '/';
		aussehen[2] = '^';
		aussehen[3] = '\\';
		aussehen[4] = ' ';
		aussehen[5] = '/';
		aussehen[6] = '.';
		aussehen[7] = '|';
		aussehen[8] = '.';
		aussehen[9] = '\\';
		aussehenVarianten.add(aussehen);

		aussehen = new char[getTotalSize()];
		aussehen[0] = ' ';
		aussehen[1] = '/';
		aussehen[2] = '^';
		aussehen[3] = '\\';
		aussehen[4] = ' ';
		aussehen[5] = '/';
		aussehen[6] = ',';
		aussehen[7] = '|';
		aussehen[8] = ',';
		aussehen[9] = '\\';
		aussehenVarianten.add(aussehen);

		
	}
	

	public List<char[]> getAussehen() {
		return aussehenVarianten;
	}

	@Override
	public void routeAbfahren() {
		// TODO Automatisch generierter Methodenstub
		
	}
	
}