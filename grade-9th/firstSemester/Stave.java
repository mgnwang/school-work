// Stave.java
import java.util.Scanner;
public class Stave {
//Declare all global variables here (2 objects, at least five int variables). Be sure they are private. private roll1, roll2, roll3, roll4, score, RollStave, ShowStave
	int roll1, roll2, roll3, roll4, score, runningscore;
	RollStave x;
	ShowStave y;

	public Stave() { 
		// instantiate both objects, initialize all ints.  score = 0
		roll1 = 0;
		roll2 = 0;
		roll3 = 0;
		roll4 = 0;
		score = 0;
		runningscore=0;
		x = new RollStave();
		y = new ShowStave();
	} 

	public static void main (String [] args) { 
		Stave st = new Stave (); 
		int finalscore = 0;
		
		System.out.println("Press enter to randomly roll the staves. If all four staves have the same side facing up, you will get three points.  If two of them have the same side up, you will get one point.  Any other combination will recieve 0 points."); //states rules of game, prompts user to press enter
		
		st.playGame(); //call playGame method
		st.scoreGame();
		st.updateScore();
		st.playGame(); 
		st.scoreGame();
		st.updateScore();
		st.playGame(); 
		st.scoreGame();
		st.updateScore();
		
		finalscore = st.getRunningScore();
		System.out.println("\nFinal Score = " + finalscore);
		} 
	
	public void playGame () {
		Scanner reader = new Scanner(System.in);
		String a = " ";
		System.out.print("\nPress enter.");
		a = reader.nextLine();
		
		roll1 = x.roll(); //generates random int number (35,36)
		y.displayStave(roll1); //converts 35,36 to char (#,$)
		roll2 = x.roll(); 
		y.displayStave(roll2);
		roll3 = x.roll(); 
		y.displayStave(roll3); 
		roll4 = x.roll(); 
		y.displayStave(roll4); 
		} 
/* This method is complete. scoreGame() builds a String of all 4 rolls 
as characters, then looks at all 4 characters, counting how many '$' 
there are. If four or no '$' score increases by 2. If two '$' score 
increases by 1.*/

	public void scoreGame() { 
		String rolls = "" + (char)roll1 + (char)roll2 + (char)roll3 + (char)roll4; 
		int count = 0;
		score = 0;
		for (int i = 0; i < 4; i++) { 
			if (rolls.charAt(i) == '$')
				count++; //determines side of each stave (#,$)
		} 
		if (count == 4 || count == 0) 
			score+=2; 
		else if (count == 2) 
			score++; // if all $ or none, then 3 points are added, if 2 $, then 
		}
	
	public void updateScore () {
		runningscore =  runningscore + score;
		System.out.println("score = " + score); 
		 //calculates current score (runningscore)
	} 
	public int getRunningScore(){
		return runningscore;
	}

} // end class Stave
//Be sure other two classes are written as well (both are very short).
// Neither class uses “static” in their methods – leave it out. :)