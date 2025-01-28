package utulities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.SauceDemoMainPage;

import java.util.Random;

public class ChoosingRandomItemForAddToCart {

   public WebElement firstRandomAddingItem;
   public WebElement SecondRandomAddingItem;

 public    static String item1text;
 public    static String item1price;
 public    static String item2text;
 public    static String item2price;
 public    static double totalPrice;





        public void choosingRandomItem() {

            SauceDemoMainPage sauceDemoMainPage = new SauceDemoMainPage();


            Random random = new Random();

            int firstIndx = random.nextInt(sauceDemoMainPage.addToCartButtons.size());
            int secondIndx;

            do {
                secondIndx = random.nextInt(sauceDemoMainPage.addToCartButtons.size());
            } while (firstIndx == secondIndx);


            firstRandomAddingItem = sauceDemoMainPage.addToCartButtons.get(firstIndx);
          item1text= firstRandomAddingItem.findElement(By.className("inventory_item_name")).getText();
          item1price= firstRandomAddingItem.findElement(By.className("inventory_item_price")).getText().
                  replace("$","");;
            firstRandomAddingItem.findElement(By.className("btn_inventory")).click();


            SecondRandomAddingItem = sauceDemoMainPage.addToCartButtons.get(secondIndx);
        item2text=   SecondRandomAddingItem.findElement(By.className("inventory_item_name")).getText();
            item2price= SecondRandomAddingItem.findElement(By.className("inventory_item_price")).
                    getText().replace("$","");
                SecondRandomAddingItem.findElement(By.className("btn_inventory")).click();


            totalPrice=Double.valueOf(item1price)+Double.valueOf(item2price);

        }







}
