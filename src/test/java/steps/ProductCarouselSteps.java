package steps;

import PageObjects.o1.LandingPage;
import PageObjects.o1.ProductCarouselPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import tests.TestBase;

import java.util.List;
import java.util.Map;

import static java.lang.Thread.sleep;

public class ProductCarouselSteps extends TestBase {

    LandingPage landingPage;
    ProductCarouselPage prodCarPage;
//    AppFlowPage appFlowPage;

    @When("I verify product carousel page is loaded")
    public void verifyProductCarouselLoaded() {
        prodCarPage = new ProductCarouselPage(driver);
        Assert.assertTrue(prodCarPage.isLoaded());
    }

    @When("I log in to product carousel page")
    public void getProductCarouselPage()  {
        landingPage = new LandingPage(driver);
        prodCarPage = landingPage.logInToProductCarouselPage(driver);
    }

    @Then("I verify elements on product carousel page")
    public void verifyProductCarouselElements(DataTable table) throws InterruptedException {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        for (Map<String, String> row : rows){
            prodCarPage.spinToCarouselPage(row.get("pageNumber"), driver);
            sleep(1000);
            prodCarPage.verifyLogoLabel(row.get("logoText"));
            prodCarPage.verifyOpenBankAccountButton(row.get("openBankAccountButton"));
            prodCarPage.verifyEligibilityLabel(row.get("eligibilityLabel"));
            prodCarPage.verifyInstructionText(row.get("instructionText"));
            prodCarPage.verifyImagePresent();
        }
    }

//    @When("I am openning bank account")
//    public void getAppFlowPage()  {
//        prodCarPage = new ProductCarouselPage(driver);
//        appFlowPage = prodCarPage.getAppFlowPage(driver);
//    }

}
