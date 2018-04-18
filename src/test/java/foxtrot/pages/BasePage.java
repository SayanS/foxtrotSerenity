package foxtrot.pages;

public class BasePage extends MyPageObject {
    private HeaderPage header;
    private FooterPage footer;

    public FooterPage getFooter() {
        return footer;
    }

    public HeaderPage getHeader(){
        return header;
    }
}
