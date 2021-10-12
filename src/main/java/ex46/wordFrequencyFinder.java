package ex46;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class wordFrequencyFinder {
    static ArrayList<String> frequentWords = new ArrayList<>();
    static ArrayList<String> words = new ArrayList<>();
    static ArrayList<Integer> frequency = new ArrayList<>();
    static ArrayList<String> stringFrequency = new ArrayList<>();

    public static void findFrequentWords() throws FileNotFoundException
    {
        File inputFile = new File("src/main/java/ex46/exercise46_input.txt");
        Scanner sc = new Scanner(inputFile);

        while(sc.hasNextLine())
        {
            words.add(sc.next());
        }

        int i;
        for(i = 1; i < words.size(); i++)
        {
            if(!(frequentWords.contains(words.get(i))))
            {
                frequentWords.add(words.get(i));
            }
        }
        findFrequency();
    }

    public static void findFrequency()
    {
      int i, j, count = 0;
      for(i = 0; i < frequentWords.size(); i++)
      {
          for(j = 0; j < words.size(); j++)
          {
              if(frequentWords.get(i).compareTo(words.get(j)) == 0)
              {
                  count = count+1;
              }
          }
          frequency.add(count);
          count = 0;
      }

      for(int c: frequency)
          stringFrequency.add(String.valueOf(c));
        sortF();
        getIndex();
    }

    public static void sortF()
    {
        Collections.sort(frequency, Collections.reverseOrder());
    }


    public static int findLongestWord()
    {
        int maxLen = frequentWords.get(0).length();
        int i;
        for(i = 1; i < frequentWords.size(); i++)
            maxLen = (frequentWords.get(i).length() > maxLen) ? frequentWords.get(i).length() : maxLen;
        return maxLen;
    }

    public static void getIndex()
    {
        int k, index;
        ArrayList<Integer> temp = new ArrayList<>();
        for(k = 0; k < frequency.size(); k++) {
            index = stringFrequency.indexOf(String.valueOf(frequency.get(k)));
            if(temp.contains(index) )
            {
                index = stringFrequency.lastIndexOf(String.valueOf(frequency.get(k)));
                //index++;
            }
            print(index);
            temp.add(index);
        }
    }

    public static void print(int index)
    {
        int len = findLongestWord();
        int curLen, j,n;
        System.out.printf("%s:", frequentWords.get(index));
        curLen = (len - frequentWords.get(index).length()) + 1;
        String spaces = String.format("%" + curLen + "s", " ");
        System.out.format(spaces);
        n = Integer.parseInt(stringFrequency.get(index));
        for (j = 0; j < n; j++)
            System.out.print("*");
        System.out.println();
    }

    public static void main(String[]args) throws FileNotFoundException {
        findFrequentWords();
    }

}
