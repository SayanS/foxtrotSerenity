package foxtrot.pages;

public class ShopPage extends BasePage {
    String PAGE_TITLE="//h1";

    public String getTitle() {
        return $(PAGE_TITLE).getText();
    }
}
