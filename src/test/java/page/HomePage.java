package page;

import element.BaseElement;
import element.BaseElementImpl;

public class HomePage {
    private final BaseElement txtUsername = new BaseElementImpl("#username");
    private final BaseElement txtPassword = new BaseElementImpl("#password");
    private final BaseElement btnLogin = new BaseElementImpl(".btn-login");

    public void login(String username, String password) {
        txtUsername.enter(username);
        txtPassword.enter(password);
        btnLogin.click();
    }
}
