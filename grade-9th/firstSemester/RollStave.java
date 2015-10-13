//Megan Wang
//10-2-14
// RollStave generates 35 or 36

public class RollStave{//RollStave class header
        
		public static int roll()//roll () header (no parameter)
        {
                int randNum = 1;
                randNum = (int)(Math.random()*2+35); //use (int)(Math.random() *span+start)
                return randNum; //return randNum
        }
}