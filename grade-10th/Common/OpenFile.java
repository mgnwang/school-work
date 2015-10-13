import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
/**
 * Open files for reading and writing
 * 
 * @author Megan Wang
 * @version 8-27-15
 */
 
 public class OpenFile{
	
	public static Scanner openToRead(String fileName){
		Scanner input = null;
		try{
			input = new Scanner(new File(fileName));
		}catch(FileNotFoundException e){
			System.err.println("ERROR: Cannot open" + fileName + "for reading");
			System.exit(11);
		}
		return input;
	}
	public static PrintWriter openToWrite(String fileName){
		PrintWriter output = null;
		try{
			output = new PrintWriter(new File(fileName));
		}catch(IOException e){
			System.err.println("ERROR: Cannot open" + fileName + "for writing");
			System.exit(12);
		}
		return output;
	}
	
}