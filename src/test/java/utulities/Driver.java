package utulities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    //başka claslarlarda obje oluşturulmasın driver ile ilgili her şey bu classtan yapılsın
    private Driver(){

    }
    static WebDriver driver;

    public static WebDriver getDriver(){

        //propertiesten browserın değeri atanabilsin her işlemde tekrar yeni sayfa açılmaması için driver null
        //ise tekrar değer alması üzerine yapı kuruldu.
        if (driver==null) {
            switch (ConfigReader.getProperty("browser")){
                case "chrome" :

                    driver = new ChromeDriver();
                    break;
                case "safari" :

                    driver=new SafariDriver();
                    break;
                case "firefox" :

                    driver=new FirefoxDriver();
                    break;

                default:
                 //driver da ya da configuration dosyasında hata çıkarsa default olarak chrome çalışsın
                    driver = new ChromeDriver();

            }

           //globall driver ayarlarını buraya ekliyorum
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }

    public static void closeDriver(){
        if (driver!=null){ // driver'a deger atanmissa
            driver.close();
           driver=null;
        }

    }

}
