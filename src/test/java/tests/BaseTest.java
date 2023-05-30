package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.DriverUtils;

/**
 * use TestNG hooks to set up and teardown test
 */
public class BaseTest {
    @BeforeTest
    public void beforeTest() {
        System.out.println("Before test");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        DriverUtils.setDriver(driver);
        driver.manage().window().maximize();
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After test");
        DriverUtils.getDriver().quit();
    }
}
