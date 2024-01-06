package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.Set;

public class CartPage {

    WebDriver driver= Driver.getDriver();

    public CartPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[text()='Place Order']")
    public WebElement placeOrderButton;


    public void windowsHandle(){
        Set<String> windowHandles = driver.getWindowHandles();

        for (String handle : windowHandles) {
            System.out.println("Window Handle: " + handle);

            driver.switchTo().window(handle);

            System.out.println("Window Title: " + driver.getTitle());
        }
    }



}
