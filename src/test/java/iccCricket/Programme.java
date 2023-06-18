package iccCricket;

public class Programme {

	public static void main(String[] args) {

		String s = "i love my india";// a idni evoli

		String s2 = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ') {
				s2 = s.charAt(i) + s2;
			}
		}

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				s2 = s2.substring(0, i) + " " + s2.substring(i);
			}
		}
		System.out.print(s2);
	}
}
