import java.lang.System;
import java.math.*;
public class slowExp{
	public static void main(String[]args){
		BigInteger a = new BigInteger("123456789");
		BigInteger prod = BigInteger.ONE;
		BigInteger m = new BigInteger("987654321");
		BigInteger b = new BigInteger("12345678901");
		BigInteger i = BigInteger.ONE;
		long start = System.nanoTime();
		while(i.compareTo(b)<1){
			prod = prod.multiply(a);
			prod = prod.mod(m);			
			i=i.add(BigInteger.ONE);
		}
		//System.out.println(prod);
		long total = System.nanoTime() - start;
		System.out.println("This took "+total+" nanoseconds");
		System.out.println((total/1000000000)+" seconds");
		System.out.println("Base = "+a);
		System.out.println("Power = "+b);
		System.out.println("Modulus = "+m);
	}
}

//Complexity of this is bad.  It's linear with the exponent.  so this is O(b) for this specific example.
