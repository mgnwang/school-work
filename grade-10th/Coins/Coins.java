 import java.util.Scanner;

/**
 * Calculates and prints the total number of possibilities in coins for a given amount of money
 * @author Megan Wang
 * @version 9-4-15
 */

public class Coins{
	Prompt prompt;
		
	public Coins(){
		prompt = new Prompt();
	}
	/**
	 * new instance of coins
	 * sets variable cents to user input
	 * calls method to calculate possibilities
	 */
	public static void main(String[]args){
		Coins cn = new Coins();
		int cents = cn.promptInput();
		cn.calculate(cents);
	}
	/**
	 * gets user input (cents)
	 * @return int user input
	 */
	public int promptInput(){
		return prompt.getInt("Total cents");
	}
	/**
	 * calculates possibilities
	 * goes through all of the possible combinations of coins
	 * if combination adds up to cents, print
	 * prints total combinations
	 */
	public void calculate(int cents){
		int count,pennies,nickels,dimes,quarters,remainder;
		remainder=count = pennies = nickels = dimes = quarters = 0;
		
		quarters = cents/25;
		dimes = cents/10;
		nickels = cents/5;
		pennies = cents;
		
		for(int q = 0; q<=quarters; q++){
			
			for(int d = 0; d<=dimes; d++){
				
				for(int n = 0; n<=nickels; n++){
					
					for(int p = 0; p<=pennies; p++){
						if((25*q + 10*d + 5*n + p)==cents){
							print(p, n, d, q);
							count++;
						}
					}
				}
			}
		}
		System.out.println("Total possibilities: " + count);
	}
	/**
	 * prints out each possibility
	 */
	public void print(int pennies, int nickels, int dimes, int quarters){
		System.out.println("Pennies: "+pennies+" + Nickels: "+nickels+" + Dimes: "+dimes+" + Quarters: "+quarters);
	}
}
	