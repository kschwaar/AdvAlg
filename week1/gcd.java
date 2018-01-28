import java.util.*;
import java.lang.Integer;
import java.lang.Math;

public class gcd {

	public static void main(String[]args){
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		int m = input.nextInt();
		System.out.println(euclid(n,m));
	}
	
	public static int euclid(int n, int m) {
		if(m==0){
			return n;
		}
		else{
			return euclid(m,n%m);
		}
	}
}
