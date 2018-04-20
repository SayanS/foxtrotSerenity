package foxtrot.pages;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class HeaderPage extends MyPageObject {
    String GLOBAL_SEARCH_FIELD = "//input[@id='search_input']";
    String GLOBAL_SEARCH_FIELD_AUTOCOMPLETE_GOODS = "//ul[@id='ui-id-1']/li/a//div[@class='name']";
    String GLOBAL_SEARCH_BUTTON = "(//button[@class='siteSearchSubmit'])[1]";
    String CATALOG_MENU_ITEMS = "(//ul[@class='catalog-menu']/li[@class='La mega__menu  auto']/a)";

    @Step
    public void enterIntoGlobalSearchField(String text) {
        $(GLOBAL_SEARCH_FIELD).sendKeys(text);
    }

    @Step
    public void ensureThatGlobalSearchDropDownListContains(String expectedText) {
        texts(GLOBAL_SEARCH_FIELD_AUTOCOMPLETE_GOODS).stream().
                forEach(actualText -> Assert.assertTrue("Expected: " + expectedText + "Actual: " + actualText,
                        actualText.toLowerCase().contains(expectedText.toLowerCase())));
    }

    @Step
    public void clickOnGlobalSearchButton() {
        $(GLOBAL_SEARCH_BUTTON).click();
    }

    @Step
    public String selectCatalogMenuItem(Integer index){
        String itemName=findBy(CATALOG_MENU_ITEMS+"["+index+"]").getText();
        findBy(CATALOG_MENU_ITEMS).click();
        return itemName;
    }


}
