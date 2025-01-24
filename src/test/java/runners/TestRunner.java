package runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin={"html:src/test/Target/cucumber-reports.html",

        },
        features = "src/test/resources/features",
        glue= "stepDefinitions",
        tags= "@task",
        dryRun = false
)


public class TestRunner {

}