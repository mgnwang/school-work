//Megan Wang
//10-8-14
//Food class

public class Food{
	
	double price;
	int count;
	String cookMethod;
	String filling;
	String food;
	
	public Food(String prepMethod, String ingredient, String name, double cost, int number){
		price = cost;
		count = number;
		cookMethod = prepMethod;
		filling = ingredient;
		food = name;
		
	}
	
	public void printForSale(){
		
		System.out.printf("At the sale: %s %s with %s will be sold for $%3.2f each." + 
			"With %d %s(s), $%3.2f can be made.\n",
			cookMethod, food, filling, price, count, food, count*price);

	} 
	public void setPrice(double x){
		price = x;
	}
	public void setCount(int y){
		count = y;
	}
}