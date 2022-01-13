package steps;

import PageObjects.CreateTaskPage;
import PageObjects.LaunchPage;
import PageObjects.TasksListPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.TestBase;
import org.testng.Assert;


import java.io.IOException;
import java.util.List;
import java.util.Map;

public class LandingSteps extends TestBase {

    LaunchPage iosLaunchPage;

    @Given("Appium server and simulator with application type {string} started")
    public void appiumServerAndApplicationiOSRunning(String appType) throws IOException, InterruptedException {
//        setupClassGlobal(appType);
        System.out.println("TEST " + appType + " TESTS RUNNING IN CUCUMBER");
//        Android_setUp();
        startServer();
        iOS_setUp();
//        iOS_setUpDigibank();
        System.out.println(appType + " EMULATOR STARTED");
        iosLaunchPage = new LaunchPage(driver);
    }

//    @When("I verify landing page is loaded")
//    public void verifyLandingPageLoaded() {
//        if (getAppType().equals("iOS") ) {
//            iosLaunchPage = new LaunchPage(iosDriver);
//            Assert.assertTrue(iosLaunchPage.isLoaded(iosDriver));
//        } else if (appType.equals("Android") ) {
//            androidLaunchPage = new AndroidLaunchPage(androidDriver);
//            Assert.assertTrue(androidLaunchPage.isLoaded(androidDriver));
//        }
//    }

    @Then("I verify elements on landing page")
    public void verifyElementsLandingDataPage(DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
//        if (getAppType().equals("iOS")) {
            for (Map<String, String> row : rows) {
                iosLaunchPage.verifyLogInButton(row.get("logInButton"));
                iosLaunchPage.verifyWelcomeLabel(row.get("logoLabel"));
                iosLaunchPage.verifySignUpButton(row.get("signUpButton"));
            }
//        } else if (getAppType().equals("Android")) {
//            for (Map<String, String> row : rows) {
//                androidLaunchPage.verifyLogInButton(row.get("logInButton"));
//                androidLaunchPage.verifyWelcomeLabel(row.get("logoLabel"));
//                androidLaunchPage.verifySignUpButton(row.get("signUpButton"));
//            }
//        }
    }


    @Then("I confirm tests completed with result {string} and stop Appium server")
    public void confitmTests(String result) {
        System.out.println("CUCUMBER TESTS PASSED WITH RESULT: " + result);
        driver.hideKeyboard();
        tearDown();
        System.out.println("STOP APPIUM SERVER INITIAL STEPS CLASS");


        service.stop();

    }

    @When("I print text {string}")
    public void printText(String result) {
        System.out.println("CUCUMBER TESTS are running: " + result);

    }

    @Then("I print login button name")
    public void printButtonName() {
        System.out.println("BUTTON NAME IS : " + iosLaunchPage.getLogInButtonName());

    }

//    @After
//    public void stopAppiumServer(){
//        System.out.println("Stop appium server form INITIAL STEPS CLASS");
//        service.stop();
//    }
}
