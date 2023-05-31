package common;

import org.openqa.selenium.WebDriver;

public class DriverUtils {
    private static final ThreadLocal<WebDriver> DRIVERS = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return DRIVERS.get();
    }

    public static void setDriver(WebDriver driver) {
        DRIVERS.set(driver);
    }

    public static void open(String url) {
        getDriver().get(url);
    }

    public static void quitAll() {
        if (DRIVERS.get() != null)
            getDriver().quit();
    }
}
