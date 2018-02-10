//FermatTest: Test anything from 1 through p-1 and if modexp == 1 then it's prime.
import java.util.BitSet;
import java.util.ArrayList;

public class FermatTest{
	public static void main(String[]args){
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for(int n=5; n<=1000; n++){
			BitSet success = new BitSet(n-1);
			success.clear();
			for(int i=1; i<n; i++){
				if(modexp(i,n-1,n)==1){
					success.set(i-1);
				}
			}
			double ratio = (double)(success.cardinality()/(double)(n-1));
			//System.out.println(n + "\tRatio is:\t" + ratio);
			if(ratio>0.5 && ratio<1){
				System.out.println(n + "\tRatio is:\t" + ratio);
			}
			if(success.cardinality()/(n-1)==1){
				primes.add(n);
			}
		}
		System.out.println(primes);
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
