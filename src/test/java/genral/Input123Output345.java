package genral;

public class Input123Output345 {

	public static void main(String[] args) {
		
		int[] a= {1,2,3};
		int sum=0;
		int b[]=new int [a.length];
		for(int i=0;i<a.length;i++) {
			for(int j=i+1;j<a.length;j++) {
				
				sum = a[i]+a[j];
				b[i]=sum;
				System.out.println(b[i]);
				
			}	
		}
	}
}
