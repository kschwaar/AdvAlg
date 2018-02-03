import java.math.*;
import java.util.*;

public class GroupOfUnits5{
	public static void main(String[]args){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter an integer.  Type -1 to quit");
		int n = input.nextInt();
		while(n!=-1){
			int size;
			int element;
			int inv;
			int ord;
			int phi=phi(n);
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
				System.out.println(element+"^"+phi+" mod "+n+" = "+modexp(element,phi,n));
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
	
	public static int modexp(int a, int b, int n){
		int d = 1;
		String bin = Integer.toBinaryString(b);
		for(int i=0; i<bin.length(); i++){
			d = (d*d) % n;
			if(bin.charAt(i) == '1'){
				d = (d*a)%n;
			}
		}
		return d;
	}
	
	public static int phi(int n){
		double output = n;
		for(int i=2; i*i<=n; i++){
			if(n%i==0){
				while(n%i==0){
					n/=i;
				}
				output *= (1.0 - (1.0 / i));
			}
		}
		if(n>1){
			output *= (1.0 - (1.0/n));
		}
		return (int)output;
	}
}
