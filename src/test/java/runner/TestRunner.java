package runner;

import io.cucumber.testng.CucumberOptions;
import tests.TestBase;

@CucumberOptions(features="src/test/resources/features/CreateTask.feature"
,glue = {"steps"}
,plugin = {"pretty","html:target/cucumber-html-report.html"}
,tags = "@testAndroid")
public class TestRunner extends TestBase {
}
