package foxtrot.pages;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PreCartPopup extends MyPageObject {
    private String TITLE = "//div[@id='popup-precart']//div[@class='popup-header']/p";
    private String PRODUCT_NAME = "//div[@id='popup-precart']//div[@class='popup-body']//div[@class='name']/p";
    private String GOTOCART_BUTTON = "//div[@id='popup-precart']//div[@class='popup-body']//div[@id='precart-go-to-cart-btn']/button";
    private String PROCEED_PURCHASE_BUTTON = "//div[@id='popup-precart']//div[@class='cart-footer']//div[@data-popup-close='true']/button";
    private String SPINNER = "//div[@class='overlay visible']";

    @Step
    public void ensureThatPreCartPopupIsOpened() {
        try {
            waitFor(ExpectedConditions.invisibilityOfElementLocated(By.xpath(SPINNER)));
        } catch (Exception e) {
        }
        Assert.assertTrue("PrecartPopup isn't opened", $(TITLE).isDisplayed());
    }

    @Step
    public void ensureThatPreCartPopupContainsProduct(String productName) {
        Assert.assertEquals(productName, $(PRODUCT_NAME).getText());
    }

    @Step
    public void clickOnGoToCartButton() {
        $(GOTOCART_BUTTON).click();
    }
}
