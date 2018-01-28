//

import java.math.*;
import java.util.*;


public class euclidComplexity {

	public static void main(String[]args){
		int[] average = new int[50];
		for(int j=1; j<=500; j++){
			long[] time = new long[10000]; 
			for(int i=0; i<10000; i++){
				Random rand = new Random();
				BigInteger n = new BigInteger(j,rand);
				BigInteger m = new BigInteger(j,rand);
				long startTime = System.nanoTime();
				gcd(n,m);
				time[i] = System.nanoTime() - startTime;
			}
			long output=0;
			for(int i=0; i<10000; i++){
				output += time[i];
			}
			System.out.println(output/10000);
			//System.out.println(output);
		}
	}
	
	public static BigInteger gcd(BigInteger n, BigInteger m) {
		if(m.compareTo(BigInteger.ZERO)==0){
			return n;
		}
		else{
			return gcd(m,n.mod(m));
		}
	}
}
