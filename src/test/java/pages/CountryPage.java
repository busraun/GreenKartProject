package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

public class CountryPage {

    WebDriver driver = Driver.getDriver();

    public CountryPage() {
        PageFactory.initElements(driver, this);
    }

    public void dropdownSelect() {

    WebElement dropdownElement = driver.findElement(By.xpath("//select[@style='width: 200px;']"));

    Select dropdown = new Select(dropdownElement);

    dropdown.selectByVisibleText("Germany");
}

     @FindBy(className = "chkAgree")
    public WebElement agreeCheckBox;

    @FindBy(xpath = "//button[text()='Proceed']")
    public WebElement proceedButton;

}




