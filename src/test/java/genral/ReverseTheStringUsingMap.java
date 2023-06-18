package genral;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ReverseTheStringUsingMap {

	public static void main(String[] args) {

		String s = "java";

		LinkedHashMap<Integer, Character> map = new LinkedHashMap<>();
		for (int i = s.length() - 1; i >= 0; i--) {

			map.put(i, s.charAt(i));

		}
		for (Map.Entry<Integer, Character> entry : map.entrySet()) {
			System.out.print(entry.getValue());

		}
	}
}
