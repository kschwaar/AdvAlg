import java.math.*;


public class BigDProbability{
	public static void main(String[]args){
		BigDecimal half = new BigDecimal("0.5");
		BigDecimal one = BigDecimal.ONE;
		System.out.println(one.subtract(half.pow(100)));
	}
}


