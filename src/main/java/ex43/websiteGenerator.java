package ex43;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class websiteGenerator {
    static Scanner sc = new Scanner(System.in);

    public static String setName()
    {
        System.out.println("Site name: ");
        return sc.nextLine();
    }

    public static String setAuthor()
    {
        System.out.println("Author:");
        return sc.nextLine();
    }
    public static String setInitialPath()
    {
        return "src/main/java/ex43";
    }

    public static String website(String initialPath, String name)
    {
        return initialPath+"/website/"+name;
    }

    public static String websiteHTML(String initialPath)
    {
        return initialPath+"/index.html";
    }

    public static String websiteJS(char input, String initialPath) throws IOException {
        String path = initialPath;
        if(input == 'y' || input == 'Y')
        {
            path = path+"/js/";
            createFile(path);
        }
        return path;
    }

    public static String websiteCSS(char input, String initialPath) throws IOException {
        String path = initialPath;
        if(input == 'y' || input == 'Y')
        {
            path = path+"/css/";
            createFile(path);
        }
        return path;
    }

    public static void createFolder(String path) throws IOException {
        //Creating a File object
        File file = new File(path);
        //Creating the directory
        if(file.mkdirs())
            print("created" + path);
    }

    public static void createFile(String path) throws IOException
    {
        File file = new File(path);
        //Creating the directory
        file.createNewFile();
        if(file.isFile())
            print("created" + path);
    }

    public static void createHTML(String name, String author, String path) throws IOException
    {
        File file = new File(path);
        //Creating the directory
        file.createNewFile();
        htmlInput(name, author, path);
        if(file.isFile())
            print("created" + path);
    }

    public static void htmlInput(String name, String author, String path)
    {
        String html ="<div><title>" + name+"</title><h1><meta> " + author +"</meta></h1></div>";
        File file = new File(path);

        try
        {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(html);
            bw.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void print(String msg)
    {
        System.out.println(msg);
    }

    public static void main(String[] args) throws IOException {
        //Prompting for input
        String name = setName();
        String author = setAuthor();
        char jsInput, cssInput;
        System.out.println("Do you want a folder for JavaScript?");
        jsInput = sc.next().charAt(0);
        System.out.println("Do you want a folder for CSS?");
        cssInput = sc.next().charAt(0);

        //Setting paths for different files and folders
        String inititalPath = setInitialPath();
        String websiteWithName = website(inititalPath, name);
        String websiteHTML = websiteHTML(websiteWithName);
        createFolder(inititalPath);
        createFolder(websiteWithName);
        createHTML(name, author, websiteHTML);
        String jsPath = websiteJS(jsInput,websiteWithName);
        String cssPAth = websiteCSS(cssInput, websiteWithName);
    }
}
