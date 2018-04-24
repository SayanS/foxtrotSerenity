package foxtrot.pages;

import net.serenitybdd.core.pages.WebElementFacade;

public class SearchResultsPage extends BasePage {
    private String PAGE_TITLE = "//h1";
    private String PRODUCT_ITEMS ="//div[@class='main']//div[@class='product-item']";
    private String PRODUCT_CONTAINERS="//div[@class='btn to-cart-button']/ancestor::div[@class='product-item']";
    private String ADD_TO_CART_BUTTON="("+PRODUCT_ITEMS+"//button[@class='addToCartButton ']"+")";
    private String PRODUCT_ITEM_TITLES="("+PRODUCT_ITEMS+"/div/a[contains(@href,'/shop/')][1]"+")";
    private String STOCK_STATUS_PRODUCT_DIV="("+PRODUCT_ITEMS+"//form[@class='add_to_cart_form']/div[1]"+")";
    private String PAGINATION_BAR="//div[@class='pagination']";
    private String PAGINATION_NEXT_PAGE_BUTTON="//li[@class='next']/a";
    private String PAGINATION_PREV_PAGE_BUTTON="//li[@class='prev']/a";
    private String PAGINATION_BUTTONS="//div[@class='pagination']/ul/li";

    public String getTitle() {
        return $(PAGE_TITLE).getText();
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

    private Integer getIndexOfContainer(String productName){
        Integer pagesNumber=getNumberOfPagesInPagination();
        Integer itemsNumber;
        if(getNumberOfPagesInPagination()==0) return null;
        for(int page=1;page<=pagesNumber;page++){
            itemsNumber=getNumberOfItemsOnPage();
            for(int item=1;item<=itemsNumber;item++){
              if($(PRODUCT_ITEM_TITLES+"["+item+"]").getAttribute("title").toLowerCase().equals(productName.toLowerCase())){
                  return item;
              }
            }
            if(page<pagesNumber) {
                $(PAGINATION_NEXT_PAGE_BUTTON).click();
            }
        }
        return null;
    }

    private String getProductStockStatus(Integer indexContainer){
        return $(STOCK_STATUS_PRODUCT_DIV+"["+indexContainer+"]").getAttribute("data-stockstatus");
    }

    private WebElementFacade getProductContainer(String stockStatus, Integer sequenceNumber){
        Integer pagesNumber=getNumberOfPagesInPagination();
        Integer numberContainer;
        Integer counter=0;

        if(getNumberOfPagesInPagination()==0) return null;

        for(int page=1;page<=pagesNumber;page++){
            numberContainer=getNumberOfItemsOnPage();
            for(int container=1;container<=numberContainer;container++){
                if((getProductStockStatus(numberContainer)).equals(stockStatus)&&(counter==sequenceNumber)){
                    return $("("+PRODUCT_ITEMS+")["+container+"]");
                }
            }
            if(page<pagesNumber) {
                $(PAGINATION_NEXT_PAGE_BUTTON).click();
            }
        }
        return null;
    }

    public void openProductDetailsPageFor(String productName){
        Integer index=getIndexOfContainer(productName);
        scrollIntoView(PRODUCT_ITEMS+"["+index+"]");
        findBy(PRODUCT_ITEM_TITLES+"["+index+"]").click();
    }

    public void clickOnAddToCartButton(String productName){
        Integer index=getIndexOfContainer(productName);
        scrollIntoView(PRODUCT_ITEM_TITLES+"["+index+"]");
        moveTo(ADD_TO_CART_BUTTON+"["+index+"]").click();
    }

    public void clickOnAddToCartButton(String stockStatus, Integer sequenceNumber){
        WebElementFacade container=getProductContainer(stockStatus,sequenceNumber);
        scrollIntoView(container);
//        moveTo(ADD_TO_CART_BUTTON+"["+index+"]").click();
    }

}
