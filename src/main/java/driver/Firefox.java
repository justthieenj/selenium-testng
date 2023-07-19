package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Firefox extends DriverManager {
    @Override
    public WebDriver createDriver(String options) {
        var firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments(options);
        var driver = new FirefoxDriver(firefoxOptions);
        driver.manage().window().maximize();
        return driver;
    }
}
