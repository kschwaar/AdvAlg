//FermatTest: Test anything from 1 through p-1 and if modexp == 1 then it's prime.
//This is a much more inexpensive test
//Used for numbers of 300 digits or more.
//If a number passes here, then we apply an even stronger test.

import java.util.*;
import java.math.*;
import java.lang.*;

public class PsuedoPrime{
	static long listSize = 1000000;
	public static void main(String[]args){
		ArrayList<Integer> p = primeList(listSize);
		TreeSet<Integer> primes = new TreeSet<Integer>(p);
		long count;
		
		//Show that if 2^(n-1) mod n is not 1, then n is always composite.
		count = 0;
		for(long n=3; n<=listSize; n++){
			if(!(modexp(2,n-1,n) == 1)){
				if(primes.contains((int)n)){
					++count;
				}
			}
		}
		
		System.out.println("If 2^(n-1) doesn't equal 1 mod n,");
		System.out.println("then n is prime exactly "+count+" times");
		
		//If 2^(n-1) mod n is equal to 1, then n is usually prime.  How often??
		count=0;
		for(long n=3; n<=listSize; n++){
			if(modexp(2,n-1,n)==1){
				if((primes.contains((int)n))){
					++count;
				}
			}
		}
		System.out.println(count + " false positives.");
		
		
		System.out.println("This is a probability of "+(double)count/primes.size());

	}
	
	public static long modexp(long a, long b, long n){
		long d = 1;
		String bin = Integer.toBinaryString((int)b);
		for(int i=0; i<bin.length(); i++){
			d = (d*d) % n;
			if(bin.charAt(i) == '1'){
				d = (d*a)%n;
			}
		}
		return d;
	}

	public static ArrayList<Integer> primeList(long n){
		BitSet sieve = new BitSet((int)n);
		ArrayList<Integer> primes = new ArrayList<Integer>();
		int size = sieve.size();
		long last = (long)Math.sqrt(size);
		
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
		return primes;
	}
}
