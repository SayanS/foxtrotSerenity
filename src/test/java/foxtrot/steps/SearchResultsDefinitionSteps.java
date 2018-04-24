package foxtrot.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import foxtrot.steps.serenity.SearchResultsPageSteps;
import net.thucydides.core.annotations.Steps;

public class SearchResultsDefinitionSteps {
    @Steps
    SearchResultsPageSteps searchResultsPageSteps;

    @Then("^Page title should contain \"([^\"]*)\"$")
    public void pageTitleShouldContain(String text) {
        searchResultsPageSteps.ensureThatPageTitleContains(text);
    }

    @When("^Open Product details page of \"([^\"]*)\"$")
    public void openProductDetailsPageOf(String productName) {
        searchResultsPageSteps.openProductDetailsPageFor(productName);
    }

    @When("^Click on Add to cart button for product \"([^\"]*)\" on Search results page$")
    public void addToCartProductFromSearchResultsPage(String productName) {
        searchResultsPageSteps.clickOnAddToCartButton(productName);
    }

}
