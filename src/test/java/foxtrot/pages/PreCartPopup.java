package foxtrot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PreCartPopup extends BasePage {
    private String TITLE = "//div[@id='popup-precart']//div[@class='popup-header']/p";
    private String PRODUCT_NAME = "//div[@id='popup-precart']//div[@class='popup-body']//div[@class='name']/p";
    private String GOTOCART_BUTTON = "//div[@id='popup-precart']//div[@class='popup-body']//div[@id='precart-go-to-cart-btn']/button";
    public String PROCEED_PURCHASE_BUTTON = "//div[@id='popup-precart']//div[@class='cart-footer']//div[@data-popup-close='true']/button";
    private String SPINNER = "//div[@class='overlay visible']";
    private String CLOSE_BUTTON="//div[@id='popup-precart']//span[@class='icon-close']";

    public boolean isPreCartPopUpDisplayed() {
        try {
            waitFor(ExpectedConditions.invisibilityOfElementLocated(By.xpath(SPINNER)));
        } catch (Exception e) {
        }
        return $(TITLE).isDisplayed();
    }

    public String getProduct() {
        return $(PRODUCT_NAME).getText();
    }

    public void clickOnGoToCartButton() {
        $(GOTOCART_BUTTON).click();
    }


    public void close() {
        $(CLOSE_BUTTON).click();
    }
}
