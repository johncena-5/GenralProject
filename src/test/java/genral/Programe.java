package genral;

public class Programe {

	public static void main(String[] args) {

		int a[] = { 1, 2, 3 };

		int b[] = new int[a.length];
		int k = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {

				b[k] = a[i] + a[j];
				k++;
			}
		}
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
	}
}
