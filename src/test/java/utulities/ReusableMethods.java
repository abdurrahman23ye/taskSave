package utulities;



import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
;

import java.io.File;
import java.io.IOException;


public class ReusableMethods {



    public static String getScreenshot(String name) throws IOException {
        // naming the screenshot with the current date to avoid duplication

        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = "D:\\SouseDemoTaskCucumber\\src\\test\\Target\\" + name + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given


        FileUtils.copyFile(source, finalDestination);
        return target;
    }

}

