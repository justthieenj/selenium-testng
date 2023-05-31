package page;

import element.BaseElement;
import element.BaseElementImpl;

public class HomePage {
    private final BaseElement btnSignIn = new BaseElementImpl(".panel.header .authorization-link>a");

    public void clickLogin() {
        btnSignIn.click();
    }
}
