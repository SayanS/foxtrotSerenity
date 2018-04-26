package foxtrot.pages;

import foxtrot.pages.custom_elements.ProductListContainer;

public class SearchResultsPage extends BasePage {

    private String PAGE_TITLE = "//h1";
    private ProductListContainer productListContainer;


    public String getTitle() {
        return $(PAGE_TITLE).getText();
    }

    public ProductListContainer getProductListContainer() {
        return productListContainer;
    }


}
