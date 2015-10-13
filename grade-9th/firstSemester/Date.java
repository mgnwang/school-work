import java.util.Scanner;
	

public class Date{
public static void main(String[] args){
        double entree = 1.0;
        double beverage = 2.0;
        double movie = 6.0;

        Scanner kavin = new Scanner(System.in);
        System.out.println("Enter the price for an entree, beverage, and movie, separated by tabs");
        
		entree = 2*(kavin.nextDouble());
        beverage = 2*(kavin.nextDouble());
        movie = 2*(kavin.nextDouble());
	
		System.out.println(Format.left("Entree" , 20) + "=" + Format.right(entree, 10,2));
		System.out.println(Format.left("Beverage",20) + "=" + Format.right(beverage,10,2));
		System.out.println(Format.left("Tip",20) + "=" + Format.right(0.15*(beverage+entree),10,2));
		System.out.println(Format.left("Tax",20) + "=" + Format.right(0.0925*(entree+beverage),10,2));
		System.out.println(Format.left("Dinner Total",20) + "=" + Format.right(entree+beverage+0.15*(beverage+entree)+0.0925*(entree+beverage),10,2));
		System.out.println(Format.left("Movie",20) + "=" + Format.right(movie,10,2));
		System.out.println(Format.left("Movie Tax",20) + "=" + Format.right(0.0925*movie,10,2));
		System.out.println(Format.left("Movie Total",20) + "=" + Format.right(1.0925*movie,10,2));
		System.out.println(Format.left("Grand Total",20) + "=" + Format.right(1.0925*movie+entree+beverage+0.15*(beverage+entree)+0.0925*(entree+beverage),10,2));
		
		
		}
	}
		
