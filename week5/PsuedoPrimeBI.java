//FermatTest: Test anything from 2 through p-1 and if modexp == 1 then it's prime.
//This is a much more inexpensive test
//Used for numbers of 300 digits or more.
//If a number passes here, then we apply an even stronger test.

import java.util.*;
import java.math.*;
import java.lang.*;

public class PsuedoPrimeBI{
	static BigInteger listSize = new BigInteger("100000000");
	public static void main(String[]args){
		ArrayList<BigInteger> p = primeList(listSize);
		TreeSet<BigInteger> primes = new TreeSet<BigInteger>(p);
		BigInteger count = BigInteger.ZERO;
		BigInteger two = BigInteger.ONE.add(BigInteger.ONE);
		
		//Show that if 2^(n-1) mod n is not 1, then n is always composite.
		BigInteger n = new BigInteger("3");
		while(!(n.compareTo(listSize)==1)){
			if(!(BigInteger.ONE.compareTo(modexp(two,n.subtract(BigInteger.ONE),n)) == 0)){
				if(primes.contains(n)){
					count = count.add(BigInteger.ONE);
				}
			}
			n = n.add(BigInteger.ONE);
		}
		
		System.out.println("List size == "+listSize);
		System.out.println("If 2^(n-1) doesn't equal 1 mod n,");
		System.out.println("then n is prime exactly "+count+" times");
		
		//If 2^(n-1) mod n is equal to 1, then n is usually prime.  How often??
		BigInteger notPrime = BigInteger.ZERO;
		BigInteger isPrime = BigInteger.ZERO;
		BigInteger m = new BigInteger("3");
		while(!(m.compareTo(listSize)==1)){
			if(BigInteger.ONE.compareTo(modexp(two,m.subtract(BigInteger.ONE),m)) == 0){
				if(primes.contains(m)){
					isPrime = isPrime.add(BigInteger.ONE);
				}
				else{
					notPrime = notPrime.add(BigInteger.ONE);
				}
			}
			m = m.add(BigInteger.ONE);
		}
		
		BigDecimal BDisPrime = new BigDecimal(isPrime);
		BigDecimal BDnotPrime = new BigDecimal(notPrime);
		BigDecimal BDPrimeSize = new BigDecimal(primes.size());

		System.out.println("Ratio of being prime is: "+BDisPrime.divide(BDPrimeSize,10,RoundingMode.HALF_UP));
		System.out.println("Ratio of not being prime is "+BDnotPrime.divide(BDPrimeSize,10,RoundingMode.HALF_UP));
	}
	
	public static BigInteger modexp(BigInteger a, BigInteger b, BigInteger n){
		BigInteger d = BigInteger.ONE;
		String bin = b.toString(2);
		//String bin = Integer.toBinaryString(b);
		for(int i=0; i<bin.length(); i++){
			d = d.multiply(d);
			d = d.mod(n);
			if(bin.charAt(i) == '1'){
				d = d.multiply(a);
				d = d.mod(n);
				//d = (d*a)%n;
			}
		}
		return d;
	}
	
	//Converting BigInteger to Int is necessary for this to run.  Risks loosing information.
	public static ArrayList<BigInteger> primeList(BigInteger n){
		BitSet sieve = new BitSet(n.intValue());
		ArrayList<BigInteger> primes = new ArrayList<BigInteger>();
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
				Integer out = new Integer(i);
				primes.add(new BigInteger(out.toString()));
			}
		}
		return primes;
	}
}
