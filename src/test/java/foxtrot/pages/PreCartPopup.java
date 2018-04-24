package foxtrot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PreCartPopup extends BasePage {
    private String TITLE = "//div[@id='popup-precart']//div[@class='popup-header']/p";
    private String PRODUCT_NAME = "//div[@id='popup-precart']//div[@class='popup-body']//div[@class='name']/p";
    private String GOTOCART_BUTTON = "//div[@id='popup-precart']//div[@class='popup-body']//div[@id='precart-go-to-cart-btn']/button";
    private String PROCEED_PURCHASE_BUTTON = "//div[@id='popup-precart']//div[@class='cart-footer']//div[@data-popup-close='true']/button";
    private String SPINNER = "//div[@class='overlay visible']";

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


}
