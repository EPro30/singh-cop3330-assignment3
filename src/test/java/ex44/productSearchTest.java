package ex44;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class productSearchTest {

    @Test
    public void isProductTest1() throws FileNotFoundException {
        String str1 = "ipad";
        boolean ret = productSearch.isProduct(str1);
        assertFalse(ret);
    }

    @Test
    public void isProductTest2() throws FileNotFoundException {
        String str1 = "Thing";
        boolean ret = productSearch.isProduct(str1);
        assertTrue(ret);
    }

    @Test
    public void isProductTest3() throws FileNotFoundException {
        String str1 = "Random";
        boolean ret = productSearch.isProduct(str1);
        assertFalse(ret);
    }

    @Test
    public void isProductTest4() throws FileNotFoundException {
        String str1 = "Doodad";
        boolean ret = productSearch.isProduct(str1);
        assertTrue(ret);
    }

    @Test
    public void isProductTest5() throws FileNotFoundException {
        String str1 = "Ting";
        boolean ret = productSearch.isProduct(str1);
        assertFalse(ret);
    }

    @Test
    public void isProductTest6() throws FileNotFoundException {
        String str1 = "Widget";
        boolean ret = productSearch.isProduct(str1);
        assertTrue(ret);
    }

}