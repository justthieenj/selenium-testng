package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import common.DriverUtils;

public class GoogleTest extends BaseTest {
    @Test
    public void testGoogleSearch() {
        var driver = DriverUtils.getDriver();
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("Selenium");
        driver.findElement(By.name("btnK")).click();
    }
}
