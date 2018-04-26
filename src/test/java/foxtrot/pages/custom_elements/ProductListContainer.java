package foxtrot.pages.custom_elements;

import foxtrot.pages.BasePage;

public class ProductListContainer extends BasePage {

    private String PRODUCT_ITEMS = "//div[contains(@class,'product-list')]/div[contains(@class, 'product-item')]";
    private String ADD_TO_CART_BUTTON_LIST = "(" + PRODUCT_ITEMS + "//div[@class='btn to-cart-button'])";


    private Integer getNumberOfItemsOnPage() {
        return findAll(PRODUCT_ITEMS).size();
    }

    public void clickOnAddToCartButton(String productName) {
        String ADD_TO_CART_BUTTON_FOR_PRODUCT = "//div[contains(@class,'product-list')]/div[contains(@class, 'product-item') and (@data-title='"
                + productName + "')]//div[@class='btn to-cart-button active']//a";
        scrollIntoView(ADD_TO_CART_BUTTON_FOR_PRODUCT);
        moveTo(ADD_TO_CART_BUTTON_FOR_PRODUCT).click();
    }

    public void clickOnAddToCartButton(Integer index) {
        scrollIntoView(ADD_TO_CART_BUTTON_LIST + "[" + index + "]");
        $(ADD_TO_CART_BUTTON_LIST + "[" + index + "]").click();
    }

    public void clickOnTitleOfContainer(String productName) {
        String CONTAINER_TITLE_OF_PRODUCT = "//div[contains(@class,'product-list')]/div[contains(@class, 'product-item') and (@data-title='"+ productName + "')]//a[@class='name detail-link']";
        scrollIntoView(CONTAINER_TITLE_OF_PRODUCT);
        $(CONTAINER_TITLE_OF_PRODUCT).click();
        int i=0;
    }

}
