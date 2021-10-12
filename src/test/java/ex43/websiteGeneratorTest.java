package ex43;

import ex46.wordFrequencyFinder;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class websiteGeneratorTest {
    @Test
    public void check() throws FileNotFoundException {
        String path = websiteGenerator.website("src/main/java/ex43\"");
        File file1 = new File(path);
        assertTrue(file1.isFile());


    }

}