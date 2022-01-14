package steps;

import PageObjects.CreateTaskPage;
import PageObjects.TasksListPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.TestBase;

import java.net.MalformedURLException;

public class CreateNewTaskSteps extends TestBase {
    CreateTaskPage createTaskPage;
    TasksListPage tasksListPage;

    @Given("Click Add new Task")
    public void clickAddNewTask() throws MalformedURLException {
        System.out.println("EXPERIMENTAL IOS TESTS RUNNING IN CUCUMBER");
//        Android_setUp();
//        startServer();
        iOS_setUp();
//        iOS_setUpRyse();
        System.out.println("IOS EMULATOR STARTED");
        tasksListPage = new TasksListPage(driver);
        createTaskPage = new CreateTaskPage(driver);
        tasksListPage.clickAddTaskBtn();
    }

    @Given("Print task number {string}")
    public void printTask1(String task) throws MalformedURLException {
        System.out.println("IOS TESTS CUCUMBER :" + task);
    }

    @Given("Enter TaskName")
    public void enterTaskName() {
        createTaskPage.enterTaskName("Task 1");
    }

    @Given("Enter TaskDesc")
    public void enterTaskDesc() {
        createTaskPage.enterTaskDesc("Desc 2");
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
//        service.stop();
    }

//    @After
//    public void stopAppiumServer(){
//        System.out.println("Stop appium server form INITIAL STEPS CLASS");
//        service.stop();
//    }
}
