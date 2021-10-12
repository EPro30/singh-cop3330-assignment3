package ex44;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Scanner;

import com.google.gson.*;
import com.google.gson.JsonParser;

public class productSearch {

    static String name = "";
    static double price = 0.0;
    static int quantity =0;

    public static boolean isProduct(String nameInput) throws FileNotFoundException {

        JsonParser jsonParser = new JsonParser();
        FileReader file = new FileReader("src/main/java/ex44/exercise44_input.json");

        Object obj = jsonParser.parse(file);
        JsonObject jobj = (JsonObject)obj;

        JsonArray products = (JsonArray)jobj.get("products");

        Iterator<JsonElement> iterator = products.iterator();
        int i;
        boolean flag = false;

        for(i = 0; i < products.size(); i++)
        {
            JsonObject temp = (JsonObject) iterator.next();
            String tempName = temp.get("name").toString();
            tempName = tempName.replaceAll("\"","");
            double tempPrice = Double.parseDouble(temp.get("price").toString());
            int tempQuantity = Integer.parseInt(temp.get("quantity").toString());
            if(nameInput.compareTo(tempName) == 0)
            {
                name = tempName;
                price = tempPrice;
                quantity = tempQuantity;

                flag = true;
                break;
            }
        }
        return flag;
    }


    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the product name?");
        String nameInput = sc.nextLine();
        boolean flag = isProduct(nameInput);
        while(!flag)
        {
            System.out.println("Sorry, that product was not found in our inventory.");
            System.out.println("What is the product name?");
            nameInput = sc.nextLine();
            flag = isProduct(nameInput);
        }
        System.out.printf("Name: %s \nPrice: %.2f \nQuantity: %d ", name, price, quantity);
    }
}
