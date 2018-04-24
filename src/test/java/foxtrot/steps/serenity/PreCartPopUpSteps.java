package foxtrot.steps.serenity;

import foxtrot.pages.PreCartPopup;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class PreCartPopUpSteps {

    PreCartPopup preCartPopup;

    @Step
    public void ensureThatPreCartPopupIsOpened(){
        Assert.assertTrue("PrecartPopup isn't opened", preCartPopup.isPreCartPopUpDisplayed());
    }

    @Step
    public void ensureThatPreCartPopupContainsProduct(String productName) {
        Assert.assertEquals(productName, preCartPopup.getProduct());
    }

    @Step
    public void clickOnGoToCartButton(){
        preCartPopup.clickOnGoToCartButton();
    }
}
