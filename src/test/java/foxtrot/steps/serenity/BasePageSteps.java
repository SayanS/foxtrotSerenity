package foxtrot.steps.serenity;

import foxtrot.pages.BasePage;
import foxtrot.pages.FooterPage;
import foxtrot.pages.HeaderPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class BasePageSteps {
    BasePage basePage;
    HeaderPage headerPage;
    FooterPage footerPage;

    @Step
    public void ensureThatCurrentURLContains(String pageName){
        Assert.assertTrue("Url " +basePage.getCurrentURL()+" isn't contains "+pageName,basePage.getCurrentURL().contains(pageName));
    }

    @Step
    public void enterIntoGlobalSearchField(String text) {
        headerPage.enterIntoGlobalSearchField(text);
    }
    @Step
    public void ensureThatGlobalSearchDropDownListContains(String expectedText) {
        headerPage.getGlobalSearchDropDownValues().stream().
                forEach(actualText -> Assert.assertTrue("Expected: " + expectedText + "Actual: " + actualText,
                        actualText.toLowerCase().contains(expectedText.toLowerCase())));
    }
    @Step
    public void clickOnGlobalSearchButton() {
        headerPage.clickOnGlobalSearchButton();
    }

    @Step
    public void globalSearchFor(String text) {
        headerPage.enterIntoGlobalSearchField(text);
        headerPage.clickOnGlobalSearchButton();
    }
    @Step
    public void selectCatalogMenuItem(String itemName){
        headerPage.selectCatalogMenuItem(itemName);
    }

}
