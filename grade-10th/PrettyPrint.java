import java.util.Scanner;
import java.io.PrintWriter;

/** 
*  This program formats inputted code
* 
*  @author Megan Wang
*  @version November 8 2015
*/
public class PrettyPrint{
	// Fields
	private OpenFile open;
	private String file;
	private int start;
	
	public PrettyPrint(){
		file ="";
		start = 0;
		open = new OpenFile();
	}
	
	public static void main(String[]args){
		PrettyPrint pp = new PrettyPrint();
		pp.fileToString(args);
		pp.stripContents();
		pp.format();
	}
	/** 
	  *  Stores the inputted code into one string
	  *  @param args array
	  */
	public void fileToString(String[]args){
		Scanner reader = open.openToRead(args[0]);
		while(reader.hasNext()){
			file += reader.nextLine();
		}
	}
	/**
	 *  Strips string of any newlines or tab characters
	 */
	public void stripContents(){
		for(int i = 0; i< file.length(); i++){
			// strip new lines
			if(file.charAt(i) == '\n')
				file = file.substring(0,i)+file.substring(i+1);
			// strip tab characters and replace with spaces
			else if(file.charAt(i) == '\t')
				file = file.substring(0,i)+ " " + file.substring(i+1);
		}
	}
	/**
	 *  Loops through string multiple time
	 *  each time format one special sequence
	 */
	public void format(){
		comments();
		imports();
		semicolons();
		braces();
		accessModifiers();	
		loops();
		spacing();
		indent();
		printOutput();
	}
	/**
	 *  Inserts a line before a certain string
	 *  @param string that line is inserted in front of
	 */
	public void insertLineBefore(String str){
		String refactored = "";
        int index = 0;
		while (index != -1){
			index = file.indexOf(str);
			if (index != -1){
				refactored += file.substring(0, index) + '\n' + str;
				// Start next search after symbol character
				file = file.substring(index + str.length());
			} 
		}
		refactored += file;
		file = refactored;
	}
	/**
	 *  Inserts a line after a certain string
	 *  @param string that line is inserted after
	 */
	public void insertLineAfter(String str){
		String refactored = "";
        int index = 0;
		while (index != -1){
			index = file.indexOf(str);
			if (index != -1){
				refactored += file.substring(0, index) + str + '\n';
				// Start next search after symbol character
				file = file.substring(index + str.length());
			} 
		}
		refactored += file;
		file = refactored;
	}
	/**
	 *  Formats comments
	 */
	public void comments(){
		insertLineBefore("/**");
		insertLineBefore(" *");
		insertLineBefore(" */");
		insertLineAfter(" */");
		insertLineBefore("//");
	}
	/**
	 *  Formats imports
	 */
	public void imports (){
		insertLineBefore("import");
	}
	/**
	 *  Formats semicolons
	 */
	public void semicolons(){
		insertLineAfter(";");
	}
	/**
	 *  Formats access modifiers
	 */
	public void accessModifiers (){
		insertLineBefore("public");
		insertLineBefore("private");
		insertLineBefore("protected");
	}
	/**
	 *  Formats braces
	 */
	public void braces(){
		insertLineBefore("{");
		insertLineAfter("{");
		insertLineAfter("}");
	}
	/**
	 *  Formats loops
	 *  gets rid of new line previously added after each semicolon
	 */
	public void loops(){
		int index, closePar, openPar, semicolon;
		index = closePar = openPar = semicolon = 0;
		for(int i = 0; i < file.length(); i++){
			index = file.indexOf("for", i);
			if (index == -1)
				return;
			openPar = file.indexOf("(", index);
			closePar = file.indexOf(")", index);
			//loop between the parentheses
			for (int j = openPar; j < closePar; j++){
				semicolon = file.indexOf(";", j);
				//remove new line inserted after semicolon
				if (semicolon != -1 && semicolon < closePar){
					file = file.substring(0, semicolon+1) + " " + file.substring(semicolon+2);
					j = semicolon;
				}
			}
			i=index;
		}
	}
	/**
	 *  Indents each line
	 *  keeps track of tab count each time there is a brace
	 */
	public void indent(){
		//keeps track of number of tabs and where each new line is
		int tabCount, newLine, lastNewLine;
		tabCount = newLine = lastNewLine = 0;
		//temporary string
		String temp = "";
		for(int i = 0; i < file.length(); i++){
			String tabs = "";
			//if opening brace
			if(file.charAt(i)=='{'){
				//increase tab count
				tabCount++;
			}
			//find next new line
			newLine = file.indexOf("\n",i);
			//if closing brace
			boolean decrease = true;
			for(int j = newLine+1; j <= file.indexOf("}", newLine); j++){
				if(file.charAt(j)!=' '&& file.charAt(j)!='}') {
					decrease = false;
					break;
				}
			}
			//decrease tab count if closing brace found
			if(decrease)
				tabCount--;
			//create string with tabCount number of tabs
			for(int j = 0; j < tabCount; j++)
				tabs += "\t";
			//insert tabs after each new line
			temp += (file.substring(lastNewLine,newLine+1)+tabs);
			lastNewLine = newLine+1;
			//increase index to prevent counting same new line
			i = newLine;
		}
		file = temp;
	}
	/**
	 *  Formats spacing
	 *  deletes double spaces
	 */
	public void spacing(){
		for(int i = 0; i < file.length()-1;i++){
			if(file.charAt(i)==' ' && file.charAt(i+1)==' '){
				file = file.substring(0,i) + file.substring(i+1);
			}
		}
	}
	/**
	 *  Prints into terminal and Test.java
	 */
	public void printOutput(){
		System.out.println(file);
		PrintWriter outPrint = OpenFile.openToWrite("Test.java");
		outPrint.print(file);
		outPrint.close();
	}
}
