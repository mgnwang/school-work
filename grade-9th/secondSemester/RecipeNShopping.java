//Megan Wang
//1-28-15
//RecipeNShopping.java 
import java.util.Scanner;
import java.io.*;

public class RecipeNShopping{//class header
	private static Scanner r = null;//declare Scanners to read files
	private static Scanner s = null;
	private static PrintWriter printList = null;//declare PrintWriter
	
	public static void main(String[]args){//main method header
		getInput();
		getStaples();
	}
	public static void getInput(){//input method header
		String [] array = new String[1000];//make array
		int counter = 0;//create counter to keep track of slots in array
		String dish = " ";//create variable for input
		Scanner s = new Scanner(System.in);//declare and instantiate scanner
		try{//instantiate PrintWriter in a try catch block
			printList = new PrintWriter(new File("ShoppingList.txt"));
		}catch(IOException e){//to catch FileNotFoundException
			System.out.println("Cannot append to file");
			System.exit(1);
		}
		for(int i = 0; i!= -1; i++){//for loop to save user input into array
			dish = s.nextLine();
			if(dish.equalsIgnoreCase("quit"))
				 i = -2;
			else{
				array[i] = dish;
				counter++;
			}
		}
		for(int x = 0; x < counter; x++){//loop to call method to get ingredients
			findRecipe(array[x]);	
		}
		printList.close();//saves PrintWriter
	}
		
	public static void findRecipe(String name){//findRecipe method finds ingredients
		String line = " ";
		int num = 0;
		try{//instantiate Scanner in a try catch block
			r = new Scanner(new File("Recipes.txt"));
		}catch(FileNotFoundException e){//to catch FileNotFoundException
			System.out.println("Cannot find file");
			System.exit(1);
		}
		while(r.hasNext()){//while loop to get ingredients
			line = r.nextLine();//reads each line
			if(line.indexOf("Recipe: ")==0){//find keword 'recipe'
				if((line.substring(8,8+name.length())).equalsIgnoreCase(name)){//find recipe of inputted dish
					while(!line.equals("Directions:")){//while loop to print out inngredients to ShoppingList
						line = r.nextLine();
						if(line.equals("Ingredients:")){
							line = r.nextLine();
							while(line.length()!=0){
								printList.println(line);
								line = r.nextLine();
							}
							num = 1;
						}
					}	
				}
			}
		}
		if(num == 0)//if inputted dish is not found in Recipes.txt, print directly to ShoppingList.txt
			printList.println(name + "(1)");
	}
	
	public static void getStaples(){//getStaples method prints contents of staples.txt to ShoppingList.txt
		String line = " ";
		try{
			s = new Scanner(new File("Staples.txt"));
		}catch(FileNotFoundException e){//to catch FileNotFoundException
			System.out.println("Cannot find file");
			System.exit(1);
		}
		while(s.hasNext()){
			line = s.nextLine();
			printList.println(line);
			
		}
	}
}
