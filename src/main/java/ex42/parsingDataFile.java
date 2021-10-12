/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Riya Singh
 */

package ex42;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class parsingDataFile
{

    static ArrayList<String> info = new ArrayList<>();
    static ArrayList<String> firstNames = new ArrayList<>();
    static ArrayList<String> lastNames = new ArrayList<>();
    static ArrayList<Integer> salary = new ArrayList<>();

    public static void setInfo() throws FileNotFoundException {
        File inputFile = new File("src/main/java/ex42/exercise42_input.txt");
        Scanner sc = new Scanner(inputFile);

        while(sc.hasNextLine())
        {
            info.add(sc.nextLine());
        }

        /*for(String str:info)
            System.out.println(str);*/
    }

    public static void setData()
    {
        int i = 0;

        for(String c: info)
        {
            String[] temp = c.split(",");
            lastNames.add(temp[0]);
            firstNames.add(temp[1]);
            salary.add(Integer.parseInt(temp[2]));
        }
    }

    public static void print()
    {
       int len = info.size();
       int i;
       System.out.printf("%-10s %-10s %s", "Last", "First", "Salary");
       System.out.println("\n-----------------------------");
       for(i = 0; i < len; i++)
       {
           System.out.printf("%-10s %-10s %d\n", lastNames.get(i), firstNames.get(i), salary.get(i));
       }
    }

    public static void main(String[] args) throws IOException {
        setInfo();
        setData();
        print();
    }
}
