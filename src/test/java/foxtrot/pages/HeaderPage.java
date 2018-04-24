package foxtrot.pages;

import java.util.List;

public class HeaderPage extends BasePage {
    String GLOBAL_SEARCH_FIELD = "//input[@id='search_input']";
    String GLOBAL_SEARCH_FIELD_AUTOCOMPLETE_GOODS = "//ul[@id='ui-id-1']/li/a//div[@class='name']";
    String GLOBAL_SEARCH_BUTTON = "(//button[@class='siteSearchSubmit'])[1]";
    String CATALOG_MENU_ITEMS = "(//ul[@class='catalog-menu']/li[@class='La mega__menu  auto']/a)";

    public void enterIntoGlobalSearchField(String text) {
        $(GLOBAL_SEARCH_FIELD).sendKeys(text);
    }

    public List<String> getGlobalSearchDropDownValues() {
        return texts(GLOBAL_SEARCH_FIELD_AUTOCOMPLETE_GOODS);
    }

    public void clickOnGlobalSearchButton() {
        $(GLOBAL_SEARCH_BUTTON).click();
    }

    public void selectCatalogMenuItem(String itemName){
        getWebElement(CATALOG_MENU_ITEMS,itemName).click();
    }


}
