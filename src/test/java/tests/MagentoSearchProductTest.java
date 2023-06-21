package tests;

import common.DriverUtils;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.HomePage;

public class MagentoSearchProductTest extends BaseTest {
    @Parameters("dummyParams")
    @Test
    public void testSearchProductUsingXmlData(String ayy) {
        System.out.println("dummyParams: " + ayy);
    }

    @Test
    public void testSearchProduct() {
        DriverUtils.open("https://magento.softwaretestingboard.com/");
        new HomePage()
                .clickLogin()
                .loginAs("ngkhanhthien94@gmail.com", "UqHtkEV8KgxCb78")
                .searchFor("t shirt")
                .productCardShouldDisplayed()
                .clickFirstProduct()
                .productTitleShouldDisplayed();
    }
}
