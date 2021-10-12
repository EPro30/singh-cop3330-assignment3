package ex46;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class wordFrequencyFinderTest {
    @Test
    public void frequencyChecker() throws FileNotFoundException {
        ArrayList<Integer> sortedlist = new ArrayList<>();
        //sortedlist.add(17); //uncomment this line to test assertFalse
        sortedlist.add(7); //comment this line to test assertFalse
        sortedlist.add(2);
        sortedlist.add(1);
        int i;
        boolean ret = false;
        wordFrequencyFinder.findFrequentWords();
        for (i = 0; i < sortedlist.size(); i++) {
            if (sortedlist.contains(wordFrequencyFinder.frequency.get(i)))
                ret = true;
            else {
                ret = false;
                break;
            }
        }
        //assertFalse(ret); //uncomment this line to test assertFalse
        assertTrue(ret); //comment this line to test assertFalse
    }
}
