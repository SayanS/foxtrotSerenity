package foxtrot.steps.serenity;

import foxtrot.pages.PreCartPopup;
import foxtrot.pages.ShopPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.util.Map;

public class ShopEndUserSteps {

    ShopPage shopPage;
    PreCartPopup preCartPopup;

    @Step
    public void ensureThatPageTitleIs(String title) {
        Assert.assertEquals(title, shopPage.getTitle());
    }

    @Step
    public void addProductsToCart(Map<String, String> conditionals) {
        conditionals.forEach((productNumber, stockStatus) -> {
            shopPage.getProductListContainer().clickOnAddToCartButton(stockStatus, Integer.valueOf(productNumber));
            preCartPopup.close();
        });

    }
}
