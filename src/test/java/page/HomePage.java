package page;

import element.BaseElement;
import org.openqa.selenium.Keys;

import static element.ElementUtils.find;

public class HomePage {
    private final BaseElement btnSignIn = find(".panel.header .authorization-link>a");
    private final BaseElement txtSearch = find("#search");

    public LoginPage clickLogin() {
        btnSignIn.click();
        return new LoginPage();
    }

    public SearchResultPage searchFor(String keyword) {
        txtSearch.enter(keyword);
        txtSearch.enter(Keys.ENTER);
        return new SearchResultPage();
    }
}
