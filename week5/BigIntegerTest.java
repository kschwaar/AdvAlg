//The BigInteger methods are object-methods, not static methods.
//We want static methods?

import java.math.*;
import java.util.*;

public class BigIntegerTest{
	public static void main(String[]args){
		BigInteger one = BigInteger.ONE;
		BigInteger zero = BigInteger.ZERO;
		BigInteger ten = BigInteger.TEN;
		
		BigInteger p;
		BigInteger q;
		BigInteger n;
		BigInteger phi_of_n;
		BigInteger e;
		BigInteger d;
		
		/*
		System.out.println(randomInteger(300));
		System.out.println(randomPrime(300));
		System.out.println(subToPrime(300));
		*/
		
		p = randomPrime(300);
		q = randomPrime(300);
		n = multiply(p,q);
		
		System.out.println(n);
		System.out.println("The bit length of n is: "+n.bitLength());
		String nString = n.toString();
		System.out.println(nString.length());
	}
	
	//Returns a random BigInteger 'digits' long.
	//We're converting from Java's base 2.
	public static BigInteger randomInteger(int digits){
		Random rand = new Random();
		int len = (int)(3.32*(double)digits);
		return new BigInteger(len,100,rand);
	}
	
	//Return a random prime approx. n digits long
	public static BigInteger randomPrime(int digits){
		BigInteger p = randomInteger(digits);
		return p.nextProbablePrime();
	}
	
	public static BigInteger subToPrime(int digits){
		BigInteger p = randomInteger(digits);
		return p.nextProbablePrime().subtract(p);
	}
	
	public static BigInteger multiply(BigInteger in1, BigInteger in2){
		return in1.multiply(in2);
	}
}
