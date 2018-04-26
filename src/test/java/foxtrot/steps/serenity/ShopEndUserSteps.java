package foxtrot.steps.serenity;

import foxtrot.pages.PreCartPopup;
import foxtrot.pages.ShopPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.util.List;

public class ShopEndUserSteps {

    ShopPage shopPage;
    PreCartPopup preCartPopup;

    @Step
    public void ensureThatPageTitleIs(String title) {
        Assert.assertEquals(title, shopPage.getTitle());
    }

    @Step
    public void clickOnAddToCartButtonFor(List<Integer> itemNumbers) {
        itemNumbers.forEach(itemNumber -> {
            shopPage.getProductListContainer().clickOnAddToCartButton(itemNumber);
            preCartPopup.close();
        });
    }
}
