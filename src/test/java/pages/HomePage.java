package pages;

import lombok.SneakyThrows;
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


    @SneakyThrows
    public void openURL() {
        System.out.println("Website is launching");
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        System.out.println("Website is launched");
        Thread.sleep(1000);

    }

    @SneakyThrows
    public void clickSearchBox(){
        searchBox.click();
        Thread.sleep(2000);
    }

    public void typeFoodName(String foodNameText){
        searchBox.sendKeys(foodNameText);
    }

    public void clickSearchButton(){
        searchButton.click();
    }




}
