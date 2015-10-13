/**
 *  A simple version of the Scrabble game where the user plays against the computer.
 *  @author  Megan Wang
 *  @version 9-23-15
 */
import java.util.Scanner;

public class ScrapplePlus {
	private WordUtilities uUtility, cUtility;
	private Prompt prompt;
	private int uScore, cScore;
	private String uTiles, cTiles;
	private boolean bonus;
	public int NUMTILES = 8;
	public int [] scores = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10,
					 1, 1, 1, 1, 4, 4, 8, 4, 10};
	private String tilesRemaining = "AAAAAAAAAABBCCDDDDEEEEEEEEEEEEEFFGGGHHIIIIIIIII" +
					 					"JKLLLLMMNNNNNNOOOOOOOOPPQRRRRRRSSSSTTTTTTUUUUVVWWXYYZ";
	// Constructor
	public ScrapplePlus() {
		uUtility = cUtility = new WordUtilities();
		prompt = new Prompt();
		uScore = cScore = 0;
		cTiles = uTiles = "";
	}
	
	public static void main(String [] args) {
		ScrapplePlus sp = new ScrapplePlus();
		sp.playGame();
	}
	/** plays game
	 * userTurn
	 * compTurn
	 * calls methods to generate tiles
	 * calls methods to calculate score of words
	 */
	public void playGame() {
		printIntroduction();
		boolean endOfGame = false;
		boolean playerTurn = true;
		boolean compTurn = false;
		do {
			String cWord = "", uWord = "";
			
			uTiles = getHand(uTiles);
			cTiles = getHand(cTiles);
			cWord = cUtility.bestWord(cUtility.findAllWords(cTiles.toLowerCase()), scores);
			System.out.println("\nHere are the tiles remaining in the pool of letters:\n");
			for (int i = 0; i < tilesRemaining.length(); i++) {
				if (i != 0 && i % 20 == 0) 
					System.out.print("\n");
				System.out.print(" " + tilesRemaining.charAt(i));
			}
			System.out.print("\n\n");
			System.out.println("Player Score: " + uScore);
			System.out.println("Computer Score: " + cScore);
			System.out.println("\nTHE TILES IN YOUR HAND ARE: " + uTiles + "\n");
			System.out.println("THE TILES IN THE COMPUTER HAND ARE: " + cTiles + "\n");
			
			if (uUtility.bestWord(uUtility.findAllWords(uTiles.toLowerCase()), scores) == "" || cWord == "") {
				System.out.println("No more words can be created.\n");
				System.out.println("Player score:      " + uScore);
				System.out.println("Computer score:    " + cScore);
				System.out.println("Thank you for playing ScrapplePlus!");
				break;
			}
			 
			uWord = prompt.getString("Please enter a word created from your current set of tiles");
			if (uWord.length() < 4 || uWord.length() > 8||!uUtility.wordMatch(uWord, uTiles.toLowerCase())) {
				break;
			}
			if(!uUtility.wordMatch(uWord, uTiles.toLowerCase())){
				endOfGame = true;
				break;
			}
			uScore += getUserScore(uWord);
			if(bonus){
				System.out.println("BONUS WORD SCORE!!!");
				bonus = false;
			}
			uTiles = editWord(uWord.toLowerCase(), uTiles.toLowerCase());
			uTiles = uTiles.toUpperCase();
			uTiles = getHand(uTiles);
			 
			System.out.println("\nHere are the tiles remaining in the pool of letters:\n");
			for (int i = 0; i < tilesRemaining.length(); i++) {
				if (i != 0 && i % 20 == 0) System.out.print("\n");
					System.out.print(tilesRemaining.charAt(i) + " ");
			}
			System.out.print("\n\n");
			System.out.println("Player Score: " + uScore);
			System.out.println("Computer Score: " + cScore);
			System.out.println("\nTHE TILES IN YOUR HAND ARE: " + uTiles + "\n");
			System.out.println("THE TILES IN THE COMPUTER HAND ARE: " + cTiles + "\n");

			Prompt.getString("It's the computer's turn. Hit ENTER on the keyboard to continue:");
			System.out.println("The computer chose: " + cWord);
			cScore += getCompScore(cWord);
			if(bonus){
				System.out.println("BONUS WORD SCORE!!!");
				bonus = false;
			}
			cTiles = editWord(cWord.toLowerCase(), cTiles.toLowerCase());
			cTiles = cTiles.toUpperCase();
			 
			if (tilesRemaining.length() < 1) 
				endOfGame = true;
		} while (!endOfGame);
	}
	/** generates random tiles
	 * deletes tiles from pool
	 * @return String tiles
	 */
	private String getHand(String currentHand) {
		String newHand;
		int i, cnt;
		String tile;
		
		newHand = currentHand;

		for (i = 0; i < NUMTILES-currentHand.length() && tilesRemaining.length() > 0; i++) {
			cnt = (int)(tilesRemaining.length()*Math.random());
			tile = tilesRemaining.substring(cnt, cnt+1);
			if (cnt == 0) 
				tilesRemaining = tilesRemaining.substring(cnt+1, tilesRemaining.length());
			else 
				tilesRemaining = tilesRemaining.substring(0, cnt-1) + tilesRemaining.substring(cnt, tilesRemaining.length());
			newHand = newHand + tile;
		}
		return newHand;
	}
	/** calculates user score
	 * @param user's word
	 * @return user score
	 */
	public int getUserScore(String word){
		int score = 0;
		score = uUtility.getScore(word, scores);
		if(uUtility.isDoubleLetter(word)||uUtility.isConsecutive(word)){
			bonus = true;
			return score*2;
		}
		else if(uUtility.isDoubleLetter(word)&&uUtility.isConsecutive(word)){
			bonus = true;
			return score*4;
		}
		return score;
	}
	/** calculates comp score
	 * @param comp's word
	 * @return comp score
	 */
	public int getCompScore(String word){
		int score = 0;
		score = cUtility.getScore(word, scores);
		if(cUtility.isDoubleLetter(word)||cUtility.isConsecutive(word)){
			bonus = true;
			return score*2;
		}
		else if(cUtility.isDoubleLetter(word)&& cUtility.isConsecutive(word)){
			bonus = true;
			return score*4;
		}
		return score;
	}
	public static String editWord(String word, String letters) {
		int cnt = 0;
	
		for(int i = 0; i<word.length(); i++){
			cnt = letters.indexOf(word.charAt(i));
			if(cnt == -1)
				return "";
			letters = letters.substring(0,cnt) + letters.substring(cnt+1); 
	    }
	   	return letters;
	}
	
	/**
	 *  Print the introduction screen for Scrapple.
	 */
	public void printIntroduction() {
		System.out.print(" _______     _______     ______     ______    ");
		System.out.println(" ______    ______   __          _______");
		System.out.print("/\\   ___\\   /\\  ____\\   /\\  == \\   /\\  __ \\   ");
		System.out.println("/\\  == \\  /\\  == \\ /\\ \\        /\\  ____\\");
		System.out.print("\\ \\___   \\  \\ \\ \\____   \\ \\  __<   \\ \\  __ \\  ");
		System.out.println("\\ \\  _-/  \\ \\  _-/ \\ \\ \\_____  \\ \\  __\\");
		System.out.print(" \\/\\______\\  \\ \\______\\  \\ \\_\\ \\_\\  \\ \\_\\ \\_\\ ");
		System.out.println(" \\ \\_\\     \\ \\_\\    \\ \\______\\  \\ \\______\\");
		System.out.print("  \\/______/   \\/______/   \\/_/ /_/   \\/_/\\/_/ ");
		System.out.println("  \\/_/      \\/_/     \\/______/   \\/______/ TM");
		System.out.println();
		System.out.print("This game is a modified version of Scrabble. ");
		System.out.println("The game starts with a pool of letter tiles, with");
		System.out.println("the following group of 100 tiles:\n");
		
		for (int i = 0; i < tilesRemaining.length(); i ++) {
			System.out.printf("%c ", tilesRemaining.charAt(i));
			if (i == 49) System.out.println();
		}
		System.out.println("\n");
		System.out.printf("The game starts with %d tiles being chosen at ran", NUMTILES);
		System.out.println("dom to fill the player's hand. The player must");
		System.out.printf("then create a valid word, with a length from 4 to %d ", NUMTILES);
		System.out.println("letters, from the tiles in his/her hand. The");
		System.out.print("\"word\" entered by the player is then checked. It is first ");
		System.out.println("checked for length, then checked to make ");
		System.out.print("sure it is made up of letters from the letters in the ");
		System.out.println("current hand, and then it is checked against");
		System.out.print("the word text file. If any of these tests fail, the game");
		System.out.println(" terminates. If the word is valid, points");
		System.out.print("are added to the player's score according to the following table ");
		System.out.println("(These scores are taken from the");
		System.out.println("game of Scrabble):");
		
		// Print line of letter scores
		char c = 'A';
		for (int i = 0; i < 26; i++) {
			System.out.printf("%3c", c);
			c = (char)(c + 1);
		}
		System.out.println();
		for (int i = 0; i < scores.length; i++) System.out.printf("%3d", scores[i]);
		System.out.println("\n");
		
		System.out.print("The score is doubled if the word has consecutive double ");
		System.out.println("letters (e.g. ball). The score can also");
		System.out.print("double if the first character of the word follows the ");
		System.out.println("first character of the last word entered");
		System.out.print("in alphabetical order (e.g. \"catnip\" gets ");
		System.out.println("regular score, followed by \"dogma\" which earns double");
		System.out.print("points). If the word contains both, then quadruple the ");
		System.out.println("points.\n");
		
		System.out.print("Once the player's score has been updated, more tiles are ");
		System.out.println("chosen at random from the remaining pool");
		System.out.printf("of letters, to fill the player's hand to %d letters. ", NUMTILES);
		System.out.println("The player again creates a word, and the");
		System.out.print("process continues. The game ends when the player enters an ");
		System.out.println("invalid word, or the letters in the");
		System.out.println("pool and player's hand run out. Ready? Let's play!\n");
		
		Prompt.getString("HIT ENTER on the keyboard to continue:");

	}
}