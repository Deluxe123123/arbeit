import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;


public class AnimierteZeichnen {
	
	static int l�nge = 50;
	
	static int dauer1 = 500;
	static int dauer2 = 1000;
	static int dauer3 = 2000;

	static char inhalt1 = '|';
	static char inhalt2 = '/';
	static char inhalt3 = '-';
	static char inhalt4 = '\\';
	
	static String zeichenkette1;
	static String zeichenkette2;
	static String zeichenkette3;
	static String zeichenkette4;
	
	public static void main(String[] args) {
		
		
		
	zeichenkette1 =	stringauff�ller(inhalt1, l�nge);
	zeichenkette2 =	stringauff�ller(inhalt2, l�nge);	
	zeichenkette3 =	stringauff�ller(inhalt3, l�nge);	
	zeichenkette4 =	stringauff�ller(inhalt4, l�nge);	
	
	System.out.print(zeichenkette1);
	System.out.print(zeichenkette2);
	System.out.print("\r" + zeichenkette3);
	
	
	
	//anzeige(dauer1, dauer2, dauer3);
	
	}

	
	public static String  stringauff�ller (char inhalt, int l�nge) {
		
		char[] tempCArray = new char[l�nge];
		Arrays.fill(tempCArray, inhalt);
		String zeichenkette = new String(tempCArray);
		
		return zeichenkette;
	
	}
	
//	public static void anzeige(int dauer, int dauer2, int dauer3) {
//		
//		
//		
//		Timer zeitz�hler = new Timer();
//		
//		TimerTask aufgabe1 = new TimerTask() {
//
//			public void run() {
//				
//				System.out.println(zeichenkette1 +"\r");
//			
//			}
//			
//		};
//		
//		TimerTask aufgabe2 = new TimerTask() {
//
//			public void run() {
//				
//				System.out.println(zeichenkette2 +"\r");
//			
//			}
//			
//		};
//		
//		TimerTask aufgabe3 = new TimerTask() {
//
//			public void run() {
//				
//				System.out.println(zeichenkette3 +"\r");
//			
//			}
//			
//		};
//		zeitz�hler.schedule(aufgabe1 ,dauer1);
//		zeitz�hler.schedule(aufgabe2 ,dauer2);
//		zeitz�hler.schedule(aufgabe3 ,dauer3);
//	}
	
	
	
}













