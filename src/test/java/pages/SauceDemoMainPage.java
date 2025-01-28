package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utulities.Driver;

import javax.xml.xpath.XPath;
import java.util.List;
import java.util.Random;

public class SauceDemoMainPage {

    public SauceDemoMainPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }





    @FindBy(xpath = "//input[@id='user-name' and @name='user-name']")
    public WebElement usernameTextBox;

    @FindBy(xpath = "//input[@id='password' and @name='password']")
    public WebElement passWordTextBox;

    @FindBy(xpath = "//input[@id='login-button' and @name='login-button']")
    public WebElement loginButton;

    //düzeltme sonrası alttaki elementlerin kodta yeri yok ama kaldırmadım lazım olabilir diye

    @FindBy(xpath = "(//a[@id='item_4_title_link)")
    public WebElement firstRandomAddedItem;

    @FindBy(xpath = "//a[@id='item_0_title_link']")
    public WebElement secondRandomAddedItem;

    @FindBy(xpath = "(//div[@data-test='inventory-item-price'])[1]")
    public WebElement firstRandomAddedItemPrice;

    @FindBy(xpath = "(//div[@data-test='inventory-item-price'])[2]")
    public WebElement secondRandomAddedItemPrice;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    public WebElement firstProductAddToCartButton;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']")
    public WebElement secondProductAddToCartButton;

    @FindBy(xpath = "//a[@data-test='shopping-cart-link']")
    public WebElement cartButton;

    @FindBy(xpath = "//button[@id='checkout']")
    public WebElement checkoutButton;

    @FindBy(className = "inventory_item")
    public List<WebElement> addToCartButtons;




















}
