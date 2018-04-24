package foxtrot.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import foxtrot.steps.serenity.BasePageSteps;
import foxtrot.steps.serenity.HomePageSteps;
import foxtrot.steps.serenity.PreCartPopUpSteps;
import foxtrot.steps.serenity.ShopEndUserSteps;
import net.thucydides.core.annotations.Steps;

public class ShopDefinitionSteps {
    @Steps
    BasePageSteps basePageSteps;
    @Steps
    ShopEndUserSteps shopEndUserSteps;
    @Steps
    HomePageSteps homePageSteps;
    @Steps
    PreCartPopUpSteps preCartPopUpSteps;


    @Given("^Home page is opened$")
    public void homePageIsOpened() {
    homePageSteps.openHomePage();
    }

    @When("^Enter \"([^\"]*)\" into Global search field$")
    public void enterIntoGlobalSearchField(String text) {
        basePageSteps.globalSearchFor(text);
    }

    @Then("^Global search drop-down list should contains \"([^\"]*)\"$")
    public void globalSearchDropDownListShouldContains(String text) {
        basePageSteps.ensureThatGlobalSearchDropDownListContains(text);
    }

    @When("^Global search for \"([^\"]*)\"$")
    public void globalSearchFor(String text) {
        basePageSteps.enterIntoGlobalSearchField(text);
        basePageSteps.clickOnGlobalSearchButton();
    }

    @Then("^PreCart pop-up should be opened$")
    public void precartPopUpShouldBeOpened(){
        preCartPopUpSteps.ensureThatPreCartPopupIsOpened();
    }

    @Then("^PreCart pop-up should contain product \"([^\"]*)\"$")
    public void precartPopUpShouldContainProduct(String productName) {
        preCartPopUpSteps.ensureThatPreCartPopupContainsProduct(productName);
    }

    @When("^Click on Go to Cart button on PreCart pop-up$")
    public void clickOnGoToCartButtonOnPreCartPopUp(){
        preCartPopUpSteps.clickOnGoToCartButton();

    }

    @When("^Select \"([^\"]*)\" from the Header Catalog menu$")
    public void selectFromTheHeaderCatalogMenu(String itemName){
        basePageSteps.selectCatalogMenuItem(itemName);
    }

    @Then("^URL of the Current page should contain \"([^\"]*)\"$")
    public void urlOfTheCurrentPageShouldContain(String pageName) {
        basePageSteps.ensureThatCurrentURLContains(pageName);
    }

    @Then("^Shop page should be opened with \"([^\"]*)\"$")
    public void shopPageShouldBeOpenedWith(String title) {
        shopEndUserSteps.ensureThatPageTitleIs(title);
    }
}
