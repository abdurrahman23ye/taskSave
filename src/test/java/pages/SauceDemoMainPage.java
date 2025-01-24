package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utulities.Driver;

import javax.xml.xpath.XPath;

public class SauceDemoMainPage {

    public SauceDemoMainPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
//butun locatorlarda tek özellik uniquese bile yine de ikiser tane özellik kullanmaya özen gösterdim

    @FindBy(xpath = "//input[@id='user-name' and @name='user-name']")
    public WebElement usernameTextBox;

    @FindBy(xpath = "//input[@id='password' and @name='password']")
    public WebElement passWordTextBox;

    @FindBy(xpath = "//input[@id='login-button' and @name='login-button']")
    public WebElement loginButton;



    @FindBy(xpath = "//a[@id='item_4_title_link']")
    public WebElement firstRandomAddedItem;

    @FindBy(xpath = "//a[@id='item_0_title_link']")
    public WebElement secondRandomAddedItem;

    @FindBy(xpath = "//div[@data-test='inventory-item-price'][1]")
    public WebElement firstRandomAddedItemPrice;

    @FindBy(xpath = "//div[@data-test='inventory-item-price'][2]")
    public WebElement secondRandomAddedItemPrice;












}
