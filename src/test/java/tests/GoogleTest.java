package tests;

import common.DriverUtils;
import element.BaseElementImpl;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {
    @Test
    public void testGoogleSearch() {
        DriverUtils.open("https://www.google.com");
        new BaseElementImpl(By.name("q")).enter("Selenium");
        new BaseElementImpl(By.name("btnK")).click();
    }
}
