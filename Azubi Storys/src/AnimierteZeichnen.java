import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;


public class AnimierteZeichnen {
	
	static int länge = 50;
	
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
		
		
		
	zeichenkette1 =	stringauffüller(inhalt1, länge);
	zeichenkette2 =	stringauffüller(inhalt2, länge);	
	zeichenkette3 =	stringauffüller(inhalt3, länge);	
	zeichenkette4 =	stringauffüller(inhalt4, länge);	
	
	System.out.print(zeichenkette1);
	System.out.print(zeichenkette2);
	System.out.print("\r" + zeichenkette3);
	
	
	
	//anzeige(dauer1, dauer2, dauer3);
	
	}

	
	public static String  stringauffüller (char inhalt, int länge) {
		
		char[] tempCArray = new char[länge];
		Arrays.fill(tempCArray, inhalt);
		String zeichenkette = new String(tempCArray);
		
		return zeichenkette;
	
	}
	
//	public static void anzeige(int dauer, int dauer2, int dauer3) {
//		
//		
//		
//		Timer zeitzähler = new Timer();
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
//		zeitzähler.schedule(aufgabe1 ,dauer1);
//		zeitzähler.schedule(aufgabe2 ,dauer2);
//		zeitzähler.schedule(aufgabe3 ,dauer3);
//	}
	
	
	
}













