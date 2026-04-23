package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class AdventureTime {
        static ArrayList<AdventureStep> Steps = new ArrayList<>();

        static Scanner scanner = new Scanner(System.in);
        static void main() {
            Steps = loadAdventure();
            homeScreen();

    }
        public static void homeScreen() {
            System.out.println("Welcome to Adventure Time.");
            System.out.println("--------------------------");
            System.out.println("press (P) to play: ");
            System.out.println("press (Q) to quit: ");

            String choice = scanner.nextLine().toUpperCase();

            if (choice.equals("P")) {
                gameScreen(1);
            }

        }


    public static void gameScreen(int id) {
        for (int i = 0; i < Steps.size(); i++) {
            AdventureStep adventureStep = Steps.get(i);
            if (adventureStep.getId() == id) {
                System.out.println("Story Text: " + adventureStep.getStoryText());
                System.out.println();
                System.out.println("1) " + adventureStep.getOption1Text());
                System.out.println();
                System.out.println("2) " + adventureStep.getOption2Text());
            }
        }
    }
    public static ArrayList<AdventureStep> loadAdventure()
    {

        try
        {
            FileReader fileReader = new FileReader("adventure1.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();

            line = bufferedReader.readLine();

            while (line != null){
                //System.out.println(line);

                String [] columns = line.split("\\|");

                int id = Integer.parseInt(columns[0]);
                String storyText = columns[1];
                String option1Text = columns[2];
                int option1NextId = Integer.parseInt(columns[3]);
                String option2Text = columns[4];
                int option2NextId = Integer.parseInt(columns[5]);


                AdventureStep adventureStep = new AdventureStep(id, storyText, option1Text, option1NextId, option2Text, option2NextId);
                Steps.add(adventureStep);
                //System.out.println(step.getStoryText());

                line = bufferedReader.readLine();
            }

            fileReader.close();

        }
        catch (Exception e){
            System.out.println("e");

        }

        return Steps;
    }

}


