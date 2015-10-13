/**
 *  You have a Jackpot machine. There are four "wheels" showing
 *  numbers. Prompt the user for the number of sides of each wheel.
 *  The machine generates four numbers until all four are the same.
 *
 *  @author Megan Wang
 *  @version August 25, 2015
 */

public class LittleJackpot
{
	private Dice die1, die2, die3, die4;
	private int numberofsides;
	private int rolls;
	
	// Constructor
	public LittleJackpot (int sides)
	{	
		numberofsides = sides;
		die1 = die2 = die3 = die4 = new Dice(numberofsides);
		
	}
	/**
	 *  Run the number of trials collecting the number of spins.
	 */
	public void runTrials() {
		die1 = new Dice(numberofsides);
		die2 = new Dice(numberofsides);
		die3 = new Dice(numberofsides);
		die4 = new Dice(numberofsides);
		spinWheel();
	}
	
	/**
	 *  Spin each wheel until all the numbers are equal.
	 */
	public int getRolls(){
		return rolls;
	}
	public void spinWheel ( )
	{
		boolean done = false;
		do
		{
			die1.roll();
			die2.roll();
			die3.roll();
			die4.roll();
			if (die1.getValue() == die2.getValue())
			{
				if (die2.getValue() == die3.getValue())
				{
					if (die3.getValue() == die4.getValue())
					{
						done = true;
					}
				}
			}
		}
		while(!done);
		rolls = die1.getRollCount();
	}
}