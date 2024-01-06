package pages;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {

    WebDriver driver= Driver.getDriver();

    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy (className = "search-keyword")
    WebElement searchBox;

    @FindBy(className = "search-button")
    WebElement searchButton;

    @FindBy(className = "quantity")
    WebElement quantityBox;

    @FindBy(xpath = "//button[text()='ADD TO CART']")
    WebElement addToCartButton;

    @FindBy(xpath = "//img[@alt='Cart']")
    WebElement cartButton;

    @FindBy(xpath = "//button[text()='PROCEED TO CHECKOUT']")
    public WebElement proceedToCheckoutButton;


    @BeforeAll
    @SneakyThrows
    public void openURL() {
        System.out.println("Website is launching");
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }

    @SneakyThrows
    public void clickSearchBox(){
        searchBox.click();
        Thread.sleep(2000);
    }

    public void typeFoodName(String foodNameText){
        searchBox.clear();
        searchBox.sendKeys(foodNameText);
    }

    @SneakyThrows
    public void typeFoodNameandQuantity(String foodNameText, String quantityText){
        searchBox.clear();
        searchBox.sendKeys(foodNameText);
        Thread.sleep(3000);
        quantityBox.clear();
        Thread.sleep(2000);
        quantityBox.sendKeys(quantityText);
    }

    public void clickSearchButton(){

        searchButton.click();
    }

    @SneakyThrows
    public void clickAddToCartButton(){
        Thread.sleep(3000);
        addToCartButton.click();
    }

    public void goToCart(){
        cartButton.click();
    }

    @SneakyThrows
    public String getActualFoodName(String foodName) {
        Thread.sleep(2000);
        WebElement actualProductName = driver.findElement(By.className("product-name"));
        String actualFoodName = actualProductName.getText().toLowerCase().trim();
        return actualFoodName;
    }


    @AfterAll
    public void tearDown() {
        System.out.println("Close the browser window");
        driver.quit();
    }

    @SneakyThrows
    public void verifyHomePage() {
        Thread.sleep(7000);
        String currentUrl= driver.getCurrentUrl();
        String expectedUrl= "https://rahulshettyacademy.com/seleniumPractise/#/";
        Assert.assertEquals(expectedUrl,currentUrl);
    }
}
