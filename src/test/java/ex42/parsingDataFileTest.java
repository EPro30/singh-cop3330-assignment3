package ex42;

import ex44.productSearch;
import ex46.wordFrequencyFinder;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class parsingDataFileTest {

    @Test
    public void check1() throws FileNotFoundException {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(55900);
        list.add(56500);
        list.add(46000);
        list.add(34500);
        list.add(14200);
        list.add(65000);
        list.add(51500); //comment this line to test assetFalse
        //list.add(89898); //uncomment this line to test assertFalse
        boolean ret = false;
        int i;
        parsingDataFile.setInfo();
        parsingDataFile.setData();
        for (i = 0; i < list.size(); i++) {
            if (list.contains(parsingDataFile.salary.get(i)))
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