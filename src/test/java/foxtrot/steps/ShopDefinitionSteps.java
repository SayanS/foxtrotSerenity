package foxtrot.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import foxtrot.pages.HomePageObject;
import foxtrot.steps.serenity.ShopEndUserSteps;
import net.thucydides.core.annotations.Steps;

public class ShopDefinitionSteps {
    @Steps
    ShopEndUserSteps shopEndUserSteps;
    @Steps
    HomePageObject homePage;

    @Given("^Home page is opened$")
    public void homePageIsOpened() throws Throwable {
        shopEndUserSteps.openHomePage();
    }

    @When("^Enter \"([^\"]*)\" into Global search field$")
    public void enterIntoGlobalSearchField(String text) {
       homePage.getHeader().enterIntoGlobalSearchField(text);
    }

    @Then("^Global search drop-down list should contains \"([^\"]*)\"$")
    public void globalSearchDropDownListShouldContains(String text) {
       homePage.getHeader().ensureThatGlobalSearchDropDownListContains(text);
    }

    @When("^Global search for \"([^\"]*)\"$")
    public void globalSearchFor(String text) {
        homePage.getHeader().enterIntoGlobalSearchField(text);
        homePage.getHeader().clickOnGlobalSearchButton();
    }
}
