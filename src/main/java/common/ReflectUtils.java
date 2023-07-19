package common;

import org.openqa.selenium.WebDriver;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class ReflectUtils {
    public static List<String> getAllPropertiesInClass(Class<?> clz) {
        return Arrays.stream(clz.getDeclaredFields()).map(Field::getName).toList();
    }

    public static WebDriver createWebDriver(String driverName, String options) {
        try {
            var clz = Class.forName("driver." + StringUtils.convertToCamelCase(driverName));
            var driverManager = clz.getDeclaredConstructor().newInstance();
            var method = clz.getDeclaredMethod("createDriver", String.class);
            return (WebDriver) method.invoke(driverManager, options);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
