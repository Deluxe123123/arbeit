package swings;
import java.util.List;

public class SchussNuke extends Figuren {
	
	public SchussNuke() {
		name = "Der Atomare Zerstörung";
		this.size.x = 5;
		this.size.y = 5;
		hitMask = new char[getTotalSize()];
		erzeugeAussehen();
		this.resetAussehen();
	}
	
	private void erzeugeAussehen() {
		
		char [] aussehen = new char[getTotalSize()];
		aussehen[0] = ' ';
		aussehen[1] = ' ';
		aussehen[2] = ' ';
		aussehen[3] = ' ';
		aussehen[4] = ' ';
		aussehen[5] = ' ';
		aussehen[6] = ' ';
		aussehen[7] = ' ';
		aussehen[8] = ' ';
		aussehen[9] = ' ';
		aussehen[10] = ' ';
		aussehen[11] = ' ';
		aussehen[12] = ' ';
		aussehen[13] = ' ';
		aussehen[14] = ' ';
		aussehen[15] = ' ';
		aussehen[16] = ' ';
		aussehen[17] = ' ';
		aussehen[18] = ' ';
		aussehen[19] = ' ';
		aussehen[20] = ' ';
		aussehen[21] = ' ';
		aussehen[22] = '*';
		aussehen[23] = ' ';
		aussehen[24] = ' ';
		aussehenVarianten.add(aussehen);

		aussehen = new char[getTotalSize()];
		aussehen[0] = ' ';
		aussehen[1] = ' ';
		aussehen[2] = '*';
		aussehen[3] = ' ';
		aussehen[4] = ' ';
		aussehen[5] = ' ';
		aussehen[6] = '*';
		aussehen[7] = '*';
		aussehen[8] = '*';
		aussehen[9] = ' ';
		aussehen[10] = '*';
		aussehen[11] = '*';
		aussehen[12] = '*';
		aussehen[13] = '*';
		aussehen[14] = '*';
		aussehen[15] = ' ';
		aussehen[16] = '*';
		aussehen[17] = '*';
		aussehen[18] = '*';
		aussehen[19] = ' ';
		aussehen[20] = ' ';
		aussehen[21] = ' ';
		aussehen[22] = '*';
		aussehen[23] = ' ';
		aussehen[24] = ' ';
		aussehenVarianten.add(aussehen);

		
	}
	
	@Override
	public void routeAbfahren() {	
		this.setPosition(this.getPosition().x , this.getPosition().y-1);
	}
	
	public void verzögerungSchussBewegung() {
		this.routeAbfahren();
	}
	
	public List<char[]> getAussehen() {
		return aussehenVarianten;
	}
}
