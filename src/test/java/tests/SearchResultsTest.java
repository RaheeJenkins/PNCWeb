package tests;

import base.BaseUtil;
import com.experitest.reporter.testng.Listener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultsPage;

import static org.testng.Assert.assertTrue;

@Listeners(Listener.class)
public class SearchResultsTest extends BaseUtil {

    HomePage homePage;
    SearchResultsPage searchResultsPage;

    @BeforeMethod
    public void setUpAllPages() {
        homePage = new HomePage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        homePage.navigateTo("https://www.pnc.com/en/personal-banking.html");
    }

    @Test
    public void verify_item_displayed_in_search_results_list() {
        homePage
                .click_on_search_icon()
                .type_into_search_field_with("Checking | PNC")
                .click_on_search_icon();

        assertTrue(searchResultsPage.verify_item_displayed("Checking | PNC"));
    }

}
