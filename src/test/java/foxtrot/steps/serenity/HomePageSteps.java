package foxtrot.steps.serenity;

import foxtrot.pages.HomePage;
import net.thucydides.core.annotations.Step;

public class HomePageSteps {
    HomePage homePage;

    @Step
    public void openHomePage() {
        homePage.open();
    }

}




