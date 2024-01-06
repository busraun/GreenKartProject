package step_defs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.SneakyThrows;
import org.junit.Assert;
import pages.CartPage;
import pages.CountryPage;
import pages.HomePage;

public class CompletePurchaseStep {

    HomePage homePage =new HomePage();
    CartPage cartPage=new CartPage();

    CountryPage countryPage=new CountryPage();


    @And("writes a food name and quantity {string} {string}")
    public void writesAFoodNameAndQuantity(String foodName, String quantity) {
        homePage.typeFoodNameandQuantity(foodName,quantity);
    }

    @And("clicks Add to Cart button")
    public void clicksAddToCartButton() {
        homePage.clickAddToCartButton();
    }

    @SneakyThrows
    @And("goes to cart and complete purchase")
    public void goesToCartAndCompletePurchase() {
        homePage.goToCart();
        homePage.proceedToCheckoutButton.click();
        Thread.sleep(3000);
        cartPage.windowsHandle();
        Thread.sleep(3000);
        cartPage.placeOrderButton.click();
        cartPage.windowsHandle();
        Thread.sleep(3000);
        countryPage.dropdownSelect();
        countryPage.agreeCheckBox.click();
        countryPage.proceedButton.click();

    }

    @Then("redirect to home page again")
    public void redirectToHomePageAgain() {
       homePage.verifyHomePage();
    }
}
