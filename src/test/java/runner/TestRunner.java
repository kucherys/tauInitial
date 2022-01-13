package runner;

import io.cucumber.testng.CucumberOptions;
import tests.TestBase;

@CucumberOptions(features="src/test/resources/features"
,glue = {"steps"}
,plugin = {"pretty","html:target/cucumber-html-report.html"}
,tags = "@landIOS") //testIOS  landIOS
public class TestRunner extends TestBase {
}
