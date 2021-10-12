/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Riya Singh
 */
package ex41;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class nameSorter {

    static ArrayList<String> names = new ArrayList<>();

    public static void set() throws FileNotFoundException {
        File inputFile = new File("src/main/java/ex41/exercise41_input.txt");
        Scanner sc = new Scanner(inputFile);

        while(sc.hasNextLine())
        {
           names.add(sc.nextLine());
        }
    }

    public static void sort()
    {
        Collections.sort(names);
    }

    public static void print() throws java.io.IOException
    {
        FileWriter outputFile = new FileWriter("src/main/java/ex41/exercise41_output.txt");
        outputFile.write("Total of " + names.size() + " names");
        outputFile.write("\n-----------------\n");

        for(String c: names)
            outputFile.write(c + "\n");

        outputFile.close();
    }

    public static void main(String[] args) throws IOException {
        set();
        sort();
        print();
    }
}
