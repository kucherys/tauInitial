package steps;

import PageObjects.o1.EligibilityModalPage;
import PageObjects.o1.ProductCarouselPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import tests.TestBase;

import java.util.List;

public class EligibilityModalSteps extends TestBase {

    ProductCarouselPage prodCarPage;
    EligibilityModalPage eligPage;

    @When("I verify Eligibility criteria modal is loaded")
    public void verifyEligibilityCriteriaModalLoaded() {
        eligPage = new EligibilityModalPage(driver);
        Assert.assertTrue(eligPage.isLoaded());
    }

    @Then("I verify elements on Eligibility criteria modal")
    public void verifyEligibilityCriteriaModal(List<String> listStr) {
        eligPage.verifyEligibilityLabelName("I’m eligible because…");
        eligPage.verifyEligibilityList(listStr);
    }

    @When("I verify if I am eligible")
    public void getEligibilityModal() {
        prodCarPage = new ProductCarouselPage(driver);
        eligPage = prodCarPage.openEligibilityModal(driver);
    }

    @Then("I close eligibility modal")
    public void closeEligibilityModal() {
        eligPage.closeEligibilityModal(driver);
    }
}
