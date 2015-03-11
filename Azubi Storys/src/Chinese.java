import java.util.Scanner;

public class Chinese {

	static StringBuilder stringpott;
	static StringBuilder stringpott2;

	static final char buchstabea = 'a';
	static final char buchstabee = 'e';
	static final char buchstabei = 'i';
	static final char buchstabeo = 'o';
	static final char buchstabeu = 'u';
	static final char buchstabel = 'l';
	static final char buchstaber = 'r';
	

	public static void main(String[] args) {

		speekLikeAChinese();
		vokale();

	}

	public static void speekLikeAChinese() {

		Scanner laser = new Scanner(System.in);
		String eingabe = laser.nextLine();

		stringpott = new StringBuilder(eingabe);

		for (int i = 0; i < eingabe.length(); i++) {

			char treffer = eingabe.charAt(i);
			if (buchstaber == treffer) {

				stringpott.setCharAt(i, buchstabel);

				eingabe = stringpott.toString();

			}

		}
		System.out.println(eingabe);
	}

	public static void vokale() {

		
		Scanner laser2 = new Scanner(System.in);
		String eingabe2 = laser2.nextLine();
		String lower = eingabe2.toLowerCase();
		stringpott2 = new StringBuilder();		
			for (int i = 0; i < lower.length(); ++i) {
			char currentChar = lower.charAt(i);

			switch (currentChar) {
				case buchstabea:
				case buchstabee:
				case buchstabei:
				case buchstabeo:
				case buchstabeu:
					break;
					
				default:
					stringpott2.append(eingabe2.charAt(i));
					break;
			}
		}
		
		System.out.println(stringpott2);
	}

}
