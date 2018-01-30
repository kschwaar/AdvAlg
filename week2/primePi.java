//Eratosthenes Sieve
//Best way to do this in Java is to use a bitset.
//Bitset is just an array of bits.  Index of bit corresponds to integer.
//Ignore the first two bits.  The rest are what we care about.
//In the beginning, nothing is crossed out.  This refers to them as being prime.
//If we switch to a 1, then it's NOT prime.

import java.util.*;
import java.lang.System;

public class primePi{
	public static void main(String[]args){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter an integer.  Enter -1 to quit.");
		int x = input.nextInt();
		while(x!=-1){
			long startTime = System.nanoTime();
			for(int i=0; i<1000; i++){
				primePi(x);
			}
			long endTime = (System.nanoTime() - startTime)/1000;
			System.out.println(x+"\t"+endTime);
			System.out.println("Enter an integer.  Enter -1 to quit.");
			x=input.nextInt();
		}
	}
	
	public static int primePi(int input){
		BitSet sieve = new BitSet(input);
		ArrayList<Integer> primes = new ArrayList<Integer>();
		int size = sieve.size();
		int last = (int)Math.sqrt(size)+1;
		//Initialize the bitset//
		sieve.set(0,2,false);
		sieve.set(2,size,true);
		//Now is the sieving
		for(int i=2; i<=last; i++){
			if(sieve.get(i)){
				for(int j=2*i; j<size; j+=i){
					sieve.set(j,false);
				}
			}
		}
		int output = 0;
		for(int i=1; i<=input; i++){
			if(sieve.get(i)){
				output++;
			}
		}
		return output;
	}
}
			
