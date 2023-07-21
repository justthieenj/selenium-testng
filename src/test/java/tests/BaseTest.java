package tests;

import driver.DriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

/**
 * use TestNG hooks to set up and teardown test
 */
public class BaseTest {
    @BeforeClass
    public void beforeClass() {
        System.out.println("BeforeClass");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        DriverUtils.setDriver(driver);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void afterClass() {
        System.out.println("AfterClass");
        DriverUtils.getDriver().close();
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("AfterSuite");
        DriverUtils.quitAll();
    }
}
