package genral;

import java.util.HashMap;
import java.util.Map;

public class Abc {

	public static void main(String[] args) {

		int a = 123412;
		Map<Integer,Integer> map = new HashMap<>();
		while (a > 0) {
			int digit = a % 10;
			if(map.containsKey(digit)) {
				map.put(digit, map.get(digit)+1);
			}
			else {
				map.put(digit, 1);
			}
			a=a/10;
		}
		
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			
			if(entry.getValue()>1) {
				System.out.println(entry.getKey()+"="+entry.getValue());
			}
		}
	}
}
