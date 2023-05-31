package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MagentoSearchProductTest {
    @Parameters("dummyParams")
    @Test
    public void testSearchProduct(String ayy) {
        System.out.println("dummyParams: " + ayy);
    }
}
