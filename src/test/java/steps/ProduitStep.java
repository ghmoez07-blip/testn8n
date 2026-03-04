package steps;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import pages.LoginPage;
import pages.ProduitPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ProduitStep {

    WebDriver driver;
    ProduitPage produitPage;
    LoginPage loginPage;


    @Given("je suis sur la page home")
    public void je_suis_sur_la_page_home() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // IMPORTANT : Pas d'interface graphique
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");
        loginPage =new LoginPage(driver);
        produitPage=new ProduitPage(driver);
        loginPage.enterusername("standard_user");
        loginPage.enterpasseword("secret_sauce");
        loginPage.clicklogin();

    }

    @When("je clique sur le button add to cart")
    public void je_clique_sur_le_button_add_to_cart() {
        produitPage.clickaddcart();
    }

    @When("je clique sur button panier")
    public void je_clique_sur_button_panier() {
        produitPage.clickpanier();
    }

    @Then("le produit est ajouté avec succés")
    public void le_produit_est_ajouté_avec_succés() {
        //Assert.assertEquals(produitPage.nomproduit(),produitPage.nomproduitpanier());
        driver.quit();
    }

}
