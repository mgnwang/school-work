
import java.util.Scanner;//import Scanner
public class Game21 {//class header
	int user,comp;//declare and instantiate user and computer scores
	Die die;//declare and instantiate object die
	Scanner scan;//declare Scanner scan
	
	public Game21(){
		user = 0;
		comp = 0;
		die = new Die();
	}

	public static void main (String [] args) {//main method
		Game21 g21 = new Game21();
		System.out.println("Let's play a game of 21!");//print opening line
		g21.playGame(); //call playGame method
	} 
	public void playGame(){//plays the game
		String play;//string for y or n
		scan = new Scanner(System.in);//instantiate scanner
		for(int i = 0; i>=0; i++){//loop to play game
			int rolldie;//random generated die roll
			System.out.println("Would you like to roll the dice?");//user promts
			System.out.print("Enter Y for yes or N for no: ");
			play = scan.next();//get user y or n input
			if(play.equalsIgnoreCase("y")){//if user wants to play
				rolldie = die.roll();//call roll method in class die to generate random number
				comp += rolldie;//add to computer score
				rolldie = die.roll();//call roll method in class die to generate random number
				user += rolldie;//add to user score
				System.out.println("You have " + user + " points");//print out current user score
			}
			else{//if user does not want to play
				System.out.println("Game Over\nThe computer had " + comp + " points.\nYou had " + user + " points.");//print out scores of user and computer
				if((comp>user&&comp<21)||user>21)//if comp's score is grater than users and both are under 21 or if user's score is over 21
					System.out.println("You lost");//user loses
				else if(comp>21&&(user<21||user==21)||(user>comp&&user<21))//if user's score is grater than comp's and both are under 21 or if comp's score is over 21
					System.out.println("Congratulations! You won!");//user wins
				else if (user==comp)//if scores are equal
					System.out.println("It's a draw");//game draws
				break;//break loops
			}
		}	
	}
} 
class Die{//class die
	int score;//random generated number
	public int roll(){//roll method
		score = (int)(Math.random()*6+1); //use Math.random to generate random number between 1-6
		return score;//return randomly generated number
	}
}