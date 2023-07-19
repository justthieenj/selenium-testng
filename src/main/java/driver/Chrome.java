package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome extends DriverManager {
    @Override
    public WebDriver createDriver(String options) {
        var chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(options);
        var driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        return driver;
    }
}
