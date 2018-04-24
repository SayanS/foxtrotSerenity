package foxtrot.steps;

import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import utilities.EmailUtilities;

import java.util.Map;

public class EmailDefinitionSteps {
    @Steps
    EmailUtilities emailUtilities;

    @When("^Read email messages with credentials$")
    public void readEmailMessagesWithCredentials(Map<String, String> emailCredentials) {
          emailUtilities.ReadEmail(emailCredentials);
    }
}
