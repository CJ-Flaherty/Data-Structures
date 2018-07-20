import java.util.Scanner;
public class HangmanDriver {

	
	public static void main(String Args[]) {
		Hangman game = new Hangman();
		game.setDefaultWords();
		game.selectGameWord();
		System.out.println(game.getCurrentWord());
		game.showMan(game.getnumIncorrectGuesses());
		System.out.println(game.getnumIncorrectGuesses());
		while(game.getnumIncorrectGuesses() < 10) { //processGuessW in hangman class sets numIncorrectGuesses to 10
													//if an incorrect word is guessed
			String c = getChoice();
			if (c.equals("L") || c.equals("l")) {
				char g = getGuessL();
				game.processGuessL(g);
				System.out.println(game.getCurrentWord());
				game.showMan(game.getnumIncorrectGuesses());
				System.out.println(game.getIncorrectGuesses());
				}
			if (c.equals("W") || c.equals("w")) {
				String w = getGuessW();
				game.processGuessW(w);
				System.out.println(game.getCurrentWord());
				game.showMan(game.getnumIncorrectGuesses());
				System.out.println(game.getIncorrectGuesses());
				playAgain();
				
				
		}
		
			
			
		
	}
		System.out.println("You Lose!");
		playAgain();

}

	private static String getChoice() {
		//allows the user to guesss a letter or a word
		Scanner scan = new Scanner(System.in);
		System.out.println("Type L to guess a letter or W to guess a word: ");
		return scan.nextLine();
		
		
		
		
	}
	private static String getGuessW() {
		//takes in the users word guess
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your guess (as a word):");
		return scan.nextLine();
	}
	
	private static char getGuessL() {
		//takes in the users letter guess, converts to a char
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your guess (as a letter):");
		String guess = scan.nextLine();
		char char_guess = guess.charAt(0);
		return char_guess;
		
	}
	private static void playAgain() {
		//prompts the user to play again, if yes runs main, if no exits
		Scanner scan = new Scanner(System.in);
		System.out.println("Would you like to play again? (y/n)");
		String playchoice = scan.nextLine();
		if(playchoice.equals("y")) {
			main(null);
		}
		if(playchoice.equals("n")) {
			System.out.println("Thanks for Playing!");
			System.exit(0);
		}
	}

	
}