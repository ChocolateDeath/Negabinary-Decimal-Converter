package lab2;
//Kevin Perez
//CSC260 lab 2
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub;
		Scanner scan = new Scanner(System.in);
		int strLength;
		System.out.println("Enter the Decimal or Negabinary number to convert");
		String input = scan.nextLine().replaceAll(" ", "").toLowerCase();//format
		
		strLength = input.length();

		
		//look for the letter to indicate which format it is
		switch (input.charAt(strLength-1)) {
		
		case 'd':
			System.out.println(decimaltoBinary(input, strLength-1));
			break;
			
		case 'b':
			char[] charArray = new char[strLength];
			
			for(int i=0;i<strLength;i++) 
				charArray[i] =input.charAt(i);
			System.out.println(binarytoDecimal(input, strLength-1));
			break;
			
		default:
			System.out.println("Could not find indicator of base");
			break;
		}
	}
	public static String decimaltoBinary(String original, int length) {
		System.out.println("Converting Decimal to Negabinary" );
		StringBuilder decimalString = new StringBuilder();

		int remainder = 1;
	
		for(int i=0;i<original.length();i++)
			if(original.charAt(i) != 'd')
					decimalString.append(original.charAt(i));
			int quotient  = Integer.parseInt(decimalString.toString());
			
			decimalString = new StringBuilder();
			
			while(quotient != 0) {
				remainder = quotient%2;
				quotient = quotient/-2;
				if(remainder <0) {
					remainder = remainder + 2;
					quotient++;
					}
				System.out.printf("Q: %+2d\tR: %1d\n",quotient,remainder);
				decimalString.append(remainder);
			}
				decimalString = decimalString.reverse().append('b');
				
				
		return decimalString.toString();
	}
	public static int binarytoDecimal(String original, int length) {
		char[] charArray = original.toCharArray();
		System.out.println("Converting Negabinary to Decimal");
		int result = 0;
		
		for(char i:charArray) {
			if( i =='1')
				result += Math.pow((-2),--length);
			else --length;			
		}
		
		return result;
	}

}
