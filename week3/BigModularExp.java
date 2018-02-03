import java.math.*;
import java.util.Random;

public class BigModularExp{
	public static void main(String[]args){
		for(int i=1; i<=5; i++){
			Random rand = new Random();
			BigInteger base = new BigInteger(1024,10,rand);
			BigInteger exponent = new BigInteger(1024,10,rand);
			BigInteger modular = new BigInteger(1024,10,rand);
			
			//System.out.println(a + "^" + b + " mod " + n + " = ");
			long start = System.nanoTime();
			System.out.println(modexp(base,exponent,modular));
			long endTime = System.nanoTime() - start;
			System.out.println("This took "+endTime+" nanoseconds");
		}
	}
	
	public static BigInteger modexp(BigInteger a, BigInteger b, BigInteger n){
		BigInteger d = BigInteger.ONE;
		String bin = b.toString(2);
		//String bin = Integer.toBinaryString(b);
		for(int i=0; i<bin.length(); i++){
			d = d.multiply(d);
			d = d.mod(n);
			if(bin.charAt(i) == '1'){
				d = d.multiply(a);
				d = d.mod(n);
				//d = (d*a)%n;
			}
		}
		return d;
	}
}
