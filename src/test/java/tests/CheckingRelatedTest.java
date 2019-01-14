package tests;

import base.BaseUtil;
import com.experitest.reporter.testng.Listener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BankingDropDownPage;
import pages.banking.CheckingMainPage;

import static org.testng.Assert.assertTrue;

@Listeners(Listener.class)
public class CheckingRelatedTest extends BaseUtil {

    BankingDropDownPage bankingDropDownPage;
    CheckingMainPage checkingMainPage;

    @BeforeMethod
    public void setUpAllPages() {
        bankingDropDownPage = new BankingDropDownPage(driver);
        checkingMainPage = new CheckingMainPage(driver);
        bankingDropDownPage.navigateTo("https://www.pnc.com/en/personal-banking.html");
    }

    @Test
    public void user_should_be_on_checking_page() {
        bankingDropDownPage
                .hover_above_banking_dropdown_menu()
                .click_on_checking_option();

        assertTrue(checkingMainPage.verify_user_is_on_main_personal_checking_accounts_page());
    }
}
