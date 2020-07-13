package pages;

import io.qameta.allure.Step;
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

    @Step("Шаг открытия страницу авторизации")
    public static void openLoginPage(WebDriver driver) {
        driver.get(url);
    }

    @Step("Ввод логина")
    public static void enterLogin(WebElement element, String login) {
        element.sendKeys(login);
    }

    @Step("Ввод пароля")
    public static void enterPassword(WebElement element, String password) {
        element.sendKeys(password);
    }

    @Step("Ожидание текста после авторизации")
    public static void waitingElement(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(subHeader, loginText));
    }

    @Step("Проверка успешной авторизации пользователя")
    public static void userIsAuthorized(WebDriver driver) {
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
        Assert.assertEquals(loginText, subHeader.getText());
    }

    @Step("Проверка отображения ошибки при некорректном логине")
    public static void invalidLogin(WebDriver driver) {
        String textFlash = driver.findElement(By.id("flash")).getText();
        Assert.assertEquals(alertUserNameText, textFlash);
    }

    @Step("Проверка отображения ошибки при некорректном пароле")
    public static void invalidPassword(WebDriver driver) {
        String textFlash = driver.findElement(By.id("flash")).getText();
        Assert.assertEquals(alertPasswordText, textFlash);
    }
}
