/*********************************************************************************************************************************************************************************
 * @author : Lakshmi Ay
 * This is the junit Test runner class which initiates the tests for clear trip
 * flight booking site
 ***********************************************************************************************************************************************************************************/

package testrunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepdefinitions",
        plugin = {"pretty", "json:target/cucumberreport.json", "pretty",
                "html:target/site/cucumber-pretty/cucumberreport.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true,
        dryRun = false,
        tags = "@earlymorningflight"
)
public class TestRunner {

}
