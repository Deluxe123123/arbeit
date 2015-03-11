import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
 
public class Calculator extends KlammerBalance 
{
   public static String eingabe;
   public static double result;
   public static boolean klammerzu;
   
	
	public static void main(String[] args) 
   {	   
		

		eingabeScanner();
			

		List<Operation> eingabeList = new ArrayList<Operation>(); 				                // erstellt ein Liste in der man Objekte speichern kann
	
		parseString(eingabeList, eingabe);
		
		double ergebnis = rechnen(eingabeList);											    	// speichert das ergebnis in ausgabevariable

	
		System.out.println("Das war Ihre eingabe: "+ eingabe);					       	    // gibt nur wieder das aus was man eingegeben hat
		System.out.println("Das ist das Ergebnis: "+ ergebnis);					       	    // gibt das ergebnis aus
        
		
		
   }
	
	
	public static String eingabeScanner(){
		
		Scanner lauscher = new Scanner(System.in); 								    	    // Ein neues Scanner-Objekt erstellen
	    
		eingabe = lauscher.nextLine();										          	    // Funktion die es erlaubt eine Eingabe zu machen
		
		eingabe = eingabe.replaceAll("\\s+","");								    	    // entfernt die Leerzeichen in der Eingabe
																				
		
		if(istBalanciert(eingabe)) {
			
			System.out.println("Stehen die Klammern in Balance: JA!\n");					// gibt an ob die klammern in balance stehen		
		    lauscher.close();																// schlieﬂt den Scanner
		    
		}else {
			
			System.out.println("Stehen die Klammern in Balance: NEIN bitte setze deine Klammern richtig - Neuer Versuch!\n");
			
			eingabeScanner();
		}
		
		
		
		System.out.println("Eingabe: " + eingabe); 
		
		return eingabe;
		
	}
	

	public static Operation createOperation(String tempOperant, String tempZahlenWert, List<Operation> tempAbzweigung)	
	{
		if (/*tempOperant == null ||
				tempOperant.length() == 0 ||*/
				((tempZahlenWert == null ||
					tempZahlenWert.length() == 0) &&
					tempAbzweigung.size() == 0))
			return null;

		Operation operationsInstanz = new Operation();
		operationsInstanz.operant = tempOperant;
		operationsInstanz.zahlenwert = tempZahlenWert != null && tempZahlenWert.length() > 0 ? Double.parseDouble(tempZahlenWert) : 0;
		operationsInstanz.abzweigung = tempAbzweigung;
		
		return operationsInstanz;
	}
	
	public static String parseString(List<Operation> tempEingabeList, String tempEingabe)
	{		
		String tempOperant = "";
		String tempZahlenWert = "";
		List<Operation> tempAbzweigung = new ArrayList<Operation>();
		int i = 0;
		
		stringWalker:
		for (; i < tempEingabe.length(); i++)
		{
			char eingabeInhalt = tempEingabe.charAt(i);
			switch (eingabeInhalt)
			{
			
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
					tempZahlenWert += eingabeInhalt;
					break;
					
				case '+':
				case '-':
				case '*':
				case '/':
								
					Operation objekt = createOperation(tempOperant, tempZahlenWert, tempAbzweigung);
					if (objekt != null)
						tempEingabeList.add(objekt);
					tempOperant = String.valueOf(eingabeInhalt);
					tempZahlenWert = "";
					tempAbzweigung = new ArrayList<Operation>();				
					break;
					
				case '(':		
					tempEingabe = parseString(tempAbzweigung, tempEingabe.substring(i+1));
					i = -1;		
					break;
					
				case ')':
					i++;
					break stringWalker;
				
				
			}
		}
		
		Operation objekt = createOperation(tempOperant, tempZahlenWert, tempAbzweigung);
		if (objekt != null)
			tempEingabeList.add(objekt);
		
		return tempEingabe.length() > i ? tempEingabe.substring(i) : "";
	}
	
	public static double rechnen(List<Operation> tempEingabeList)
	{
		
		double summe = 0;
		double v;
		
		
		for (int i = 0; i < tempEingabeList.size(); ++i) {

			Operation finalOperation = tempEingabeList.get(i);
	
			System.out.println(i + ".te " + "Instanz:\n");
			System.out.println("Zahl: " + finalOperation.zahlenwert);
			System.out.println("Operant: " + finalOperation.operant);

			if (finalOperation.abzweigung != null && finalOperation.abzweigung.size() > 0) {
				
				System.out.println("Die Instanz hat eine Abzweigung.\n\n\n");

				v = rechnen(finalOperation.abzweigung);

			} else {
			
				
				System.out.println("Die Instanz hat keine! Abzweigung.\n\n\n");
				
				v = finalOperation.zahlenwert;
			
			}

						
				switch (finalOperation.operant) {

				case "+":
					summe += v;
					System.out.println("TempErgebnis: " + summe + "\n");
					break;
					
				case "-":
					summe -= v;
					System.out.println("TempErgebnis: " + summe + "\n");
					break;
					
				case "*":
					summe *= v;
					System.out.println("TempErgebnis: " + summe + "\n");
					break;
					
				case "/":
					summe /= v;
					System.out.println("TempErgebnis: " + summe + "\n");
					break;
				
				default :	
					if (i == 0)					
						summe = v;
					break;
				}

					
		}
			
		

		return summe;
	}


}

