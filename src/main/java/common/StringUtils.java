package common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    public static String getSubstring(String str, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matchResults = pattern.matcher(str);
        String desiredStr = null;
        if (matchResults.find()) {
            desiredStr = matchResults.group();
        }
        return desiredStr;
    }
}
