

public class modularExp{
	public static void main(String[]args){
		int a = 7;
		int b = 12345;
		int n = 392;
		System.out.println(a + "^" + b + " mod " + n + " = ");
		System.out.println(modexp(a,b,n));
	}
	
	public static int modexp(int a, int b, int n){
		int d = 1;
		String bin = Integer.toBinaryString(b);
		for(int i=0; i<bin.length(); i++){
			d = (d*d) % n;
			if(bin.charAt(i) == '1'){
				d = (d*a)%n;
			}
		}
		return d;
	}
}

//Much better complexity O(log(n))
