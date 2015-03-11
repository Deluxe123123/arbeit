import java.util.Scanner;

public class Palindrom {

	public static String eingabe;
	public static String eingabeReverse;
	public static char[] modEingabe;
	public static char[] modEingabeReverse;
	public static boolean isPalindrom;
	public static void main(String[] args) {
	

	eingabeScanner();	
	isPalindromSpaceIrrelevant();
	isPalindromCaseInsensitiv();
	isPalindrom();	
	System.out.println(isPalindrom);	
		
	
	}

	
	public static String eingabeScanner(){
		
		Scanner consolenScanner = new Scanner(System.in);
		
		eingabe = consolenScanner.nextLine();
		
		consolenScanner.close();	
		
		return eingabe;
	
	}
	
	public static String isPalindromSpaceIrrelevant(){
		
		eingabe = eingabe.replaceAll("\\s+","");
		
		return eingabe;
		
	}

	public static char[] isPalindromCaseInsensitiv() {
		
		modEingabe = new char[eingabe.length()];
		
		modEingabe = eingabe.toCharArray();
		
		for (int i = 0; i < eingabe.length(); i++) {
			
			int asciinummer = (int)modEingabe[i];
			
			
			if(65 <= asciinummer && asciinummer <= 90) {
			
				asciinummer += 32;	
				modEingabe[i] = (char)asciinummer;		
				System.out.println("geändert von groß auf klein: " + modEingabe[i]);
			}
			
		}
		eingabe = String.valueOf(modEingabe);
	
		return modEingabe;
	}
	
	public static boolean isPalindrom() {
		
		
		modEingabeReverse = new char[eingabe.length()];
			
		
		for (int i = 0, j = eingabe.length()-1; i <= j; ++i) {
			modEingabeReverse[i] = modEingabe[j-i];
		}
		
		eingabeReverse = String.valueOf(modEingabeReverse);
		
		System.out.println(eingabeReverse);
		System.out.println(eingabe);
		
		if (eingabe.equals(eingabeReverse)) {
					
		isPalindrom = true;	
			
		}else {
			
		isPalindrom = false;	
		
		}
				
		return isPalindrom;
	
	}
	
	
}
