package steps;

import PageObjects.CreateTaskPage;
import PageObjects.TasksListPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.TestBase;

import java.io.IOException;
import java.net.MalformedURLException;

public class CreateNewTaskSteps extends TestBase {
    CreateTaskPage createTaskPage;
    TasksListPage tasksListPage;


    @Given("Appium server with {string} application is running")
    public void setUp(String appType) throws IOException, InterruptedException {
        System.out.println(appType + " TESTS RUNNING IN CUCUMBER");
//            startServer();
        if (appType.equals("Android")) {
//            Android_setUp();
            Android_setUpModified();
        } else if (appType.equals("iOS")) {
            iOS_setUp();
        }
        System.out.println(appType + " EMULATOR STARTED");
    }

    @Given("Click Add new Task")
    public void clickAddNewTask() throws MalformedURLException {
        tasksListPage = new TasksListPage(driver);
        createTaskPage = new CreateTaskPage(driver);
        tasksListPage.clickAddTaskBtn();
    }

    @Given("Print task number {string}")
    public void printTask1(String task) throws MalformedURLException {
        System.out.println("RUN AGAIN :" + task);
    }

    @Given("Enter TaskName")
    public void enterTaskName() {
        createTaskPage.enterTaskName("Task 1");
    }

    @Given("Enter TaskDesc")
    public void enterTaskDesc() {
        createTaskPage.enterTaskDesc("Desc 1");
    }

    @When("Click Save")
    public void clickSave() {
        createTaskPage.clickSaveBtn();
        System.out.println("CLICK SAVE");
    }

    @Then("Task added successfully")
    public void taskAddedSuccessfully() {
        driver.hideKeyboard();
        tearDown();
        System.out.println("STOP APPIUM SERVER INITIAL STEPS CLASS");
    }

    @After
    public void stopAppiumServer(){
        System.out.println("Stop appium server form INITIAL STEPS CLASS");
//        service.stop();
    }
}
