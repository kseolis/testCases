package pages.admin;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static helpers.TestData.*;
import static pages.client.BasePage.inputData;

public class AdminAuthorisationPage {
    public WebDriver driver;

    public AdminAuthorisationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "h1")
    public static WebElement adminTitle;

    @FindBy(name = "login")
    public static WebElement adminLogin;

    @FindBy(name = "password")
    public static WebElement adminPassword;

    @FindBy(css = "button.btn-block")
    public static WebElement loginButton;

    @Step("Шаг открытия страницы авторизации")
    public static void openAdminPage(WebDriver tempDriver) {
        tempDriver.get(roboUrlAdmin);
    }

    @Step("Ввод данных админа")
    public static void inputAuthorisationData() {
        inputData(adminLogin, adminLoginData);
        inputData(adminPassword, adminPassData);
    }

    @Step("Ожидание главной страницы админки")
    public static void waitAdminHomePage(WebDriver tempDriver) {
        WebDriverWait wait = new WebDriverWait(tempDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(adminTitle, textToAdminTitle));
    }
}
