package WriteToFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class WriteToFile {

    public static void main(String[] args) {

        //guessNumber();

        writeToFile();

    }

    public static void guessNumber(){
        // generate a random number between 1-5
        int number = (int) Math.ceil(Math.random()*5);

        Scanner input = new Scanner(System.in);
        File file = new File("data/guesses.txt");

        // get guess and increment the counter, if it is not the same as the number go again
        int guess;
        int guessCount = 0;
        do {
            System.out.println("Guess the number between 1 - 5");
            guess = input.nextInt();
            guessCount++;
        }while(guess != number);

        // print the number and number of tries
        System.out.println("Yes, the number was " + number);
        System.out.println("You used " + guessCount + " tries");

        try {
            // make printStream and append to what is in the file
            PrintStream printStream = new PrintStream(new FileOutputStream(file, true));
            printStream.append(Integer.toString(guessCount)).append("\n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void writeToFile(){
        Scanner input = new Scanner(System.in);

        // get the desired file name, and make or get the file
        System.out.print("What should the file be called? ");
        String fileName = input.nextLine();
        File file = new File("data/" + fileName + ".txt");

        // get text to put into the file
        System.out.println("What text do you want to save in the file? ");
        String stringToSave = input.nextLine();

        try {
            // print to file
            PrintStream printStream = new PrintStream(file);
            printStream.print(stringToSave);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

}
