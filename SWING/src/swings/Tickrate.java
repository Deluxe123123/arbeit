package swings;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Tickrate {
	
	int zeit=10;
	private Spaceinvaders animationObjekt;
	private Timer timerObjekt;
	
	public Tickrate(Spaceinvaders verz�gerter){
		this.animationObjekt = verz�gerter;
	}
	
	
	public void verz�gerung(){
			
		timerObjekt = new Timer(zeit, new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			animationObjekt.ticker();
		}
	});
	timerObjekt.start();
	}
	}
	
	

