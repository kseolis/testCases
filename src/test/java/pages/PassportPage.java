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
import static pages.BasePage.enterData;

public class PassportPage {
    public WebDriver driver;

    public PassportPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "seriesNumber")
    public static WebElement seriesNumber;

    @FindBy(id = "issuedAt")
    public static WebElement issuedAt;

    @FindBy(id = "birthday")
    public static WebElement birthday;

    @FindBy(id = "subdivision")
    public static WebElement subdivision;

    @FindBy(id = "issuer")
    public static WebElement issuer;

    @FindBy(id = "birthplace")
    public static WebElement birthplace;

    @FindBy(xpath = "//div/h1[2]")
    public static WebElement passportHeadingText;

    @Step("Ожидание заголовка страницы паспортных данных")
    public static void waitPassportPageHeading(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(passportHeadingText, PassportPageHeadingText));
    }

    @Step("Ввод паспортных данных клиента")
    public static void inputClientPassportData() {
        enterData(seriesNumber, passportData);
        enterData(issuedAt, passportDateData);
        enterData(birthday, birthdayData);
        enterData(subdivision, subdivisionData);
        enterData(issuer, issuerData);
        enterData(birthplace, birthplaceData);
    }
}
