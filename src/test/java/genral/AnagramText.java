package genral;

import java.util.Arrays;
import java.util.Collections;

public class AnagramText {
	
	public static void main(String[] args) {
		
		String a ="RAMAN";
		String b = "AMARA";
		
		a.toLowerCase();
		b.toLowerCase();
		
		
		if(a.length()==b.length()) {
			
			char[] One = a.toCharArray();
			char[] Two = b.toCharArray();
			
			Arrays.sort(One);
			Arrays.sort(Two);
			
			
			boolean result = Arrays.equals(One, Two);
			
			if(result) {
				System.out.println("anagrame");
			}else {
				System.out.println("not a anagrame");
			}
		}else {
			System.out.println("not a anagram");
		}
	}
	
	
	

}
