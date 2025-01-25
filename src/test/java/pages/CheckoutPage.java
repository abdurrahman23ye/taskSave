package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utulities.Driver;

public class CheckoutPage {

    public CheckoutPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//input[@id='first-name']")
    public WebElement firstNameTextbox;

    @FindBy(xpath = "//input[@id='last-name']")
    public WebElement lastNameTextbox;

    @FindBy(xpath = "//input[@id='postal-code']")
    public WebElement postalCodeTextbox;

    @FindBy(xpath = "//input[@id='continue']")
    public WebElement continueButton;



















}
