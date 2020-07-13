package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static helpers.TestData.roboUrl;

public class TwoBrowserTestPage {

    public WebDriver driver;

    public TwoBrowserTestPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "rcd-btn-lg")
    public static WebElement getLoan;

    @FindBy(id = "lastName")
    public static WebElement lastName;

    @FindBy(id = "firstName")
    public static WebElement firstName;

    @FindBy(id = "middleName")
    public static WebElement middleName;

    @FindBy(id = "email")
    public static WebElement email;

    @FindBy(id = "phone")
    public static WebElement phone;



    @Step("Шаг открытия страницы авторизации")
    public static void openMainPage(WebDriver driver) {
        driver.get(roboUrl);
    }

}
