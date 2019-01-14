package pages.banking;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.PageObject;

public class CreditCardsMainPage extends PageObject {

    public CreditCardsMainPage(ThreadLocal<RemoteWebDriver> mDriver) {
        super(mDriver);
    }

    @FindBy(xpath = "//a[text()='Compare Our Credit Cards']")
    WebElement compare_our_credit_cards_button;


    public void click_on_compare_our_credit_cards_button() {
        wait.until(ExpectedConditions.elementToBeClickable(compare_our_credit_cards_button));
        compare_our_credit_cards_button.click();
    }

    public boolean verify_user_is_on_main_personal_credit_cards_accounts_page() {
        wait.until(ExpectedConditions.visibilityOf(compare_our_credit_cards_button));
        if (compare_our_credit_cards_button.isDisplayed()) {
            return true;
        }
        return false;
    }
}
