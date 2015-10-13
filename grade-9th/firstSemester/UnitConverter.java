import java.util.Scanner;

public class UnitConverter{
public static void main(String [] args){
	double usd = 1.0;
	double yuan = 1.0;
	double euro = 1.0; 
	double peso = 1.0;
	Scanner reader = new Scanner(System.in);
	System.out.println("Please enter a U.S. dollar value.");
	usd = reader.nextDouble();
	
	yuan = yuan(usd);
	System.out.println("$"+ Format.left(usd,2,2)+" U.S. dollars equals "+ Format.left(yuan,2,2)+" yuan");
	euro = euro(usd);
	System.out.println("$"+ Format.left(usd,2,2)+" U.S. dollars equals "+ Format.left(euro,2,2)+" euros");
	peso = peso(usd);
	System.out.println("$"+ Format.left(usd,2,2)+" U.S. dollars equals "+ Format.left(peso,2,2)+" pesos");
}
public static double yuan(double usd){
	double yuan = usd*6.14;
		return yuan;
}

public static double euro(double usd){
	double euro = usd*0.78;
		return euro;
}

public static double peso(double usd){
	double peso = usd*13.37;
		return peso;
}
}
