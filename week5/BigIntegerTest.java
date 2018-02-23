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
		BigInteger a;
		BigInteger b;
		BigInteger n;

		p = randomPrime(1024);
		a = randomPrime(1024);
		b = randomPrime(1024);
		n = randomPrime(1024);	
		
		System.out.println("BEGIN TESTING\n--------------------");
		System.out.println("A+B = "+a.add(b));
		System.out.println("A*B = "+multiply(a,b));
		System.out.println("Bitlength of n = "+n.bitLength());
		int comparator = a.compareTo(b);
		if(comparator == -1){
			System.out.println("A is less than B");
		} else if (comparator == 0){
			System.out.println("A == B");
		} else {
			System.out.println("A is greater than B");
		}
		System.out.println("A/B = "+a.divide(b));
		System.out.println("gcd(a,b)"+a.gcd(b));
		System.out.println("Is probably prime.  Expected 1. :: "+p.isProbablePrime(100));
		System.out.println("A mod n == "+a.mod(n));
		System.out.println("A^-1 mod p == "+a.modInverse(p));
		System.out.println("A^b mod n == "+a.modPow(b,n));
		System.out.println("A*B mod n == "+multiply(a,b).mod(n));
		System.out.println("Next prime after p is "+p.nextProbablePrime());
		Random rand = new Random();
		BigInteger q = new BigInteger("1");
		q = q.probablePrime(1024,rand);
		System.out.println("Is q probably prime? "+q.isProbablePrime(100));
		System.out.println("q == "+q);
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
