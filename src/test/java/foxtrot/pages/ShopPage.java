package foxtrot.pages;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class ShopPage extends BasePage {
    String PAGE_TITLE="//h1";

    @Step
    public void ensureThatPageTitleIs(String title) {
        Assert.assertEquals(title,$(PAGE_TITLE).getText());
    }
}
