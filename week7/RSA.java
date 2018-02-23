//The BigInteger methods are object-methods, not static methods.
//We want static methods?

import java.math.*;
import java.util.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.Integer;
import java.io.IOException;


public class RSA{
	private static BigInteger minN = new BigInteger("355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355355");
	private static BigInteger p;
	private static BigInteger q;
	private static BigInteger n;
	private static BigInteger phi_of_n;
	private static BigInteger e;
	private static BigInteger d;
	
	public static void main(String[]args){
		String s = fileToString("./awmt.txt");
		ArrayList<String> stringBlocks = toStringBlocks(s);
		ArrayList<BigInteger> plainText = toBigIntBlocks(stringBlocks);
		BigInteger one = BigInteger.ONE;
				
		//TESTING to make sure p, q, n, phi_of_n, e, and d are are valid numbers.		
		boolean invalidKey = true;
		while(invalidKey){
			p = randomPrime(300);
			q = randomPrime(300);
			n = multiply(p,q);
			if(n.compareTo(minN)!=1){
				continue;
			}
			phi_of_n = multiply(p.subtract(one),q.subtract(one));
			e = new BigInteger("65537");
			if(gcd(e,phi_of_n).compareTo(one)!=0){
				continue;
			}
			d = inverse(e,phi_of_n);
			invalidKey = false;
		}

		ArrayList<BigInteger> cypheredText = encrypt(plainText);
		//Print out cyphered text.
		ArrayList<BigInteger> decypheredText = decrypt(cypheredText);
		ArrayList<String> decToStringBlocks = decToStringBlocks(decypheredText);
		try{
			stringBlocksToFile(decToStringBlocks);
		} catch(Exception e){
			System.out.println("Main Method Write Error");
		}
		System.out.println("done");
	}
	
	//Returns a random BigInteger 'digits' long.
	//We're converting from Java's base 2.
	public static BigInteger randomInteger(int digits){
		Random rand = new Random();
		int len = (int)(3.32*(double)digits);
		return new BigInteger(len,100,rand);
	}
	
	//Return a random prime approx. n digits long
	public static BigInteger randomPrime(int digits){
		BigInteger p = randomInteger(digits);
		return p.nextProbablePrime();
	}
	
	public static BigInteger subToPrime(int digits){
		BigInteger p = randomInteger(digits);
		return p.nextProbablePrime().subtract(p);
	}
	
	public static BigInteger multiply(BigInteger in1, BigInteger in2){
		return in1.multiply(in2);
	}
	
	public static BigInteger gcd(BigInteger in1, BigInteger in2){
		return in1.gcd(in2);
	}
	
	public static BigInteger inverse(BigInteger in1, BigInteger in2){
		return in1.modInverse(in2);
	}
	
	public static String fileToString(String fileName){
		String result = "";
		try{
			FileInputStream file = new FileInputStream(fileName);
			byte[] b = new byte[file.available()];
			file.read(b);
			file.close();
			result = new String(b);
		} catch(Exception e){
			System.out.println("dammit!!");
		}
		return result;
	}
	
	public static ArrayList<String> toStringBlocks (String input){
		ArrayList<String> outArray = new ArrayList<String>();
		for(int i=0; i<input.length(); i+=200){
			int end;
			if(i+200>input.length()){
				end = input.length();
			}
			else{
				end = i+200;
			}
			outArray.add(input.substring(i,end));
		}
		return outArray;
	}
	
	public static String toPadASCII(char c){
		//I think my code breaks here.  
		Integer output = new Integer((int)c+100);
		if(output>999){
			output = 145;
		}
		return output.toString();
	}
	
	public static ArrayList<BigInteger> toBigIntBlocks(ArrayList<String> input){
		ArrayList<BigInteger> outArray = new ArrayList<BigInteger>();
		input.forEach((str)->{
			String numString = "";
			for(char c:str.toCharArray()){
				numString = numString.concat(toPadASCII(c));
			}
			BigInteger outInt = new BigInteger(numString);
			outArray.add(outInt);
		});
		return outArray;
	}
	
	public static ArrayList<BigInteger> encrypt(ArrayList<BigInteger> plainText){
		ArrayList<BigInteger> outArray = new ArrayList<BigInteger>();
		plainText.forEach((element)->{
			outArray.add(element.modPow(e,n));
		});
		return outArray;
	}
	
	public static ArrayList<BigInteger> decrypt(ArrayList<BigInteger> cypheredText){
		ArrayList<BigInteger> outArray = new ArrayList<BigInteger>();
		cypheredText.forEach((element)->{
			outArray.add(element.modPow(d,n));
		});
		return outArray;
	}
	
	public static ArrayList<String> decToStringBlocks(ArrayList<BigInteger> plainText){
		ArrayList<String> outArray = new ArrayList<String>();
		plainText.forEach((element)->{
			String BigIntAsString = element.toString();
			String outString = "";
			for(int i=0; i<BigIntAsString.length(); i+=3){
				int end = min(BigIntAsString.length(),i+3);
				String part = BigIntAsString.substring(i,end);
				Integer ascii = new Integer(part);
				ascii -= 100;
				char c = (char)(ascii.intValue());
				outString = outString.concat(Character.toString(c));
			}
			outArray.add(outString);
		});
		return outArray;
	}
	
	public static void stringBlocksToFile(ArrayList<String> input) throws IOException{
		FileOutputStream file = new FileOutputStream("./results.txt");
		input.forEach((element)->{
			try{
			byte[] b = element.getBytes();
			file.write(b);
			} catch(IOException e){
				System.out.println("Write Error");
			}
		});
		file.close();
	}
	
	public static int min(int a, int b){
		if(b<a){
			return b;
		}
		return a;
	}
}
