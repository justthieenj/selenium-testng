package common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils extends org.apache.commons.lang3.StringUtils {
    public static String getSubstring(String str, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matchResults = pattern.matcher(str);
        String desiredStr = null;
        if (matchResults.find()) {
            desiredStr = matchResults.group();
        }
        return desiredStr;
    }

    public static String convertToCamelCase(String words) {
        String result = "";
        for (String word : words.split("\\s+")) {
            result = result.concat(capitalize(word.toLowerCase()));
        }
        return uncapitalize(result);
    }
}
