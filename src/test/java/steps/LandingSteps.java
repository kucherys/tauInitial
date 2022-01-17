package steps;

import PageObjects.LandingPage;
import PageObjects.TasksListPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.TestBase;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

public class LandingSteps extends TestBase {

    LandingPage landingPage;

    @Given("Appium server with {string} real application is running")
    public void setUpRyse(String appType) throws MalformedURLException {
        System.out.println(appType + " TESTS RUNNING IN CUCUMBER");
//        startServer();
        if (appType.equals("Android")) {
            Android_setUp();
        } else if (appType.equals("iOS")) {
            iOS_setUpRyse();
        }
        System.out.println(appType + " EMULATOR STARTED");
    }


    @When("I print login button name")
    public void printButtonName() {
        landingPage = new LandingPage(driver);
        System.out.println("BUTTON NAME IS : " + landingPage.getLogInButtonName());

    }

    @When("I print SignIn button name")
    public void printSignInButtonName() {
        landingPage = new LandingPage(driver);
        System.out.println("BUTTON NAME IS : " + landingPage.getSignInButtonName());

    }

    @Then("I confirm tests completed with result {string}")
    public void confitmTests(String result) {
        System.out.println("CUCUMBER TESTS PASSED WITH RESULT: " + result);

    }


    @After
    public void stopAppiumServer(){
        System.out.println("Stop appium server form INITIAL STEPS CLASS");
//        service.stop();
    }
}
