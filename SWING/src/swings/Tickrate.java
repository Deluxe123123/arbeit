package swings;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Tickrate {
	
	int zeit=10;
	private Spaceinvaders animationObjekt;
	private Timer timerObjekt;
	
	public Tickrate(Spaceinvaders verzögerter){
		this.animationObjekt = verzögerter;
	}
	
	
	public void verzögerung(){
			
		timerObjekt = new Timer(zeit, new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			animationObjekt.ticker();
		}
	});
	timerObjekt.start();
	}
	}
	
	

