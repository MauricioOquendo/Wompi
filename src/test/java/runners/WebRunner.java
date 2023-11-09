package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        stepNotifications = true,
        plugin = {"html:target/cucumber/cucumber-report.html","json:target/cucumber/cucumber.json"},
        features = "src/test/resources/features/",
        glue = {"stepDefinitions"},
        tags = "@NEQUI"
)
public class WebRunner {
}
