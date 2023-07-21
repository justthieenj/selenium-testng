package tests;

import driver.DriverUtils;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;

public class MagentoLoginTest extends BaseTest {
    @Parameters("dummyParams")
    @Test
    public void testLogin(@Optional String dummyParams) {
        // demo get value from xml suite,
        // run by mvn clean test -DxmlSuite=magento
        System.out.println("testLogin - dummyParams: " + dummyParams);
        DriverUtils.open("https://magento.softwaretestingboard.com/");
        HomePage homePage = new HomePage();
        homePage.clickLogin();
        LoginPage loginPage = new LoginPage();
        loginPage.loginAs("ngkhanhthien94@gmail.com", "UqHtkEV8KgxCb78");
    }
}
