//The BigInteger methods are object-methods, not static methods.
//We want static methods?

import java.math.*;
import java.util.*;

public class RSA{
	public static void main(String[]args){
		String s = fileToString(args[0]);
		ArrayList<String> stringBlocks = toStringBlocks(s);
		ArrayList<BigInteger> plainText = toBigIntBlocks(stringBlocks);
		BigInteger one = BigInteger.ONE;
		BigInteger p;
		BigInteger q;
		BigInteger n;
		BigInteger phi_of_n;
		BigInteger e; // use 65537.  Make sure you check that this is co-prime to phi_of_n;  If not, get next prime.
		BigInteger d; // The inverse of e mod phi_of_n;
		ArrayList<BigInteger> cypheredText = encrypt(plainText);
		//Print out the encrypt text???
		ArrayList<BigInteger> decypheredText = decrypt(cypheredText);
		ArrayList<String> decToStringBlocks = decToStringBlocks(decypheredText);
		stringBlocksToFile(decToStringBlocks);
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
		
		phi_of_n = multiply(p.subtract(one),q.subtract(one));
		System.out.println("Phi(n) = "+phi_of_n);
		e = new BigInteger("65537");
		System.out.println("Coprime? True if 1. :"+gcd(e,phi_of_n));
		d = inverse(e,phi_of_n);
		System.out.println("d = "+d);
		System.out.println("Test inverse: "+multiply(d,e).mod(phi_of_n));
		//Our public key is (e,n)
		//Our private keys are (d, phi(n));
		
		
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
	
	public static BigInteger gcd(BigInteger in1, BigInteger in2){
		return in1.gcd(in2);
	}
	
	public static BigInteger inverse(BigInteger in1, BigInteger in2){
		return in1.modInverse(in2);
	}
}
