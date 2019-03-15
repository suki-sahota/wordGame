/*
 * Suki Sahota
 * Description: Word Game
 */
import java.io.*;
import java.util.*;
public class WordGame {

    public static void main(String[] args) throws IOException {
        String[] correct = new String[20];
        String[] incorrect = new String[20];
        fillArray(correct, incorrect);
        description();
        play(correct, incorrect);
    }
    
    
    public static void description() {
        System.out.println("There are two different lists of words. One list is full of \ncorrectly spelled words while the other is filled with misspelled \nwords. Your task is to guess which of the randomly generated \nwords are spelled correctly. You earn one point for guessing \ncorrectly and lose a point for guessing incorrectly.\nLet's Begin!\n\n");
    }
    
    
    public static void fillArray(String[] correct, String[] incorrect) throws IOException {
        // Locate file
        File f1 = new File("wordRight.txt");
        File f2 = new File("wordWrong.txt");
        // Create point to the file
        Scanner input1 = new Scanner(f1);
        Scanner input2 = new Scanner(f2);
        
        // Filling correctly spelled array
        for (int i = 0; i < 20; i++) {
            if (input1.hasNext()) {
                correct[i] = input1.next();
            }
        // Filling incorrectly spelled array
        } for (int i = 0; i < 20; i++) {
            if (input2.hasNext()) {
                incorrect[i] = input2.next();
            }
        }
    }
    
    
    public static void play(String[] correct, String[] incorrect) throws IOException {
        Scanner console = new Scanner(System.in);
        Random rand = new Random();
        String answer = "";
        int points = 0;
        String playAgain = "y";
        int index = rand.nextInt(20);
        while (playAgain.equalsIgnoreCase("y")) {
        
            for (int i = 1; i <= 5; i++) {

                // Loop for correctly spelled array
                if (rand.nextBoolean()) {
                    index = rand.nextInt(20);
                    // Validation loop to ensure new words
                    while (correct[index].equalsIgnoreCase("null")) {
                        index = rand.nextInt(20);
                    } 
                    System.out.println("The word is: " + correct[index]);
                    System.out.print("Is this word misspelled? y/n ");
                    answer = console.next();
                    // User guess data validation
                    while (!(answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("n"))) {
                        System.out.print("Please enter \"n\" or \"y\" ");
                        answer = console.next();
                    } 
                    if (answer.equalsIgnoreCase("n")) {
                        points++;
                        System.out.println("Correct!");
                    } else if (answer.equalsIgnoreCase("y")) {
                        points--;
                        System.out.println("Incorrect!");
                    }
                    correct[index] = "null";
                } 
                
                // Loop for incorrectly spelled array
                else {
                    index = rand.nextInt(20);
                    // Validation loop to ensure new words
                    while (incorrect[index].equalsIgnoreCase("null")) {
                        index = rand.nextInt(20);
                    }
                    System.out.println("The word is: " + incorrect[index]);
                    System.out.print("Is this word misspelled? y/n ");
                    answer = console.next();
                    // User guess data validation
                    while (!(answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("n"))) {
                        System.out.print("Please enter \"n\" or \"y\" ");
                        answer = console.next();
                    } 
                    if (answer.equalsIgnoreCase("y")) {
                        points++;
                        System.out.println("Correct!");
                    } else if (answer.equalsIgnoreCase("n")) {
                        points--;
                        System.out.println("Incorrect!");
                    } 
                    incorrect[index] = "null";
                }
            }
            System.out.println("\n\nYou've played 5 times, give someone else a turn!");
            System.out.println("You got " + points + " points.");
            points = 0;
            System.out.print("Type 'y' if you would like to play again, and 'n' if not.");
            playAgain = console.next();
            // User choice data validation
            while (!(playAgain.equalsIgnoreCase("y") || playAgain.equalsIgnoreCase("n"))) {
                System.out.print("Please enter \"n\" or \"y\".");
                playAgain = console.next();
            }
        }
    }
}
