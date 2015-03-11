package swings;
import java.util.List;

public class SchussBomb extends Figuren{
	
	int counterSchussBombBewegung = 0, schussBombVerzögerung = 1;
	
	public SchussBomb() {
		name = "Die Bombe";
		this.size.x = 3;
		this.size.y = 3;
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
		aussehen[4] = '*';
		aussehen[5] = ' ';
		aussehen[6] = ' ';
		aussehen[7] = ' ';
		aussehen[8] = ' ';
		aussehenVarianten.add(aussehen);

		aussehen = new char[getTotalSize()];
		aussehen[0] = ' ';
		aussehen[1] = '*';
		aussehen[2] = ' ';
		aussehen[3] = '*';
		aussehen[4] = '*';
		aussehen[5] = '*';
		aussehen[6] = ' ';
		aussehen[7] = '*';
		aussehen[8] = ' ';
		aussehenVarianten.add(aussehen);

	}
	
	@Override
	public void routeAbfahren() {
		if (this.verzögerungSchussBewegung())
			return;
		this.setPosition(this.getPosition().x , this.getPosition().y-1);
	}
	
	public void changeSize(int currentAussehenIndex) {
//		
//		switch(currentAussehenIndex) {
//			
//			case 0: this.size.x = 1;
//					this.size.y = 1;
//			break;
//			
//			case 1: this.size.x = 3;
//					this.size.y = 3;
//			break;
//			
//			default: 
//			break;
//		}
	}
	
	private boolean verzögerungSchussBewegung() {
		if(counterSchussBombBewegung == schussBombVerzögerung) {
			counterSchussBombBewegung = 0;
			return true;
		}else {
			counterSchussBombBewegung++;
		}
	return false;
	}
	
	public List<char[]> getAussehen() {
		return aussehenVarianten;
	}
}
