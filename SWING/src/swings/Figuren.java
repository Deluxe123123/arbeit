package swings;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;



public abstract class Figuren {
	
	protected String name;
	protected Point position = new Point();
	protected Point size = new Point();
	protected List<char[]> aussehenVarianten = new ArrayList<char[]>();	
	protected int currentAussehenIndex = 0;
	protected char[] hitMask;
	
	
	public void resetAussehen() {
		this.currentAussehenIndex = 0;
	}
	
	public void nextAussehen() {
		this.currentAussehenIndex++;
		if (this.currentAussehenIndex >= this.aussehenVarianten.size())
			this.currentAussehenIndex = 0;
	}

	public char[] getCurrentAussehen(){
		char [] currentAussehen = this.aussehenVarianten.get(this.currentAussehenIndex);
			for (int i = 0; i < currentAussehen.length;i++) {
				if(hitMask[i] == 1) {
				currentAussehen[i] = hitMask[i];	
				}
			}
		return currentAussehen;
	}
	
	public int getSmallIndex(Point position) {
		int y = position.y;
		int x = position.x;
		int index = y * getXYSize().x + x;
		return index;
	}
	
	public Point getPosition() {
		return new Point(this.position.x, this.position.y);
	}
	
	public void setPosition(int x, int y){
		this.position.x = x;
		this.position.y = y;
	}
	
	public Point getXYSize() {
		return new Point(this.size.x, this.size.y);
	}
	
	public int getTotalSize() {
		int figurSize = this.getXYSize().y * this.getXYSize().x;
		return figurSize;
	}
	
	public void zeichnenFiguren(Fenster fenster) {
		char hitChar = ' ';
		char[] aussehen = getCurrentAussehen();
		char[] hitmask = this.hitMask;
		
		for(int i = 0; i < getTotalSize(); i++) {
			int y = getPosition().y + (i / getXYSize().x) % getXYSize().y;
			int x = getPosition().x + i % getXYSize().x;
			// todo: 80 aus fenster auslesen
			int index = y * 80 + x;
			if(aussehen[i] ==' ') {
				hitmask[i] = 1;
			}
			if (hitmask[i] == 1) {
				aussehen[i] = hitChar;
			}
			fenster.getLblList().get(index).setText("" + aussehen[i]);	
		}
	}
	
	public boolean hit(Point schussPosition) {
		if(!hitable(schussPosition)) {
			return false;
		}
		schussPosition = this.toLocalPosition(schussPosition);
		int index = getSmallIndex(schussPosition);
		hitMask[index] = 1;
		return true;
	}
	
	public boolean hitable(Point schussPosition) {
		schussPosition = this.toLocalPosition(schussPosition);
		if (!this.istPositionInnerhalbVomObjekt(schussPosition)) {
			return false;
		}
		int index = getSmallIndex(schussPosition);
		if(this.hitMask[index] == 1) {
			return false;
		}
		return true;	
	}
	
	protected Point toLocalPosition(Point position)
	{
		Point localPosition = new Point();
		localPosition.x = position.x - this.position.x;
		localPosition.y = position.y - this.position.y;
		return localPosition;
	}

	protected boolean istPositionInnerhalbVomObjekt(Point position)
	{
		if (position.x < 0 ||
			position.x >= this.size.x ||
			position.y < 0 ||
			position.y >= this.size.y) {
				return false;
		}	
		return true;
	}

	public boolean figurIstKomplettZerstört() {
		for(int i = 0; i < hitMask.length; i++) {
			if(!(hitMask[i] == 1)) {
				return false;
			}
		}
		return true;
	}

	public abstract void routeAbfahren();
}
