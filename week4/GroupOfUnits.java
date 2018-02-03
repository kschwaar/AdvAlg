//Here's an group of units class.  Use this for homework for week3 and week4.
//When computing with integers, never use Math.power or anything that computes doubles.
//Always do integer arithmetic.
//This is to get infinite precision and avoid any sort of rounding errors.
//Avoid Math class, not the java.math.* class.  java.math.* is fine.
//The order or an element must divide the order of the group.
//a^(phi(n)) === 1 mod n  -> euler's theorem


import java.math.*;
import java.util.*;

public class GroupOfUnits{
	public static void main(String[]args){
		int n = 81;
		int size;
		int element;
		int inv;
		int ord;
		ArrayList<Integer> units = new ArrayList<Integer>();
		ArrayList<Integer> roots = new ArrayList<Integer>();
		for(int i=1; i<n; i++){
			if(gcd(i,n)==1){
				units.add(i);
			}
		}
		size = units.size();
		System.out.println("The group of units modulo "+n+" has "+size+" elements in it.");
		System.out.println("Therefore the order of the group is: ");
		System.out.println("The elements are: ");
		System.out.println(units);
		
		Iterator<Integer> it = units.iterator();
		while(it.hasNext()){
			element = it.next();
			ord = order(element,n);
			inv = inverse(element,n);
			System.out.println("Element = "+element+" ");
			System.out.println("Order of Element "+element+" is "+ord);
			System.out.println("Inverse of Element "+element+" is "+inv);
			if(ord==size){
				roots.add(element);
			}
			System.out.println("test: "+(inverse(element,n)*element % n));
		}
		System.out.println();
		System.out.println(roots);
		
		//One concise way of talking about the group of primitive roots is
		//to say that it consists of the powers of 2 mod 81.
		//We did this same kind of thing with cyclic graphs and cycle diagrams.
		
	}
	
	public static int gcd(int n, int m){
		if(m==0){
			return n;
		}
		else{
			return gcd(m, n%m);
		}
	}
	
	public static int order(int n, int m){
		int count = 0;
		int power = 1;
		for(int i=1; i<m; i++){
			++count;
			power = (power*n)%m;
			if(power==1){
				return count;
			}
		}
		return -1;
	}
	
	public static int inverse(int n, int m){
		int ord = order(n,m);
		int inv = 1;
		for(int i=1; i<ord; i++){
			inv = (inv*n)%m;
		}
		return inv;
	}
}
