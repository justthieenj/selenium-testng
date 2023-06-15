package common;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class ReflectUtils {
    public static List<String> getAllPropertiesInClass(Class<?> clz) {
        return Arrays.stream(clz.getDeclaredFields()).map(Field::getName).toList();
    }
}
