package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utulities.Driver;


public class Hooks {
    /*



     */

     @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()) {
        final byte[] screenshot=((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png","screenshots");
        }
      Driver.closeDriver();
    }
}
