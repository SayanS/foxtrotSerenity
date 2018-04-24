package foxtrot.steps.serenity;

import foxtrot.pages.ShopPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class ShopEndUserSteps {

    ShopPage shopPage;

    @Step
    public void ensureThatPageTitleIs(String title) {
        Assert.assertEquals(title,shopPage.getTitle());
    }

}
