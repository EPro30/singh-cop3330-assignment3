package ex45;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class wordFinderTest {


    //Please add the expected output in exercise45_expectedOutput.txt and update the file path
    @Test
    public void check1() throws IOException
        {
            String path1 = "src/main/java/ex45/exercise45_input.txt";
            wordFinder.modifyFile(path1, "utilize", "use");
            String path3 = "src/main/java/ex45/exercise45_output.txt";
            String path2 = "src/test/java/ex45/exercise45_expectedOutput";
            BufferedReader file1 = new BufferedReader(new FileReader(path3));
            BufferedReader file2 = new BufferedReader(new FileReader(path2));

            String line1 = file1.readLine();
            String line2 = file2.readLine();

            boolean ret = true;
            int lineNum = 1;

            while (line1 != null || line2 != null)
            {
                if(line1 == null || line2 == null)
                {
                    ret = false;
                    break;
                }
                else if(! line1.equalsIgnoreCase(line2))
                {
                    ret = false;
                    break;
                }

                line1 = file1.readLine();
                line2 = file2.readLine();

                lineNum++;
            }
            file1.close();
            file2.close();

            assertTrue(ret);
        }
}
