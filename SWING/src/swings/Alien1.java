package swings;

import java.util.List;


public class Alien1 extends Figuren{
	
	public Alien1() {
		name = "Der Riddler";
		this.size.x = 5;
		this.size.y = 2;
		hitMask = new char[getTotalSize()];
		erzeugeAussehen();
		this.resetAussehen();
	}
	
	private void erzeugeAussehen() {
		
		char [] aussehen = new char[getTotalSize()];
		
		aussehen[0] = 1;
		aussehen[1] = '/';
		aussehen[2] = '^';
		aussehen[3] = '\\';
		aussehen[4] = 1;
		aussehen[5] = '|';
		aussehen[6] = '^';
		aussehen[7] = '|';
		aussehen[8] = '^';
		aussehen[9] = '|';
		aussehenVarianten.add(aussehen);

		aussehen = new char[getTotalSize()];
		aussehen[0] = 1;
		aussehen[1] = '/';
		aussehen[2] = '^';
		aussehen[3] = '\\';
		aussehen[4] = 1;
		aussehen[5] = '/';
		aussehen[6] = '^';
		aussehen[7] = '|';
		aussehen[8] = '^';
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
