package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utulities.Driver;

public class OverviewPage {

    public OverviewPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//a[@id='item_4_title_link']")
    public WebElement firstAddedItem;

    @FindBy(xpath = "//a[@id='item_0_title_link']")
    public WebElement secondAddedItem;

    @FindBy(xpath = "(//div[@data-test='inventory-item-price'])[1]")
    public WebElement firstAddedItemPrice;

    @FindBy(xpath = "(//div[@data-test='inventory-item-price'])[2]")
    public WebElement secondAddedItemPrice;

    @FindBy(xpath = "//button[@id='finish']")
    public WebElement finishButton;


















}
