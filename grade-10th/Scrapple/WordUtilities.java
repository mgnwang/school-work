import java.util.Scanner;

/**
 *  Finds all the words that can be formed with a list of letters,
 *  then finds the word with the highest Scrabble score.
 *
 */
 
public class WordUtilities
{	
	private static String lastWord;
	/**
	 *  Enter a list of 3 to 12 letters. It also checks
	 *  all letters to insure they fall between 'a' and 'z'.
	 *
	 *  @return  A string of the letters
	 */
		
	public static void main (String [] args){	
			String input = getInput();
			String [] word = findAllWords(input);
			printWords(word);
		
			// Score table in alphabetic order according to Scrabble
			int [] scoretable = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
			String best = bestWord(word,scoretable);
			System.out.println("\n\n\n" + best + "\n\n\n");
	}
	
	public static String getInput ( )
	{
		String letters;
		boolean done;
		do{
			letters = Prompt.getString("Enter a string of 3 to 12 letters");
			if(letters.length() < 3|| letters.length()>12){
				System.err.println("ERROR: Must have length of 3 to 10 letters");
				System.exit(1);
			}
			//check each letter
			done = true;
			for(int cnt = 0; cnt<letters.length(); cnt++){
				char c = letters.charAt(cnt);
				if(c  < 'a' || c > 'z')
					done = false;
			}
		}while(!done);
		return letters;
	}
	
	/**
	 *  Find all words that can be formed by a list of letters.
	 *
	 *  @param letters  String list of letters
	 *  @return   An array of strings with all words found.
	 */
	public static String [] findAllWords (String letters)
	{	
		String word;
		String words [] = new String [200];
		int cnt = 0;
		//Open database file
		Scanner infile = OpenFile.openToRead("wordlist.txt");
		while(infile.hasNext()){
			word = infile.next();
			//int len = word.length();
			if(wordMatch(word, letters)){
				words[cnt] = word;
				cnt++;
			}
		}
		infile.close();
		return words;
	}
	
	public static boolean wordMatch (String word, String letters) {
		for(int i = 0; i < word.length(); i++){
			int index = letters.indexOf(word.charAt(i));
			if(index==-1)
				return false;
			letters = letters.substring(0,index) + letters.substring(index+1);
		}
		return true;
	}
	
	/**
	 *  Determines if a word can be formed by a list of letters.
	 *
	 *  @param temp  The word to be tested.
	 *  @param letters  A string of the list of letter
	 *  @return   True if word can be formed, false otherwise
	 */
	public static boolean matchletters (String temp, String letters)
	{
		return wordMatch(temp, letters);
	}
	
	/**
	 *  Print the words found to the screen.
	 *
	 *  @param word  The string array containing the words.
	 */
	public static void printWords (String [] word)
	{		
		for(int col = 0; col < word.length; col++){
			if(word[col]!= null)
				System.out.print(word[col] + "  ");
		}
		System.out.println();

	}
	
	/**
	 *  Finds the highest scoring word according to Scrabble rules.
	 *
	 *  @param word  An array of words to check.
	 *  @param scoretable  An array of 26 integer scores in letter order.
	 *  @return   The word with the highest score.
	 */
	public static String bestWord (String [] word, int [] scoretable)
	{
		String  bWord = "";
		int score, bScore, i;
		i  = score = bScore = 0;
		while(word[i]!= null){
			score = getScore(word[i], scoretable);
			if(score - bScore>0){
				bScore = score;
				bWord = word[i];
			}
			i++;
		}
		return bWord;
	}
	
	/**
	 *  Calculates the score of a word according to Scrabble rules.
	 *
	 *  @param word  The word to score
	 *  @param scoretable  The array of 26 scores for alphabet.
	 *  @return   The integer score of the word.
	 */
	public static int getScore (String currentWord, int [] scoretable)
	{
		int score, letter;
		score = letter = 0;
		for(int j = 0; j< currentWord.length(); j++){
			letter =(int)(currentWord.charAt(j))-97;
			score += scoretable[letter];
		}
		return score;
	}
	public static boolean isDoubleLetter(String enterWord){
		for(int i =  0; i<enterWord.length()-1; i++){
			if(enterWord.charAt(i)==enterWord.charAt(i+1))
				return true;
		}
		return false;
	}
	public static boolean isConsecutive(String enterWord){
		boolean bonus = false;
		if(lastWord==null){
			lastWord = enterWord;
			return false;
		}
		if(enterWord.charAt(0)-lastWord.charAt(0)==1){
			bonus = true;
		}
		lastWord = enterWord;
		return bonus;
	}
}