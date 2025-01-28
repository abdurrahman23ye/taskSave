package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utulities.Driver;

public class OverviewPage {

    public OverviewPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "(//div[@class='inventory_item_name'])[1]")
    public WebElement firstAddedItem;

    @FindBy(xpath = "(//div[@class='inventory_item_name'])[2]")
    public WebElement secondAddedItem;

    @FindBy(xpath = "(//div[@class='item_pricebar'])[1]")
    public WebElement firstAddedItemPrice;

    @FindBy(xpath = "(//div[@class='item_pricebar'])[2]")
    public WebElement secondAddedItemPrice;

    @FindBy(xpath = "//button[@id='finish']")
    public WebElement finishButton;


















}
