import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
public class Hangman {

	private int numwords = 10, incorrectGuesses = 0;
	private String[] words = new String[numwords];
	private String gameWord, incorrectGuessesList = "", word;
	private char[] dispArr = {'-','-','-','-','-','-','-'};

	
	/*Method to display the hangman given the number of body parts to show
	 * Player gets at most 10 turns. */
	public void showMan(int numParts)
	{

		if (numParts == 0){	
			System.out.println("________");
			System.out.println("|       |");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("____");
		}
		if (numParts == 1){	
			System.out.println("________");
			System.out.println("|       |");
			System.out.println("|      ____");
			System.out.println("|     / .. \\");
			System.out.println("|    <   .  >");
			System.out.println("|     \\__^_/");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("____");
		}
		if (numParts == 2){	
			System.out.println("________");
			System.out.println("|       |");
			System.out.println("|      ____");
			System.out.println("|     / .. \\");
			System.out.println("|    <   .  >");
			System.out.println("|     \\__^_/");
			System.out.println("|        |");
			System.out.println("|        |");
			System.out.println("|        |");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("____");
		}

		if (numParts == 3){	
			System.out.println("________");
			System.out.println("|       |");
			System.out.println("|      ____");
			System.out.println("|     / .. \\");
			System.out.println("|    <   .  >");
			System.out.println("|     \\__^_/");
			System.out.println("|        |");
			System.out.println("|      __|");
			System.out.println("|        |");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("____");
		}
		if (numParts == 4){	
			System.out.println("________");
			System.out.println("|       |");
			System.out.println("|      ____");
			System.out.println("|     / .. \\");
			System.out.println("|    <   .  >");
			System.out.println("|     \\__^_/");
			System.out.println("|        |");
			System.out.println("|     o__|");
			System.out.println("|     	 |");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("____");
			}
		if (numParts == 5){
			
			System.out.println("________");
			System.out.println("|       |");
			System.out.println("|      ____");
			System.out.println("|     / .. \\");
			System.out.println("|    <   .  >");
			System.out.println("|     \\__^_/");
			System.out.println("|        |");
			System.out.println("|     o__|__");
			System.out.println("|     	 |");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("____");
			}
		if (numParts == 6){
			
			System.out.println("________");
			System.out.println("|       |");
			System.out.println("|      ____");
			System.out.println("|     / .. \\");
			System.out.println("|    <   .  >");
			System.out.println("|     \\__^_/");
			System.out.println("|        |");
			System.out.println("|     o__|__o");
			System.out.println("|     	 |");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("____");
			}
		if (numParts == 7){
			
			System.out.println("________");
			System.out.println("|       |");
			System.out.println("|      ____");
			System.out.println("|     / .. \\");
			System.out.println("|    <   .  >");
			System.out.println("|     \\__^_/");
			System.out.println("|        |");
			System.out.println("|     o__|__o");
			System.out.println("|     	 |");
			System.out.println("|       /");
			System.out.println("|      /  ");
			System.out.println("|");
			System.out.println("|");
			System.out.println("____");
			}
			
		if (numParts == 8){
			
			System.out.println("________");
			System.out.println("|       |");
			System.out.println("|      ____");
			System.out.println("|     / .. \\");
			System.out.println("|    <   .  >");
			System.out.println("|     \\__^_/");
			System.out.println("|        |");
			System.out.println("|     o__|__o");
			System.out.println("|     	 |");
			System.out.println("|       / \\");
			System.out.println("|      /   \\");
			System.out.println("|");
			System.out.println("|");
			System.out.println("____");
			}
			
		if (numParts == 9){
				
			System.out.println("________");
			System.out.println("|       |");
			System.out.println("|      ____");
			System.out.println("|     / .. \\");
			System.out.println("|    <   .  >");
			System.out.println("|     \\__^_/");
			System.out.println("|        |");
			System.out.println("|     o__|__o");
			System.out.println("|     	 |");
			System.out.println("|       / \\");
			System.out.println("|      /   \\");
			System.out.println("|    O/    ");
			System.out.println("|");
			System.out.println("____");
		
		}
		if (numParts == 10){
			
		System.out.println("________");
		System.out.println("|       |");
		System.out.println("|      ____");
		System.out.println("|     / .. \\");
		System.out.println("|    <   .  >");
		System.out.println("|     \\__^_/");
		System.out.println("|        |");
		System.out.println("|     o__|__o");
		System.out.println("|     	 |");
		System.out.println("|       / \\");
		System.out.println("|      /   \\");
		System.out.println("|    O/     \\O");
		System.out.println("|");
		System.out.println("____");
		}
		
	}
	
	/**
	  Sets the list of candidate words for the player to guess
	**/
	public void setDefaultWords()
	{
		
		this.words[0] = "notions";
		this.words[1] = "measure";
		this.words[2] = "product";
		this.words[3] = "foliage";
		this.words[4] = "garbage";
		this.words[5] = "minutes";
		this.words[6] = "chowder";
		this.words[7] = "recital";
		this.words[8] = "concoct";
		this.words[9] = "brownie";		
	}
	
	
	/*********************************************************
	 * Below are the setter and getter methods for this class. 
	 * You may not need to use methods but they are included
	 * since it is good practice to have them.
	 *********************************************************/

	/*
	 * Sets the number of words
	 */
	public void setNumWords(int num)
	{
		this.numwords = num;
	}
	
	
	/*
	 * Returns the number of words
	 */
	public int getNumWords()
	{
		return this.numwords;
	}
	

	/*
	 * Sets words array
	 */
	public void setWords(String[] words)
	{
		this.words = words;
	}
	
	
	/*
	 * Returns the number of words
	 */
	public String[] getWords()
	{
		return this.words;
	}

	
	/*
	 * Sets the game word
	 */
	public void setGameWord(String w)
	{
		this.gameWord = w;
	}
	
	
	/*
	 * Returns the game word
	 */
	public String getWord()
	{
		return this.gameWord;
	}


	/*
	 * Sets dispArr
	 */
	public void setDispArr(char[] dA)
	{
		this.dispArr = dA;
	}
	
	
	/*
	 * Returns dispArr
	 */
	public char[] getdispArr()
	{
		return this.dispArr;
	}
	
	//selects the game word
	public void selectGameWord() {
		Random ran = new Random();
		int i = ran.nextInt(10);
		gameWord = words[i];
		}
	
	//returns the current word
	public void processGuessL(char guess) {
		char guess_lower = Character.toLowerCase(guess);
		String word = new String(dispArr);
		System.out.println(word);
		for(int i = 0; i<gameWord.length(); i++) {
			if(gameWord.charAt(i) == guess_lower) {
				dispArr[i] = guess;
				System.out.println("Correct!");
			}
			
			}
		 if (!gameWord.contains(Character.toString(guess_lower))) {
			 incorrectGuesses++;
			 System.out.println("Incorrect!");
			 incorrectGuessesList += Character.toString(guess_lower).toUpperCase();
		 }

		}
	public void processGuessW(String guess) {
		//processes the user's word guess
		String word = Arrays.toString(dispArr);
		if(word == guess) {
			System.out.println("You win!");
		}
		else {
			incorrectGuesses = 10;
			System.out.println("You Lose!");
		}
		
	}
	
	
	public String getCurrentWord() {
		// gets the current word
		String word = new String(dispArr);
		return word;
	}
	
	
		
	
	public int getnumIncorrectGuesses() {
		//returns the number of incorrect guesses
		return incorrectGuesses;
		
	}
	
	
	public String getIncorrectGuesses() {
		//returns the letters which have been incorrectly guessed
		return incorrectGuessesList;
		
	}


	
	
	
}