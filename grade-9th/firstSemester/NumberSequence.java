import java.util.Scanner;

public class NumberSequence{
	public static String patt = "";
	public static int num = 0;
	
	public static void main(String[]args){
		printSequence();
		numInput();
		pattInput();
		
	}
	
	public static void printSequence(){
		String pattn = sequence(3);
		System.out.println(pattn);
	}
	
	public static String sequence(int z){
		if(z==15)
			return (String)(z + ", __");
		else
			return (z + ", " + sequence(z+3));
		
	}	
		
	public static void numInput(){
		Scanner x = new Scanner(System.in);
		System.out.println("What is the next number?");
		num = x.nextInt();
		if(num==18)
			System.out.println("You are correct.");
		else
			numInput2(2);
	}
	
	public static void numInput2(int counter){
		Scanner y = new Scanner(System.in);
		if(num==18)
			System.out.println("You are correct.");
		else if(num!=18 && counter==0){
			System.out.println("The next number was 18.");
		}
		else{
			System.out.println("Try again.");
			num = y.nextInt();
			numInput2(counter-1);
			}
	}
	public static void pattInput(){
		Scanner z = new Scanner(System.in);
		System.out.println("What is the pattern?");
		patt = z.nextLine();
		if(patt.equalsIgnoreCase("add 3")||patt.equalsIgnoreCase("plus 3"))
			System.out.println("You are correct.");
		else
			pattInput2(2);
	}
	
	public static void pattInput2(int counter){
		Scanner w = new Scanner(System.in);
		if(patt.equalsIgnoreCase("add 3")||patt.equalsIgnoreCase("plus 3"))
			System.out.println("You are correct.");
		else if(!patt.equalsIgnoreCase("add 3") && !patt.equalsIgnoreCase("plus 3") && counter==0){
			System.out.println("The pattern was add 3.");
		}
		else{
			System.out.println("Try again.");
			patt = w.nextLine();
			pattInput2(counter-1);
			}
	}
	
}