package foxtrot.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class SearchResultsPageObject extends BasePage {
    private String PAGE_TITLE = "//h1";
    private String PRODUCT_ITEMS ="//div[@class='product-item']";
    private String ADD_TO_CART_BUTTON="//button[@class='addToCartButton ']";
    private String PRODUCT_ITEM_TITLES="(//div[@class='product-item']/div/a[contains(@href,'/ru/shop/')][1])";

    private String PAGINATION_BAR="//div[@class='pagination']";
    private String PAGINATION_NEXT_PAGE_BUTTON="//li[@class='next']/a";
    private String PAGINATION_PREV_PAGE_BUTTON="//li[@class='prev']/a";
    private String PAGINATION_BUTTONS="//div[@class='pagination']/ul/li";

    @Step
    public void ensureThatPageTitleContains(String text) {
        Assert.assertTrue("Expected: " + text + " but was Actual: " + $(PAGE_TITLE).getText(), $(PAGE_TITLE).getText().toLowerCase().contains(text.toLowerCase()));
    }

    private Integer getNumberOfPagesInPagination() {
        try{
            scrollIntoView(PAGINATION_BAR);
            return Integer.valueOf(findAll(PAGINATION_BUTTONS).get(findAll(PAGINATION_BUTTONS).size()-2).getText());
        }catch(Exception e){
        }
        return null;
    }

    private Integer getNumberOfItemsOnPage() {
        return findAll(PRODUCT_ITEMS).size();
    }

    @Step
    public WebElementFacade moveToProduct(String productName){
        Integer pagesNumber=getNumberOfPagesInPagination();
        Integer itemsNumber;
        if(getNumberOfPagesInPagination()==0) return null;
        for(int page=1;page<=pagesNumber;page++){
            itemsNumber=getNumberOfItemsOnPage();
            for(int item=1;item<=itemsNumber;item++){
              if($(PRODUCT_ITEM_TITLES+"["+item+"]").getText().toLowerCase().equals(productName.toLowerCase())){
                  moveTo(PRODUCT_ITEM_TITLES+"["+item+"]");
                  return $(PRODUCT_ITEM_TITLES+"["+item+"]");
              }
            }
            if(page<pagesNumber) {
                $(PAGINATION_NEXT_PAGE_BUTTON).click();
            }
        }
        return null;
    }

    @Step
    public void openProductDetailsPageFor(String productName){
         moveToProduct(productName).click();
    }

    @Step
    public void clickOnAddToCartButton(String productName){
        WebElementFacade productContainer=moveToProduct(productName).findBy(ADD_TO_CART_BUTTON);

    }


}
