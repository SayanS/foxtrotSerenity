package foxtrot.pages.custom_elements;

import foxtrot.pages.BasePage;

public class NavigationBar extends BasePage {
    private String PAGINATION_BAR="//div[@class='pagination']";
    private String PAGINATION_NEXT_PAGE_BUTTON="//li[@class='next']/a";
    private String PAGINATION_PREV_PAGE_BUTTON="//li[@class='prev']/a";
    private String PAGINATION_BUTTONS="//div[@class='pagination']/ul/li";

    public Integer getNumberOfPagesInPagination() {
        try{
            scrollIntoView(PAGINATION_BAR);
            return Integer.valueOf(findAll(PAGINATION_BUTTONS).get(findAll(PAGINATION_BUTTONS).size()-2).getText());
        }catch(Exception e){
        }
        return null;
    }

    public void clickOnNext() {
        $(PAGINATION_NEXT_PAGE_BUTTON).click();
    }

    public boolean isLastPageOpened(){
        if($(PAGINATION_NEXT_PAGE_BUTTON).getAttribute("href").equals("javascript:void(0)")) return true;
        return false;
    }

}
