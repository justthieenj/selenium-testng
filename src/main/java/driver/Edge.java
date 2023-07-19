package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Edge extends DriverManager {
    @Override
    public WebDriver createDriver(String options) {
        var chromeOptions = new EdgeOptions();
        chromeOptions.addArguments(options);
        var driver = new EdgeDriver(chromeOptions);
        driver.manage().window().maximize();
        return driver;
    }
}
