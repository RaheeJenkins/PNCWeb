package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends PageObject {

    public HomePage(ThreadLocal<RemoteWebDriver> mDriver) {
        super(mDriver);
    }

    @FindBy(className = "search-toggle")
    WebElement search_icon;

    @FindBy(id = "navSearchField")
    WebElement search_field;

    public HomePage click_on_search_icon() {
        wait.until(ExpectedConditions.elementToBeClickable(search_icon));
        search_icon.click();
        return this;
    }

    public HomePage type_into_search_field_with(String input) {
        wait.until(ExpectedConditions.elementToBeClickable(search_field));
        search_field.sendKeys(input);
        return this;
    }

}
