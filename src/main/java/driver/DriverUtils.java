package driver;

import common.ReflectUtils;
import org.openqa.selenium.WebDriver;

public class DriverUtils {
    private static final ThreadLocal<WebDriver> DRIVERS = new ThreadLocal<>();

    public static WebDriver initDriver(String browser, String options) {
        return switch (browser) {
            case "chrome" -> new Chrome().createDriver(options);
            case "firefox" -> new Firefox().createDriver(options);
            case "edge" -> new Edge().createDriver(options);
            default -> throw new IllegalArgumentException("Browser " + browser + " is not supported");
        };
    }

    public static WebDriver initByReflection(String browser, String options) {
        return ReflectUtils.createWebDriver(browser, options);
    }

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
