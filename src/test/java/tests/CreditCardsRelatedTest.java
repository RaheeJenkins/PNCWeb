package tests;

import base.BaseUtil;
import com.experitest.reporter.testng.Listener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BankingDropDownPage;
import pages.banking.CreditCardsMainPage;

import static org.testng.Assert.assertTrue;

@Listeners(Listener.class)
public class CreditCardsRelatedTest extends BaseUtil {

    BankingDropDownPage bankingDropDownPage;
    CreditCardsMainPage creditCardsMainPage;

    @BeforeMethod
    public void setUpAllPages() {
        bankingDropDownPage = new BankingDropDownPage(driver);
        creditCardsMainPage = new CreditCardsMainPage(driver);
        bankingDropDownPage.navigateTo("https://www.pnc.com/en/personal-banking.html");
    }

    @Test
    public void user_should_be_on_credit_cards_page() {
        bankingDropDownPage
                .hover_above_banking_dropdown_menu()
                .click_on_credit_cards_option();

        assertTrue(creditCardsMainPage.verify_user_is_on_main_personal_credit_cards_accounts_page());
    }
}
