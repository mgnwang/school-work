/**
 * First prompts user for number of trials to be conducted
 * Keep running trials until trial input is met
 * First start with 4 sides, then ruun trials for all dice up to 20 sides
 * store data in array and then print in histogram
 *  @author Megan Wang
 *  @version August 21, 2015
 */
 import java.util.Scanner;
 
 public class Casino{
	 private LittleJackpot jackpot;
	 private Prompt prompt;
	 private int numberOfTrials, numberOfDice;
	 private int [][] numberOfSpins;
	 private int [] averageSpins;
	 
	 /**
	  *create new instance of prompt 
	  *initialize constants
	  */
	 public Casino(){ 
		prompt = new Prompt();
		numberOfTrials = 0;
		numberOfDice = 17;
	}
 	/**
 	 *create new instance of prompt and initialize constants
  	 */
	public static void main(String[]args){
		Casino cas = new Casino();
		cas.getInput();
		cas.getNumberOfSpins();
		cas.findAverageSpins();
		cas.makeHistogram();
	}
	public void getInput(){
		numberOfTrials = prompt.getInt("Please enter the number of trials to be conducted on each dice (betweem 10 and 1000)", 9, 1001);
	}
	public void getNumberOfSpins(){
		int SIDES = 4;
		numberOfSpins = new int [numberOfDice][numberOfTrials];
		for(int i = 0; i<numberOfDice; i++){
			jackpot = new LittleJackpot(SIDES);
			for(int j = 0; j< numberOfTrials; j++){
				jackpot.runTrials();
				numberOfSpins[i][j] = jackpot.getRolls();
			}
			SIDES++;
		}
	}
	public void findAverageSpins(){
		averageSpins = new int [numberOfDice];
		for(int i = 0; i < numberOfDice; i++){
			int count = 0;
			for(int j = 0; j< numberOfTrials; j++){
				count += numberOfSpins[i][j];
			}
			count /= numberOfTrials;
			averageSpins[i] = count;
		}
	}
	public void makeHistogram(){
		int max = 0;
		int SIDES = 4;
		for(int i = 0; i < numberOfDice; i++){
			if(i==0)
				max = averageSpins[i];
			else if(i==numberOfDice-1){
				if(averageSpins[i]>max||averageSpins[i]==max)
					max = averageSpins[i];
				else
					break;
			}
			else if(averageSpins[i+1]>max||averageSpins[i+1]==max)
				max = averageSpins[i+1];			
		}
		System.out.println("\n" + max);
		System.out.println("\n\nNumber\n of  	Ave number\nsides	of spins");
		for(int i = 0; i < numberOfDice; i++){
			double count = (double)averageSpins[i]/max*60;
			System.out.printf("%4d:%9d   ", SIDES, averageSpins[i]);
			for(int j = 0; j<(int)count; j++){
				System.out.print("*");
			}
			System.out.println();
			SIDES++;
		}
	}
}		