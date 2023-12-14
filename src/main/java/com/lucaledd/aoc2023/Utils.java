package com.lucaledd.aoc2023;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utils {
    public static List<String> readFile(@NotNull String filename) {
        final List<String> lines = new ArrayList<>();

        try {
            File fileObj = new File("src/" + filename);
            Scanner reader = new Scanner(fileObj);

            while(reader.hasNextLine()) {
                String data = reader.nextLine();
                lines.add(data);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading the file");
            e.printStackTrace();
        }

        return lines;
    }
}
