import java.util.*;
import java.lang.System;

public class EraComplexity{
	public static void main(String[]args){
		//ADD COMPLEXITY TIMER HERE
		for(int i=1; i<=1000000; i++){
			long startTime = System.nanoTime();
			for(int j=1; j<=100; j++){
				BitSet sieve = new BitSet(i);
				ArrayList<Integer> primes = new ArrayList<Integer>();
				int size = sieve.size();
				int last = (int)Math.sqrt(size);
				//Initialize the bitset//
				sieve.set(2,size,true);
				//Now is the sieving
				for(int k=2; k<=last; k++){
					if(sieve.get(k)){
						for(int l=2*k; l<size; l+=k){
							sieve.set(l,false);
						}
					}
				}
				
				for(int k=2; k<size; k++){
					if(sieve.get(k)){
						primes.add(k);
					}
				}
			}
			long endTime = System.nanoTime() - startTime;
			endTime = endTime/100;
			System.out.println(i+"\t"+endTime);
		}
	}
}
			
