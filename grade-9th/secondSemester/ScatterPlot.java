public class ScatterPlot{
	private static int data [][] = {{13,14,15,16,17,18},{70,217,245,292,314,159}};
	private static int likes = 0;
	private static int maxLikes = 0;
	
	public static void main(String[]args){
		printGraph();
	}
	public static void printGraph(){
		System.out.println("\nCorrelation Between Age and Fb Likes\n");
		for(int i = 0; i < data[0].length; i++){
			String space = " ";
			if (i!=2)
				System.out.print("    " + data[0][i] + "|");
			else 
				System.out.print("Age " + data[0][i] + "|");
			likes = data[1][i];
			if(maxLikes<=likes)
				maxLikes=likes;
			for(int y = likes/20; y>=0; y--)
				space += " ";
			System.out.print(space + likes+ "\n");
		}

		System.out.print("       ");
		for(int a = 0; a<=maxLikes/20; a++){
			if(a==maxLikes/20)
				System.out.print("______\n");
			else
				System.out.print("_");
			
		}
		System.out.println("      Number of Facebook Profile Pic Likes\n");		
	}
}