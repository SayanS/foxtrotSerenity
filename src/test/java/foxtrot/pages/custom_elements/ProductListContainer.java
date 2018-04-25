package foxtrot.pages.custom_elements;

import foxtrot.pages.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;

public class ProductListContainer extends BasePage {

    private NavigationBar naviBar;

    private String PRODUCT_ITEMS = "//div[@class='main']//div[@class='product-item']";
    private String PRODUCT_CONTAINERS = "//div[@class='btn to-cart-button']/ancestor::div[@class='product-item']";
    private String ADD_TO_CART_BUTTON = "(" + PRODUCT_ITEMS + "//button[@class='addToCartButton ' and @type='submit']" + ")";
    private String PRODUCT_ITEM_TITLES = "(" + PRODUCT_ITEMS + "/div/a[contains(@href,'/shop/')][1]" + ")";
    private String STOCK_STATUS_PRODUCT_DIV = "(" + PRODUCT_ITEMS + "//form[@class='add_to_cart_form']/div[1]" + ")";

    private Integer getNumberOfItemsOnPage() {
        return findAll(PRODUCT_ITEMS).size();
    }

    private Integer getIndexOfContainer(String productName) {
        Integer pagesNumber = naviBar.getNumberOfPagesInPagination();
        Integer itemsNumber;

        do {
            itemsNumber = getNumberOfItemsOnPage();
            for (int item = 1; item <= itemsNumber; item++) {
                if ($(PRODUCT_ITEM_TITLES + "[" + item + "]").getAttribute("title").toLowerCase().equals(productName.toLowerCase())) {
                    return item;
                }
            }
            naviBar.clickOnNext();
        }while (naviBar.isLastPageOpened());

        return null;
    }

    private String getProductStockStatus(Integer indexContainer) {
        return $(STOCK_STATUS_PRODUCT_DIV + "[" + indexContainer + "]").getAttribute("data-stockstatus");
    }

    private Boolean isAddToCartButtonAvailable(Integer indexContainer) {
        return $(ADD_TO_CART_BUTTON + "[" + indexContainer + "]").getAttribute("type").equals("submit") ? true : false;
    }

    private WebElementFacade getProductContainer(String stockStatus, Integer sequenceNumber) {
        Integer numberContainer;
        Integer counter = 0;
        do {
            for (int container = 1; container <= numberContainer; container++) {
                if ((getProductStockStatus(numberContainer)).equals(stockStatus) && isAddToCartButtonAvailable(container))
                    counter++;
                if (counter == sequenceNumber) return $("(" + PRODUCT_ITEMS + ")[" + container + "]");
            }
            naviBar.clickOnNext();
        } while (naviBar.isLastPageOpened());
        return null;
    }

    public void openProductDetailsPageFor(String productName) {
        Integer index = getIndexOfContainer(productName);
        scrollIntoView(PRODUCT_ITEMS + "[" + index + "]");
        findBy(PRODUCT_ITEM_TITLES + "[" + index + "]").click();
    }

    public void clickOnAddToCartButton(String productName) {
        Integer index = getIndexOfContainer(productName);
        scrollIntoView(PRODUCT_ITEM_TITLES + "[" + index + "]");
        moveTo(ADD_TO_CART_BUTTON + "[" + index + "]").click();
    }

    public void clickOnAddToCartButton(String stockStatus, Integer sequenceNumber) {
        WebElementFacade container = getProductContainer(stockStatus, sequenceNumber);
        scrollIntoView(container);
        container.click();
    }

}
