package steps;

import PageObjects.CreateTaskPage;
import PageObjects.TasksListPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import tests.TestBase;

import java.io.IOException;
import java.net.MalformedURLException;

public class CreateNewTaskWithData extends TestBase {

    CreateTaskPage createTaskPage;
    TasksListPage tasksListPage;

    @Given("Click add new Task")
    public void clickAddNewTask() throws IOException, InterruptedException {
        Android_setUp();
        tasksListPage = new TasksListPage(driver);
        createTaskPage = new CreateTaskPage(driver);
        tasksListPage.clickAddTaskBtn();
    }

    @Given("Print another task number {string}")
    public void printTask2(String task) throws MalformedURLException {
        System.out.println("IOS TESTS CUCUMBER :" + task);
    }

    @Given("Enter {string} and {string}")
    public void enterAnd(String taskName, String taskDesc) {
        createTaskPage.enterTaskName(taskName);
        createTaskPage.enterTaskDesc(taskDesc);
    }

    @Then("Task Added Successfully")
    public void taskAddedSuccessfully() {
        driver.hideKeyboard();
        tearDown();
    }
}
