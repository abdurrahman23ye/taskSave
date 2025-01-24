package stepDefinitions;

import io.cucumber.java.Scenario;
import org.junit.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utulities.Driver;


public class Hooks {
    /*

      Cucumber'da  step definitions package'i icerisinde
      @before, @after gibi bir notasyon varsa
      extends testBase dememize gerek kalmadan
      her scenario'dan once ve/veya sonra bu method'lar calisacaktir

      Bu da bizim isteyecegimiz bir durum degildir

      Cucumber'da @before, @after kullanma ihtiyacimiz olursa
      bunu stepdefinitions package'i altinda olusturacagimiz
      hooks class'ina koyariz

      biz her scenario'dan sonra test sonucunu kontrol edip
      failed olan scenario'lar icin
      screenshoot almasi amaciyla
      @After method'u kullanacagiz

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
