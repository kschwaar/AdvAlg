import java.lang.Character;
import java.lang.Integer;
import java.util.*;
import java.lang.Math;


class proj3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double x = input.nextDouble();
		int n = (int)(Math.pow(2.0,x)-1);
		Integer j = new Integer(0);
		for(int i=0; i<=n; i++){
			char [] output = j.toBinaryString(i).toCharArray();
			for(int k=0; k<output.length; k++){
				if(output[k]=='1'){
					output[k] = (char)(output.length-k+48);
				}
				else{
					output[k] = (char)(0);
				}
			}
			System.out.println(output);
		}
	}
}

