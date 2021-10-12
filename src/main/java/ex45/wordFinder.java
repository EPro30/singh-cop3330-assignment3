package ex45;

import java.io.*;
import java.util.Scanner;

public class wordFinder {

    public static void modifyFile(String path, String oldString, String newString) throws IOException {
        File file = new File(path);
        StringBuilder oldText = new StringBuilder();
        BufferedReader reader;
        FileWriter writer = null;

        reader = new BufferedReader(new FileReader(file));

        String line = reader.readLine();

        while(line != null)
        {
            oldText.append(line).append(System.lineSeparator());
            line = reader.readLine();

            String newText = oldText.toString().replaceAll(oldString, newString);

            writer = new FileWriter("src/main/java/ex45/exercise45_output.txt");
            writer.write(newText);
        }
        reader.close();
        if (writer != null) {
            writer.close();
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter the name of the File (with .txt extension):");
        String fileName = sc.next();
        String path = "src/main/java/ex45/" + fileName;
        modifyFile(path,"utilize", "use");
    }
}
