package step_defs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.HomePage;

import static utilities.Driver.driver;

public class SearchFoodStep {

    HomePage homePage =new HomePage();

    private String searchedFoodName;

    @Given("user navigates home page")
    public void userNavigatesHomePage() {
        homePage.openURL();
    }

    @When("clicks search box")
    public void clicksSearchBox() {
        homePage.clickSearchBox();
    }

    @And("writes a vegetable or fruit name {string}")
    public void writesAVegetableOrFruitName(String foodName) {
        homePage.typeFoodName(foodName);
        searchedFoodName = foodName;
    }

    @And("clicks search button")
    public void clicksSearchButton() {
        homePage.clickSearchButton();

    }

    @Then("sees the {string}")
    public void seesThe(String foodName) {

        Assert.assertEquals(true, searchedFoodName.isEmpty());
    }
}
