import java.util.Scanner;

/**
 * Analyzes a series of names and their popularity
 * prints out rank of names in chart
 * @author Megan Wang
 * @version 8-31-15
 */

public class Names{
	Prompt prompt;
	int decades;
	String nameLine;
	
	public Names(){
		prompt = new Prompt();
		decades = 12;
		nameLine = "";
	}
	/**
	 * initialize constructor
	 * gets input
	 * calls method to read file
	 */
	public static void main(String[]args){
		Names nm = new Names();
		String name = nm.promptInput();
		nm.processName(name);
	}
	/**
	 * gets user input (name)
	 * @return string user input
	 */
	public String promptInput(){
		return prompt.getString("Please enter the name you are searching for");
	}
	/**
	 * finds name in names.txt filed
	 */
	public void processName(String name){
		if(readFile(name)){
			getNumbers(name);
		}
		else if(readFile(name)==false){
			do{
				System.out.println(name + " not found in database");
				name = promptInput();
				readFile(name);
			}while(readFile(name)==false);
			getNumbers(name);
		}
	}
	/**
	 * reads names.txt to find name
	 * @return boolean found or not in names.txt
	 */
	public Boolean readFile(String name){
		String current = " "; 
		Boolean found = false;
		Scanner readName =  OpenFile.openToRead("names.txt");
		do{
			current = readName.next();
			if(current.compareToIgnoreCase(name)==0){
				found = true;
				nameLine = readName.nextLine();
			}
		}while(readName.hasNext());
		return found;
	}
	/**
	 * if name found, save values into array
	 * else, keep prompting until name is found
	 */
	public void getNumbers(String name){
		int popularityValues [] = new int [decades];
		int begin = 0;
		System.out.print(name + ":");
		for(int i= 0; i<decades; i++){
			nameLine = nameLine.trim();
			if(nameLine.indexOf(' ')==-1){
				popularityValues[i] = Integer.parseInt(nameLine.substring(0));
				break;
			}
			else
				popularityValues[i] = Integer.parseInt(nameLine.substring(0, nameLine.indexOf(' ')));
			nameLine = nameLine.substring(nameLine.indexOf(' '));
			System.out.print("  " + popularityValues[i]);
		}
		System.out.println("\n");
		printGraph(popularityValues);
	}
	/**
	 * prints graph
	 * saves increments into an array
	 * compares every value to the increments to determine whether or not to print
	 * if number is within the increments, print number out
	 */
	public void printGraph(int popularityValues[]){
		int increments[] = new int [51];//create empty increments array
		System.out.print("     ");//spacing
		for(int i = 0; i<decades; i++){//prints out years at the top
			System.out.printf("%5d", (1900+i*10));
		}
		System.out.println();
		for(int i = 0; i<51; i++){//enter values into increment array
			increments[i]= 20*i;
		}
		for(int x = 1; x<51; x++){//determines numbers to graph
			System.out.printf("%5d", increments[x]);//prints out increment number
			for(int y = 0; y<decades; y++){//goes through array with saved name values
				if((popularityValues[y]>increments[x-1] && popularityValues[y]< increments[x])|| popularityValues[y]==increments[x])
					//determines whether or not to print
					System.out.printf("%5d", popularityValues[y]);
				else
					System.out.printf("%5s", "---");
			}
			System.out.println();
		}
	}			
}    