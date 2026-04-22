package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class AdventureTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        loadAdventure();
    }

    public static void loadAdventure() {


        try {
            FileReader fileReader = new FileReader("adventure1.csv");
            BufferedReader reader = new BufferedReader(fileReader);

            String line = reader.readLine();

            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }


        } catch (IOException e) {
            System.out.println("Error: File not found or cannot be read.");
        }

    }
}
