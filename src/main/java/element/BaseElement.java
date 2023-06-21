package element;

import enums.Attribute;

import java.time.Duration;

public interface BaseElement {
    void click();

    void enter(CharSequence... keysToSend);

    void clear();

    void selectOption(String option);

    void setDynamic(Object... args);

    String getAttribute(String attributeName);

    String getAttribute(Attribute attributeName);

    String getValue();
    boolean isVisible();

    boolean isVisible(Duration timeout);

    boolean isEnabled(Duration timeout);

    String getText();
    void scroll();
}
