import java.util.Scanner;
import java.text.Format;

public class InchesToFeet{
 public static void main(String[] args) {
	Scanner bob = new Scanner(System.in);
	System.out.println("Enter a value for inches");
	int inches = bob.nextInt();
	
	double feet = inches/12.0;
	System.out.print(Format.left(feet, 10,2) + "feet");
	//System.out.printf("%6d inches is equal to %6.2f feet  \n",inches, feet);
	}
}
	
