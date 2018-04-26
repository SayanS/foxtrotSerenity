package foxtrot.pages;

import foxtrot.pages.custom_elements.NavigationBar;
import foxtrot.pages.custom_elements.ProductListContainer;

public class ShopPage extends BasePage {

    private ProductListContainer productListContainer;
    private NavigationBar navigationBar;

    private String PAGE_TITLE = "//h1";

    public String getTitle() {
        return $(PAGE_TITLE).getText();
    }

    public ProductListContainer getProductListContainer(){
        return productListContainer;
    }

    public NavigationBar getNavigationBar(){
        return navigationBar;
    }

}
