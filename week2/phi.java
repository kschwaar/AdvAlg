import java.util.*;
import java.lang.Integer;
import java.lang.Math;

public class phi {

	public static void main(String[]args){
		for(int i=5; i<=100; i++){
			int phi = 0;
			System.out.print("GroupOfUnits Mod "+i+" = {");
			for(int j=1; j<i; j++){
				if(euclid(i,j)==1){
					System.out.print(j);
					if(j<i-1){
						System.out.print(",");
					}
					phi++;
				}
			}
			System.out.println("}");
			System.out.println("Phi("+i+") == "+phi);
		}
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
