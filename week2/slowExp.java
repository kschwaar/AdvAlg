//Slow exponentiation algorithm

//Complexity is bad.

import java.math.*;
public class slowExp{
	public static void main(String[]args){
		BigInteger a = new BigInteger("1234567");
		BigInteger prod = BigInteger.ONE;
		BigInteger m = new BigInteger("12345");
		int b = 123456;
		
		for(int i=1; i<=b; i++){
			prod = prod.multiply(a);
			prod = prod.mod(m);
		}
	System.out.println(prod);
	}
}

//Complexity of this is bad.  It's linear with the exponent.  so this is O(b) for this specific example.
