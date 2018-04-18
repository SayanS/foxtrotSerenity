package foxtrot.steps.serenity;

import foxtrot.pages.HomePageObject;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.core.pages.PageObject.withParameters;

public class ShopEndUserSteps {
    HomePageObject homePage;

    @Step
    public void openHomePage() {
        homePage.open("base.url", withParameters("https://kharkiv.foxtrot.ua/"));
    }
}
