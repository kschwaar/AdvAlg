import java.util.*;

public class EulerPhi{
	public static void main(String[]args){
		for(int i=2; i<=30; i++){
			for(int j=i; j<=30; j++){
				if(phi(i*j) == (i-1)*(j-1)){
					System.out.println("phi("+i*j+") = ("+i+"-1)*("+j+"-1)");
				}
			}
			/*if(phi(i) == i-1){
				System.out.println("phi(i) = i-1");
			}*/
		}
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
