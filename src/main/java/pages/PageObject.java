package pages;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {

    protected Actions builder;

    protected ThreadLocal<RemoteWebDriver> driver;
    protected WebDriverWait wait;

    public PageObject(ThreadLocal<RemoteWebDriver> mDriver) {
        this.driver = mDriver;
        wait = new WebDriverWait(getDriver(), 20);
        PageFactory.initElements(getDriver(), this);
        builder = new Actions(getDriver());
    }

    protected RemoteWebDriver getDriver() {
        return driver.get();
    }

    public void navigateTo(String url) {
        getDriver().navigate().to(url);
    }

    public String getTitle() {
        return getDriver().getTitle();
    }

}
