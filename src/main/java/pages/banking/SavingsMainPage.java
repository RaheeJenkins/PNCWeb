package pages.banking;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.PageObject;

public class SavingsMainPage extends PageObject {

    public SavingsMainPage(ThreadLocal<RemoteWebDriver> mDriver) {
        super(mDriver);
    }

    @FindBy(xpath = "//h3[text()='Is this your zip code?']")
    WebElement is_this_your_zip_code_header;

    @FindBy(id = "zipInput")
    WebElement zip_code_field;

    @FindBy(id = "zipSubmit")
    WebElement zip_code_submit_button;

    @FindBy(xpath = "//a[text()='Find the Right Savings Account']")
    WebElement find_the_right_savings_account;

    public void if_zip_code_is_present_then_handle() {
        if (is_this_your_zip_code_header.isDisplayed()) {
            zip_code_field.clear();
            zip_code_field.sendKeys("11373");
            zip_code_submit_button.click();
        }
    }

    public void click_on_find_the_right_savings_account_button() {
        wait.until(ExpectedConditions.elementToBeClickable(find_the_right_savings_account));
        find_the_right_savings_account.click();
    }

    public boolean verify_user_is_on_main_personal_savings_accounts_page() {
        wait.until(ExpectedConditions.visibilityOf(find_the_right_savings_account));
        if (find_the_right_savings_account.isDisplayed()) {
            return true;
        }
        return false;
    }
}
