public class StringsAddieren {

	public static void main(String[] args) {

		addieren();

	}

	public static void addieren() {

		String string1;
		String string2;
		
		string1 = "123456";
		string2 = "24";

		string1.length();
		string2.length();
		System.out.println(string1.length());
		System.out.println(string2.length());
		

		while (string1.length() > string2.length()) {
			string2 = "0" + string2;
		System.out.println(string2);	
		}
		
		
	}
}
