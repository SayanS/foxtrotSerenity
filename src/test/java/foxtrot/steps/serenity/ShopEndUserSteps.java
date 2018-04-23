package foxtrot.steps.serenity;

import foxtrot.pages.HomePage;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.core.pages.PageObject.withParameters;

public class ShopEndUserSteps {
    HomePage homePage;

    @Step
    public void openHomePage() {
        homePage.open("base.url", withParameters("https://kharkiv.foxtrot.ua/"));
    }
}
