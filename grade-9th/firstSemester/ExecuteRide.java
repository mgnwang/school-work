import java.util.Scanner;

public class ExecuteRide{
	static int miles = 23;
	public static void main(String[]args){
		Ride x = new Ride(miles);
		String city = " ";
		input();
		x.set(miles);
		city = x.whereAmI();
		if (city!= "")
			output(city, miles);
	}
	public static void input(){
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter how many miles you will travel.");
		miles = s.nextInt();
	}
	public static void output(String city, int miles){
		System.out.println("You'll be in " + city + " after " + miles + " mile(s).");
	}
}

