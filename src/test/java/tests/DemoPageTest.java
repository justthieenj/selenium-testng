package tests;

import common.Common;
import driver.DriverUtils;
import org.testng.annotations.Test;

import java.time.Duration;

import static element.ElementUtils.find;

public class DemoPageTest extends BaseTest {
    @Test
    public void testElementInteraction() {
        DriverUtils.open("https://seleniumbase.io/demo_page");
        var textInput = find("#myTextInput321"); // invalid selector
        var preFilledTextInput = find("#myTextInput2");
        var placeholderText = find("#placeholderText");
        var dropdown = find("#mySelect");
        var result = textInput.isVisible(Duration.ofSeconds(2));
        System.out.println(result); // should be false
//        textInput.enter("Hello World");
        preFilledTextInput.clear();
        preFilledTextInput.enter("CSGO");
        placeholderText.enter("GabeN");
        dropdown.selectOption("Set to 75%");
        Common.sleep(2000);
    }
}
