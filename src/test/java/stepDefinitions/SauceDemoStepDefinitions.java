package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pages.SauceDemoMainPage;
import utulities.ConfigReader;
import utulities.Driver;

public class SauceDemoStepDefinitions {

    SauceDemoMainPage sauceDemoMainPage=new SauceDemoMainPage();

    static String item1text;
    static String item1price;
    static String item2text;
    static String item2price;
    static int totalPrice;



    @Given("User opens {string} webpage")
    public void user_opens_webpage(String string) {

        Driver.getDriver().get(ConfigReader.getProperty(string));

    }

    @And("User writes {string} to usernames textbox")
    public void userWritesToUsernamesTextbox(String arg0) {

        sauceDemoMainPage.usernameTextBox.sendKeys(ConfigReader.getProperty(arg0));
    }

    @And("User writes {string} to passwords textbox")
    public void userWritesToPasswordsTextbox(String arg0) {
        sauceDemoMainPage.passWordTextBox.sendKeys(ConfigReader.getProperty(arg0));
    }

    @And("User clicks {string} button")
    public void userClicksButton(String arg0) {

        switch (arg0){

            case"login" :
           sauceDemoMainPage.loginButton.click();
           break;
        }
    }


    public void itemAssertDatas(){

       item2text=sauceDemoMainPage.firstRondomAddedItem.getText();
       item1text=sauceDemoMainPage.secondRondomAddedItem.getText();
       item1price=sauceDemoMainPage.firstRondomAddedItemPrice.getText();
       item1price=sauceDemoMainPage.secondRondomAddedItemPrice.getText();


       totalPrice=Integer.valueOf(item1price)+Integer.valueOf(item2price);

        System.out.println(item1text+item2text+totalPrice);

    }

    @And("User chooses random two product and adds them to cart")
    public void userChoosesRandomTwoProductAndAddsThemToCart() {

        itemAssertDatas();
    }
}
