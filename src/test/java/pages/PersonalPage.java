package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static helpers.TestData.*;

public class PersonalPage {

    public WebDriver driver;

    public PersonalPage(WebDriver driver) {
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

    @FindBy(id = "acceptAgreement")
    public static WebElement acceptAgreement;

    @FindBy(id = "code")
    public static WebElement code;

    @FindBy(tagName = "h1")
    public static WebElement loanApplication;

    @FindBy(xpath = "//div[2]/div/button")
    public static WebElement proceed;

    @FindBy(xpath = "//div[2]/div/div/h1")
    public static WebElement phoneVerification;

    @FindBy(xpath = "//form/div[3]/div/button")
    public static WebElement acceptPhoneButton;

    @FindBy(xpath = "//div/h1[2]")
    public static WebElement passportHeadingText;

    @Step("Шаг открытия страницы авторизации")
    public static void openMainPage(WebDriver driver) {
        driver.get(roboUrl);
    }

    @Step("Ожидание текста после авторизации")
    public static void waitElementLoanApplication(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(loanApplication, loanApplicationText));
    }

    @Step("Ввод данных")
    public static void enterData(WebElement element, String data) {
        element.sendKeys(data);
    }

    @Step("Ожидание текста подтверждения номера")
    public static void waitPhoneVerification(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(phoneVerification, PhoneVerificationText));
    }

    @Step("Ожидание заголовка страницы паспортных данных")
    public static void waitPassportPageHeading(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(passportHeadingText, PassportPageHeadingText));
    }
}
