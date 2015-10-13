//Megan Wang
//10-9-14

import java.util.Scanner;
public class BakeSale{
	public static void main(String [] args){
		Food x = new Food("baked", "banana", "muffins", 0.50, 12);
		x.printForSale();
		Food z = new Food("fried", "yam", "fritters", 1.00, 1);
		z.printForSale();
		Food y = new Pizza("pepperoni", "pizza");
		y.printForSale();
		Food w = new DeepDishPizza("mushrooms", "deep dish pizza");
		w.printForSale();
		Scanner reader = new Scanner(System.in);	
	}
}