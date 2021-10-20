package ReadFromFile;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFromFile {

    public static void main(String[] args) {

        //*************************
        // Task 1
        //*************************
        File file = new File("data/demo.txt");

        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(file);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Du trænger til kaffe");
            System.exit(1);
        }

        while (fileScanner.hasNextLine()) {
            String tempString = fileScanner.nextLine();
            String[] stringArray = tempString.split(" ");
            for (String string: stringArray) {
                if (string.length() > 4){
                    string = string.toUpperCase();
                }
                System.out.print(string + " ");
            }
            System.out.println();
        }


        //*************************
        // Task 2
        //*************************
        File DMIFile = new File("data/DMI2.txt");

        Scanner DMIScanner = null;
        try {
            DMIScanner = new Scanner(DMIFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int count = 0;
        int sum = 0;
        ArrayList<String> cities = new ArrayList<>();
        while(DMIScanner.hasNextLine()){
            // save the line from scanner
            String string = DMIScanner.nextLine();

            // get int from the string
            String tempString = string.substring(string.indexOf(' ') + 1);
            int tempInt = Integer.parseInt(tempString);
            count++;
            sum += tempInt;

            // get city name from string
            String cityName = string.substring(0, string.indexOf(' '));

            // check if city is in the array
            boolean containsCity = false;
            for (String city : cities) {
                if (city.equals(cityName)) {
                    containsCity = true;
                    break;
                }
            }
            // add city to array if not already in array
            if (!containsCity)cities.add(cityName);
        }

        System.out.println("Average temperature: " + sum/count);
        System.out.println(cities);
    }
}
