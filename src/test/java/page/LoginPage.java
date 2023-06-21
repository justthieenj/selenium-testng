package page;

import element.BaseElement;
import element.BaseElementImpl;

public class LoginPage {
    private final BaseElement txtUsername = new BaseElementImpl("#email");
    private final BaseElement txtPassword = new BaseElementImpl("#pass");
    private final BaseElement btnLogin = new BaseElementImpl("button.login");

    public HomePage loginAs(String username, String password) {
        txtUsername.enter(username);
        txtPassword.enter(password);
        btnLogin.click();
        return new HomePage();
    }
}
