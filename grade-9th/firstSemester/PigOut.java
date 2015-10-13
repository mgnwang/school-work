import java.util.Scanner;//import Input Output library

public class PigOut { //public class PigOut
	private int nom; //create global variable private called  number of noms
	
	public static void main(String[]args) {//public static void main()
		String food = Input();
		while (!food.equalsIgnoreCase("I'm full")) {
				Output(food);
				food = Input();
		}
	}
	public static String Input() {
			Scanner reader = new Scanner(System.in);
			System.out.println("What food would you like to eat? (Type I'm full to terminate)");
			String food = reader.nextLine();
			return food;
	}
	
	public static void Output(String food) {
			int letters = food.length();
			for (int x = 1; x<=letters; x++){
				System.out.print("Nom ");
				if (x%5 == 0)
					System.out.println("burp");
			}
	}		
		
}