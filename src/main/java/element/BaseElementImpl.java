package element;

import common.Constant;
import common.DriverUtils;
import enums.Attribute;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BaseElementImpl implements BaseElement {
    private String locator;
    private String dynamicLocator;
    private By byLocator;
    private final WebDriver driver;

    public BaseElementImpl(String locator) {
        this.locator = locator;
        this.dynamicLocator = locator;
        this.byLocator = getByLocator();
        this.driver = DriverUtils.getDriver();
    }

    public BaseElementImpl(By byLocator) {
        this.byLocator = byLocator;
        this.driver = DriverUtils.getDriver();
    }

    private By getByLocator() {
        return locator.startsWith("//") ? By.xpath(locator) : By.cssSelector(locator);
    }

    private WebElement getElement() {
        return driver.findElement(byLocator);
    }

    public List<WebElement> getElements() {
        return driver.findElements(byLocator);
    }

    private FluentWait<WebDriver> getCustomWait(Duration timeout) {
        return new WebDriverWait(driver, timeout)
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(ElementClickInterceptedException.class);
    }

    private void waitVisible(Duration timeout) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(byLocator));
    }

    private void waitVisible() {
        waitVisible(Constant.TIMEOUT);
    }

    @Override
    public void setDynamic(Object... args) {
        this.locator = String.format(dynamicLocator, args);
        this.byLocator = getByLocator();
    }

    @Override
    public void click() {
        getCustomWait(Constant.TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(byLocator))
                .click();
    }

    @Override
    public void enter(CharSequence... keysToSend) {
        waitVisible();
        getElement().sendKeys(keysToSend);
    }

    @Override
    public void clear() {
        getElement().clear();
    }

    @Override
    public void selectOption(String option) {
        var select = new Select(getElement());
        select.selectByVisibleText(option);
    }

    @Override
    public String getText() {
        waitVisible();
        return getElement().getText();
    }

    @Override
    public String getAttribute(String attribute) {
        waitVisible();
        return getElement().getAttribute(attribute);
    }

    @Override
    public String getAttribute(Attribute attributeName) {
        waitVisible();
        return getAttribute(attributeName.getVal());
    }

    @Override
    public String getValue() {
        return getAttribute(Attribute.value);
    }

    @Override
    public boolean isVisible(Duration timeout) {
        try {
            waitVisible(timeout);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    @Override
    public boolean isEnabled(Duration timeout) {
        return getElement().isEnabled();
    }
}
