package tests;

import base.BaseUtil;
import com.experitest.reporter.testng.Listener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BankingDropDownPage;
import pages.banking.SavingsMainPage;

import static org.testng.Assert.assertTrue;

@Listeners(Listener.class)
public class SavingsRelatedTest extends BaseUtil {

    BankingDropDownPage bankingDropDownPage;
    SavingsMainPage savingsMainPage;

    @BeforeMethod
    public void setUpAllPages() {
        bankingDropDownPage = new BankingDropDownPage(driver);
        savingsMainPage = new SavingsMainPage(driver);
        bankingDropDownPage.navigateTo("https://www.pnc.com/en/personal-banking.html");
    }

    @Test
    public void user_should_be_on_savings_page() {
        bankingDropDownPage
                .hover_above_banking_dropdown_menu()
                .click_on_savings_option();

        savingsMainPage.if_zip_code_is_present_then_handle();

        assertTrue(savingsMainPage.verify_user_is_on_main_personal_savings_accounts_page());
    }

}
