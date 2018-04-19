package foxtrot.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import foxtrot.pages.SearchResultsPageObject;
import net.thucydides.core.annotations.Steps;

public class SearchResultsDefinitionSteps {
    @Steps
    SearchResultsPageObject searchResultsPage;

    @Then("^Page title should contain \"([^\"]*)\"$")
    public void pageTitleShouldContain(String text){
        searchResultsPage.ensureThatPageTitleContains(text);
    }

    @When("^Open Product details page of \"([^\"]*)\"$")
    public void openProductDetailsPageOf(String productName) {
        searchResultsPage.openProductDetailsPageFor(productName);
    }

    @When("^Click on Add to cart button for product \"([^\"]*)\" on Search results page$")
    public void addToCartProductFromSearchResultsPage(String productName) {
      searchResultsPage.clickOnAddToCartButton(productName);
    }

}
