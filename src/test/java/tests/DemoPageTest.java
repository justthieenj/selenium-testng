package tests;

import common.Common;
import common.DriverUtils;
import element.BaseElement;
import element.BaseElementImpl;
import org.testng.annotations.Test;

import java.time.Duration;

public class DemoPageTest extends BaseTest {
    @Test
    public void testElementInteraction() {
        DriverUtils.open("https://seleniumbase.io/demo_page");
        BaseElement textInput = new BaseElementImpl("#myTextInput321"); // invalid selector
        BaseElement preFilledTextInput = new BaseElementImpl("#myTextInput2");
        BaseElement placeholderText = new BaseElementImpl("#placeholderText");
        BaseElement dropdown = new BaseElementImpl("#mySelect");
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
