package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pages.CheckoutPage;
import pages.CompletePage;
import pages.OverviewPage;
import pages.SauceDemoMainPage;
import utulities.ConfigReader;
import utulities.Driver;
import utulities.ReusableMethods;

import java.io.IOException;

public class SauceDemoStepDefinitions {

    SauceDemoMainPage sauceDemoMainPage=new SauceDemoMainPage();
    CheckoutPage checkoutPage=new CheckoutPage();
    OverviewPage overviewPage=new OverviewPage();
    CompletePage completePage=new CompletePage();


    static String item1text;
    static String item1price;
    static String item2text;
    static String item2price;
    static double totalPrice;



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

            case"cart" :
                sauceDemoMainPage.cartButton.click();
                break;

            case"checkout" :
                ((JavascriptExecutor) Driver.getDriver()).
                        executeScript("arguments[0].scrollIntoView(true);", sauceDemoMainPage.checkoutButton);
                sauceDemoMainPage.checkoutButton.click();
                break;

            case"continue" :
                checkoutPage.continueButton.click();
                break;

            case"finish" :
                overviewPage.finishButton.click();
                break;






        }
    }


    public void itemAssertDatas(){

       item1text=sauceDemoMainPage.firstRandomAddedItem.getText();
       item2text=sauceDemoMainPage.secondRandomAddedItem.getText();
       item1price=sauceDemoMainPage.firstRandomAddedItemPrice.getText().
               replace("$","");
       item2price=sauceDemoMainPage.secondRandomAddedItemPrice.getText().replace("$","");


       totalPrice=Double.valueOf(item1price)+Double.valueOf(item2price);



    }

    @And("User chooses random two product and adds them to cart")
    public void userChoosesRandomTwoProductAndAddsThemToCart() {

        itemAssertDatas();

        sauceDemoMainPage.firstProductAddToCartButton.click();
        sauceDemoMainPage.secondProductAddToCartButton.click();
    }

    @And("User fills name,last name and zip code infos to the textboxs")
    public void userFillsNameLastNameAndZipCodeInfosToTheTextboxs() {

        ((JavascriptExecutor) Driver.getDriver()).
                executeScript("arguments[0].scrollIntoView(true);", checkoutPage.firstNameTextbox);

        checkoutPage.firstNameTextbox.sendKeys(ConfigReader.getProperty("name"));
        checkoutPage.lastNameTextbox.sendKeys(ConfigReader.getProperty("lastName"));
        checkoutPage.postalCodeTextbox.sendKeys(ConfigReader.getProperty("zip"));




    }

    @And("User verifies added products and total price")
    public void userVerifiesAddedProductsAndTotalPrice() {

        double firstItemPrice=Double.valueOf(overviewPage.
                firstAddedItemPrice.getText().replace("$",""));

        double secondItemPrice=Double.valueOf(overviewPage.
                secondAddedItemPrice.getText().replace("$",""));

        double actualResult=firstItemPrice+secondItemPrice;


        Assert.assertEquals(item1text,overviewPage.firstAddedItem.getText());
        Assert.assertEquals(item2text,overviewPage.secondAddedItem.getText());
        Assert.assertEquals(totalPrice, actualResult, 0.0);
    }

    @Then("User verifies complete transaction by the see the text that include {string}")
    public void userVerifiesCompleteTransactionByTheSeeTheTextThatInclude(String arg0) throws IOException {

        Assert.assertTrue(completePage.completeMessageLabel.getText().contains(arg0));

        ReusableMethods.getScreenshot("transactionCompleteText");
    }



    @Then("User close web page")
    public void userCloseWebPage() {
        Driver.closeDriver();
    }
}
