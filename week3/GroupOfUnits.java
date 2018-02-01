import java.math.*;
import java.util.*;

public class GroupOfUnits{
	public static void main(String[]args){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter an integer.  Type -1 to quit");
		int n = input.nextInt();
		while(n!=-1){
			int size;
			int element;
			ArrayList<Integer> units = new ArrayList<Integer>();
			for(int i=1; i<n; i++){
				if(gcd(i,n)==1){
					units.add(i);
				}
			}
			size = units.size();
			System.out.println("The group of units modulo "+n+" has "+size+" elements in it.");
			System.out.println("The elements are: ");
			System.out.println(units);
			
			Iterator<Integer> it = units.iterator();
			while(it.hasNext()){
				element = it.next();
				System.out.println("Element = "+element+" ");
				System.out.println("Order of Element "+element+" is "+order(element,n));
				System.out.println("Inverse of Element "+element+" is "+inverse(element,n));
			}
			System.out.println("Enter an integer.  Type -1 to quit");
			n = input.nextInt();
		}		
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
