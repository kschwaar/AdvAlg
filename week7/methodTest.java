import java.lang.Integer;

public class methodTest{
	public static void main(String[]args){
		String tester = "Test";
		for(char c:tester.toCharArray()){
			System.out.println(toPadASCII(c));
		}
	}
	public static String toPadASCII(char c){
		Integer output = new Integer((int)c+100);
		return output.toString();
	}
}
