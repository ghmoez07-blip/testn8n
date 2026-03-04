package pages;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProduitPage {
    WebDriver driver;
    WebDriverWait wait;

    By addcart= By.cssSelector("#add-to-cart-sauce-labs-backpack");
    By panier=By.cssSelector("#shopping_cart_container > a");
    By nomproduit =By.cssSelector("#item_4_title_link > div");
    By nomproduitpanier= By.cssSelector("#item_0_title_link > div");

    public ProduitPage (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickaddcart(){

        //driver.findElement(addcart).click();
        //wait.until(ExpectedConditions.presenceOfElementLocated(addcart)).click();
        // Attendre que l'icône du panier soit présente
        wait.until(ExpectedConditions.presenceOfElementLocated(addcart));
        // Forcer le clic via JS
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(addcart));
    }


        public void clickpanier() {
            // Attendre que l'icône du panier soit présente
            wait.until(ExpectedConditions.presenceOfElementLocated(panier));
            // Forcer le clic via JS
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(panier));
        }


    public String nomproduit() {
        return driver.findElement(nomproduit).getText();
    }
    public String nomproduitpanier() {
        return driver.findElement(nomproduitpanier).getText();
    }

}
