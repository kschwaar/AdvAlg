//FermatTest: Test anything from 1 through p-1 and if modexp == 1 then it's prime.
import java.util.Scanner;

public class FermatTest{
	public static void main(String[]args){
		System.out.println("Input an integer");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt()-1;
		int m = n+1;
		int x, y;
		
		for(int i=1; i<n; i++){
			x=modexp(i,n-1,m);
			System.out.println(i + "\t" + x);
		}

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
}
