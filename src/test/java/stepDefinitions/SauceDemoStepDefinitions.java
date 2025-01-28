package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.CheckoutPage;
import pages.CompletePage;
import pages.OverviewPage;
import pages.SauceDemoMainPage;
import utulities.ChoosingRandomItemForAddToCart;
import utulities.ConfigReader;
import utulities.Driver;
import utulities.ReusableMethods;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import static utulities.ChoosingRandomItemForAddToCart.*;

public class SauceDemoStepDefinitions {

    SauceDemoMainPage sauceDemoMainPage=new SauceDemoMainPage();
    CheckoutPage checkoutPage=new CheckoutPage();
    OverviewPage overviewPage=new OverviewPage();
    CompletePage completePage=new CompletePage();
    ChoosingRandomItemForAddToCart choosingRandomItemForAddToCart=new ChoosingRandomItemForAddToCart();






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




    @And("User chooses random two product and adds them to cart")
    public void userChoosesRandomTwoProductAndAddsThemToCart() {

        choosingRandomItemForAddToCart.choosingRandomItem();

     //   sauceDemoMainPage.firstProductAddToCartButton.click();
    //    sauceDemoMainPage.secondProductAddToCartButton.click();
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

        double firstItemPrice=Double.parseDouble(overviewPage.
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
