//for complexity of Modular Exponentiation, use BigIntegers.  
//Make sure to use our own version of modular exponentiation.

import java.math.*;
import java.util.*;

public class ModExComplexity{
	public static void main(String[]args){
		for(int i=256; i<500; i*=2){
			long[] time = new long[10000];
			for(int j=0; j<10; j++){	
				int a = (int)(Math.random()*9+2);
				Random rand = new Random();
				BigInteger b = new BigInteger("12345");
				//BigInteger b = new BigInteger(i,5,rand);
				int n = (int)(Math.random()*i+i);
				long startTime = System.nanoTime();
				System.out.println(a);
				System.out.println(b);
				System.out.println(n);
				System.out.println(modexp(a,b,n));
				time[j] = System.nanoTime() - startTime;
			}
			long output=0;
			for(int j=0; j<10000; j++){
				output += time[j];
			}
			System.out.println(output/10000);
		}
	}
	
	public static int modexp(int a, BigInteger b, int n){
		int d = 1;
		byte[] bin = b.toByteArray();
		for(int i=0; i<bin.length; i++){
			d = (d*d) % n;
			if(bin[i] == '1'){
				d = (d*a)%n;
			}
		}
		return d;
	}
}
