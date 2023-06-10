package element;

public class ElementUtils {
    public static BaseElement find(String selector) {
        return new BaseElementImpl(selector);
    }
}
