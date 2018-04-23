package foxtrot.pages;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;


public class BasePage extends MyPageObject {
    private HeaderPage header;
    private FooterPage footer;

    public FooterPage getFooter() {
        return footer;
    }

    public HeaderPage getHeader(){
        return header;
    }

    @Step
    public void ensureThatCurrentURLContains(String pageName){
        Assert.assertTrue("Url " +getDriver().getCurrentUrl()+" isn't contains "+pageName,getDriver().getCurrentUrl().contains(pageName));
    }
}
