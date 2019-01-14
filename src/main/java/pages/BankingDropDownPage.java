package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BankingDropDownPage extends PageObject {

    public BankingDropDownPage(ThreadLocal<RemoteWebDriver> mDriver) {
        super(mDriver);
    }

    @FindBy(xpath = "//ul[@class='level-2  expanded']//span[text()='Banking']")
    WebElement banking_option;

    @FindBy(xpath = "//li/a[text()='Checking']")
    WebElement checking;

    @FindBy(xpath = "//li/a[text()='Savings']")
    WebElement savings;

    @FindBy(xpath = "//li/a[text()='Credit Cards']")
    WebElement credit_cards;

    public BankingDropDownPage hover_above_banking_dropdown_menu() {
        wait.until(ExpectedConditions.elementToBeClickable(banking_option));
//        builder.moveToElement(banking_option).perform();
        String strJavaScript = "var element = arguments[0]; var mouseEventObj = document.createEvent('MouseEvents'); mouseEventObj.initEvent( 'mouseover', true, true ); element.dispatchEvent(mouseEventObj);";
        ((JavascriptExecutor) getDriver()).executeScript(strJavaScript, banking_option);
        return this;
    }

    public BankingDropDownPage click_on_checking_option() {
        wait.until(ExpectedConditions.elementToBeClickable(checking));
        checking.click();
        return this;
    }

    public BankingDropDownPage click_on_savings_option() {
        wait.until(ExpectedConditions.elementToBeClickable(savings));
        savings.click();
        return this;
    }

    public BankingDropDownPage click_on_credit_cards_option() {
        wait.until(ExpectedConditions.elementToBeClickable(credit_cards));
        credit_cards.click();
        return this;
    }

}

