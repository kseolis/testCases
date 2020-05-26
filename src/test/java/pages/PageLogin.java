package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static helpers.TestData.*;


public class PageLogin {

    public WebDriver driver;

    public PageLogin(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    public static WebElement userNameField;

    @FindBy(id = "password")
    public static WebElement passField;

    @FindBy(className = "radius")
    public static WebElement loginButton;

    @FindBy(className = "subheader")
    public static WebElement subHeader;

    public static void openLoginPage(WebDriver driver) {
        driver.get(url);
    }

    public static void maximizeBrowser(WebDriver driver) {
        driver.manage().window().maximize();
    }

    public static void enterLogin(WebElement element, String login) {
        element.sendKeys(login);
    }

    public static void enterPassword(WebElement element, String password) {
        element.sendKeys(password);
    }

    public static void clickLoginButton() {
        loginButton.click();
    }

    public static void waitingElement(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(subHeader, loginText));
    }

    public static void assertForValidLoginAndPassword(WebDriver driver) {
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
        Assert.assertEquals(loginText, subHeader.getText());
    }

    public static void assertAlertForInvalidLogin(WebDriver driver) {
        String textFlash = driver.findElement(By.id("flash")).getText();
        Assert.assertEquals(alertUserNameText, textFlash);
    }

    public static void assertAlertForInvalidPassword(WebDriver driver) {
        String textFlash = driver.findElement(By.id("flash")).getText();
        Assert.assertEquals(alertPasswordText, textFlash);
    }

}
