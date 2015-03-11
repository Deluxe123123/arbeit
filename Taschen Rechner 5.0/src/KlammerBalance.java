import java.util.Stack;


public class KlammerBalance {
	private static final char L_RRUNDEKLAMMER    = '(';
    private static final char R_RUNDEKLAMMER    = ')';
    private static final char L_GESCHWEIFTEKLAMMER    = '{';
    private static final char R_GESCHWEIFTEKLAMMER    = '}';
    private static final char L_ECKIGEKLAMMER  = '[';
    private static final char R_ECKIGEKLAMMER  = ']';

    public static boolean istBalanciert(String s) {													//prüft ob die klammern in balance stehen
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {

            if      (s.charAt(i) == L_RRUNDEKLAMMER)   stack.push(L_RRUNDEKLAMMER);        		     //fügt dem stack eine Linke Runde-Klammer hinzu

            else if (s.charAt(i) == L_GESCHWEIFTEKLAMMER)   stack.push(L_GESCHWEIFTEKLAMMER);		 //fügt dem stack eine Linke Geschweifte-Klammer hinzu

            else if (s.charAt(i) == L_ECKIGEKLAMMER) stack.push(L_ECKIGEKLAMMER);					 //fügt dem stack eine Linke Eckige-Klammer hinzu

            else if (s.charAt(i) == R_RUNDEKLAMMER) {												 //überprüft ob der stack leer ist oder als letztes 
                if (stack.isEmpty())        return false;											 //eine nicht passende klammer eingegeben wurde
                if (stack.pop() != L_RRUNDEKLAMMER) return false;
            }

            else if (s.charAt(i) == R_GESCHWEIFTEKLAMMER) {											 //überprüft ob der stack leer ist oder als letztes
                if (stack.isEmpty())        return false;											 //eine nicht passende klammer eingegeben wurde
                if (stack.pop() != L_GESCHWEIFTEKLAMMER) return false;
            }

            else if (s.charAt(i) == R_ECKIGEKLAMMER) {												 //überprüft ob der stack leer ist oder als letztes
                if (stack.isEmpty())        return false;											 //eine nicht passende klammer eingegeben wurde
                if (stack.pop() != L_ECKIGEKLAMMER) return false;
            }
           
        }
        return stack.isEmpty();																		 //gibt zurück dass keine klammern eingegeben worden sind
    }

}
