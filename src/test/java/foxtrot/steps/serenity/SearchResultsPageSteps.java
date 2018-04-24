package foxtrot.steps.serenity;

import foxtrot.pages.SearchResultsPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class SearchResultsPageSteps {

    SearchResultsPage searchResultsPage;

    @Step
    public void openProductDetailsPageFor(String productName) {
        searchResultsPage.openProductDetailsPageFor(productName);
    }
    @Step
    public void clickOnAddToCartButton(String productName) {
        searchResultsPage.clickOnAddToCartButton(productName);
    }

    @Step
    public void ensureThatPageTitleContains(String text) {
        Assert.assertTrue("Expected: " + text + " but was Actual: " +searchResultsPage.getTitle(), searchResultsPage.getTitle().contains(text));
    }
}
