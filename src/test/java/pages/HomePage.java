package pages;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import lombok.SneakyThrows;
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


    @BeforeAll
    @SneakyThrows
    public void openURL() {
        System.out.println("Website is launching");
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
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

    public void clickSearchButton(){
        searchButton.click();
    }

    @SneakyThrows
    public String getActualFoodName(String foodName) {
        Thread.sleep(2000);
        WebElement actualProductName = driver.findElement(By.className("product-name"));
        String actualFoodName = actualProductName.getText().toLowerCase().trim();
        System.out.println(actualFoodName);
        return actualFoodName;
    }


    @AfterAll
    public void tearDown() {
        System.out.println("Close the browser window");
        driver.quit();
    }

}
