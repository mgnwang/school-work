import java.util.Scanner;

public class GradeCalculator{
 public static void main(String[] args) {
	double a = 0.0;
	double b = 0.0;
	double c = 0.0;
	double d = 0.0;
	double e = 0.0;

	a = getInput();
	b = getInput();
	c = getInput();
	d = getInput();
	e = getInput();
}
public static double getInput(){
	Scanner x = new Scanner(System.in);
	System.out.println("Please enter scores below as decimals");
	System.out.println("What is your homework score?");
	double a = x.nextDouble();
	System.out.println(a);
	System.out.println("What is your quiz score?");
	double b = x.nextDouble();
	System.out.println(b);
	System.out.println("What is your test score?");
	double c = x.nextDouble();
	System.out.println(c);
	System.out.println("What is your group quiz/participation score?");
	double d = x.nextDouble();
	System.out.println(d);
	System.out.println("What is your final exam score?");
	double e = x.nextDouble();
	System.out.println(e);
	
	}
}
	
