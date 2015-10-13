import java.util.Scanner;

public class IsLeapYear { 
	private static int year; 
	
	public static void main(String[]args) {//public static void main()
		Input();
		while (year!=0) {
				Output();
				Input();
		}
	}
	public static void Input() {
			Scanner reader = new Scanner(System.in);
			System.out.print("Input year:");
			year = reader.nextInt();
	}
	
	public static void Output() {
		if((year%4 == 0 && year%100!=0)||(year%100==0 && year%400==0))
			System.out.println(year+" is a leap year");
		else
			System.out.println(year+" is not a leap year");

	}		
		
}