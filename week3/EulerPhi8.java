import java.math.*;
import java.util.*;

public class EulerPhi8{
	public static void main(String[]args){
		ArrayList<Integer> primes = new ArrayList<Integer>();
		ArrayList<Integer> nons = new ArrayList<Integer>();
		for(int n=2; n<=1000; n++){
			int mod = modexp(2,n-1,n);
			if(mod==1){
				primes.add(n);
			}
			else{
				nons.add(n);
			}
		}
		System.out.println("There are "+nons.size()+" non-primes detected between 2 and 1000");
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
	
	public static int phi(int n){
		double output = n;
		for(int i=2; i*i<=n; i++){
			if(n%i==0){
				while(n%i==0){
					n/=i;
				}
				output *= (1.0 - (1.0 / i));
			}
		}
		if(n>1){
			output *= (1.0 - (1.0/n));
		}
		return (int)output;
	}
}
