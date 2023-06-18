package genral;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class IgnoreTest {
	
	
	public static void main(String[] args) {
		
		String s="Welcome to banglore to delhi to delhi";
		String[] s2 = s.split(" ");
		LinkedHashSet<String> set = new LinkedHashSet<>();
		int count=0;
		for(int i=0;i<s2.length;i++) {
			
			set.add(s2[i]);
		}
		
		for (String str : set) {
			for(int i=0;i<s2.length;i++) {
				if(str==s2[i]) {
					System.out.println("order of occurance "+str+" "+i);
					
				}
			}
		}
		System.out.println("duplicate number "+(s2.length-set.size()));
	}

}
