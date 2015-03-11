package swings;
import java.util.List;

public class SchussNormal extends Figuren {
	
	public SchussNormal() {
		name = "Der Schussler";
		this.size.x = 1;
		this.size.y = 1;
		hitMask = new char[getTotalSize()];
		erzeugeAussehen();
		this.resetAussehen();
	}
	
	private void erzeugeAussehen() {
		
		char [] aussehen = new char[getTotalSize()];
		
		aussehen[0] = '*';
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
