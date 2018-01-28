//Eratosthenes Sieve
//Best way to do this in Java is to use a bitset.
//Bitset is just an array of bits.  Index of bit corresponds to integer.
//Ignore the first two bits.  The rest are what we care about.
//In the beginning, nothing is crossed out.  This refers to them as being prime.
//If we switch to a 1, then it's NOT prime.

import java.util.*;

public class EraSieve{
	public static void main(String[]args){
		//ADD COMPLEXITY TIMER HERE
		
		BitSet sieve = new BitSet(10000000);
		ArrayList<Integer> primes = new ArrayList<Integer>();
		int size = sieve.size();
		int last = (int)Math.sqrt(size);
		
		//Initialize the bitset//
		sieve.set(2,size,true);
		//Now is the sieving
		for(int i=2; i<=last; i++){
			if(sieve.get(i)){
				for(int j=2*i; j<size; j+=i){
					sieve.set(j,false);
				}
			}
		}
		
		for(int i=2; i<size; i++){
			if(sieve.get(i)){
				primes.add(i);
			}
		}
		
		//ADD ENDING COMPLEXITY TIMER HERE.
		
		for(Integer p:primes){
			System.out.println(p);
		}
	}
}
			
