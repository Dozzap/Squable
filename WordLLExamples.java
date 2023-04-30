/*
 * Main program
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class WordLLExamples {
	private static Scanner scan;
	private static final int NUMBER_OF_WORDS = 2992; // Number of possible mystery words
	private static String[] mysteryWord = new String[NUMBER_OF_WORDS];

	/* Read input file 'words' that contains about 3000 mystery words */
	public static void readMysteryWords(String filename) {
		try {
			File myObj = new File(filename);
			Scanner myReader = new Scanner(myObj);
			int i = 0;
			while (myReader.hasNextLine()) {
				mysteryWord[i++] = myReader.nextLine();
				// System.out.println(mysteryWord[i-1]);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred opening file \'words\'.");
			e.printStackTrace();
		}
	}

	public static int pick(int n) { // return an random choice 0-(n-1)
		return (int) Math.floor(Math.random() * n);
	}

	public static void main(String[] args) {
		scan = new Scanner(System.in, "UTF-8");

		readMysteryWords("words");
		System.out.println("Welcome to Squable!");
		playEnglish();

		System.out.println("Thanks for playing!");
	}

	/* Play WordLL with words of varying lengths */
	public static void playEnglish() {
		String randomWord = mysteryWord[pick(mysteryWord.length)].toUpperCase();
		Word mystery = new Word(Letter.fromString(randomWord));
		String message = "Enter a word of length " + randomWord.length() + " (XX to stop):";

		WordLL wll = new WordLL(mystery);

		System.out.print(message);
		String wordStr = scan.next().toUpperCase();
		while (!wordStr.equals("XX")) {
			Word word = new Word(Letter.fromString(wordStr));
			if (wll.tryWord(word)) {
				System.out.println("Success!");
				wordStr = "XX";
			} else {
				System.out.println(wll);
				System.out.print(message);
				wordStr = scan.next().toUpperCase();
			}
		}
	}

}
