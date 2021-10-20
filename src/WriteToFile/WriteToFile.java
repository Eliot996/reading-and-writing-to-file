package WriteToFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class WriteToFile {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("data/output.txt");

        PrintStream printStream = new PrintStream(new FileOutputStream(file, true));

        for (int j = 0; j < 100; j++) {
            for (int i = 1; i <= 5; i++) {
                printStream.append(Integer.toString(i));
            }
            printStream.println();
        }
        printStream.close();
    }

}
