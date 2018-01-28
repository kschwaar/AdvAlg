import java.math.*;
import java.util.*;

public class tester{
		
	public static void main(String[]args){
		for(int i=0; i<10000; i++){
			Random rand = new Random();
			BigInteger b = new BigInteger(5,5,rand);
			BigInteger c = new BigInteger("15");
			System.out.println(b);
		}
	}
}
