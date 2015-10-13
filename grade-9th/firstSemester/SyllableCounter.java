//Megan Wang
//11-26-14
//SyllableCounter counts the number of syllables in a sentence
//Testing plan
//Should work:"Sally where are you going", 
//Should not work: 1, 4782391, true, -91312

import java.util.Scanner; //import Scanner
public class SyllableCounter{ //class header
	public static String sentence = "";
	public static String word = "";
	public static int syllables= 0; //declare and initialize global variables
	
	public static void main(String[]args){//main header
		input();//call input method
		sentenceSplitter();//call syllableCounter method
		printSyllables();
	}
	public static void printSyllables(){
		System.out.println("There are " + syllables + " syllables in this sentence.");
	}	
	public static void input(){ //input method
		Scanner x = new Scanner(System.in);//create instance of scanner
		System.out.println("Please enter your word or sentence, followed by a carriage return");
		sentence = x.nextLine();//read user input and save into variable
	}
	public static void sentenceSplitter(){
		int start=0;
		int i = 0;
		while(i < sentence.length()){
			if(sentence.charAt(i)==' '||i== (sentence.length()-1)){
				if(i== (sentence.length()-1))
					word = sentence.substring(start);
				else
					word = sentence.substring(start, i);
				wordReader();
				start = i+1;
				i++;
			}else
				i++; 
		}
	}
	public static void wordReader(){ 
		if (word.charAt(0) == 'y'){
			word = word.substring(1,(word.length()));
			vowelCalculate();
		}
		else if (word.charAt(word.length()-1) == 'e' && !word.equalsIgnoreCase("she") && !word.equalsIgnoreCase("he") 
				&& !word.equalsIgnoreCase("the")){
			word = word.substring(0,(word.length()-1));
			vowelCalculate();
		}
		else{
			vowelCalculate();
		}
	}
	public static boolean isVowel(char c){
		if (c == 'a'||c == 'e'||c == 'i'||c == 'o'||c == 'u'||c=='y'
			||c == 'A'||c == 'E'||c == 'I'||c == 'O'||c == 'U'||c=='Y')
			return true;
		else
			return false;
		
	}
	public static int twoVowels(String vowels){
		if(vowels.equalsIgnoreCase("ei")||vowels.equalsIgnoreCase("ie")||vowels.equalsIgnoreCase("ea")
			||vowels.equalsIgnoreCase("ou")||vowels.equalsIgnoreCase("ey")||vowels.equalsIgnoreCase("ay")
			||vowels.equalsIgnoreCase("oy")||vowels.equalsIgnoreCase("uy")||vowels.equalsIgnoreCase("ai"))
			return 1;
		else
			return 2;
	}
	
	public static int threeVowels(String vowels){
		if(vowels.equalsIgnoreCase("eau")||vowels.equalsIgnoreCase("iou"))
			return 1;
		else
			return 2;
	}
	
	public static void vowelCalculate(){
		int i = 0;
		if(word.length()==1){
			if (isVowel(word.charAt(0))==true)
				syllables++;
			return;
		}
		if(word.length()==2){
			if (isVowel(word.charAt(0))==true){
				if (isVowel(word.charAt(1))==true)
					syllables += twoVowels(word);
				else
					syllables++;
			}else if(isVowel(word.charAt(1))==true){
				syllables++;
			}
			return;
		}
			
		while(i < word.length()){
			if (isVowel(word.charAt(i))==true){
				if(i == (word.length()-1)){
					syllables++;
					return;
				}
				if(isVowel(word.charAt(i+1))==true){
					if((i+1)==(word.length()-1)){
						syllables += twoVowels(word.substring(i));
						return;
					}
					if(isVowel(word.charAt(i+2))==true){
						if((i+2)==(word.length()-1)){
							syllables += threeVowels(word.substring(i));
							return;
						}
						syllables += threeVowels(word.substring(i,i+3));
						i+=3;
					}else{
						syllables += twoVowels(word.substring(i,i+2));
						i+=2;
					}
				}else{
					syllables ++;
					i++;
				}
			}else
				i++;
		}
	}
}		

