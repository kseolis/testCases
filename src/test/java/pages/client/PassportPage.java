package pages.client;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static helpers.TestData.*;
import static pages.client.BasePage.typeIntoMaskedInput;

public class PassportPage {
    public WebDriver driver;

    public PassportPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static String fieldSeriesNumber = "seriesNumber";
    @FindBy(id = "seriesNumber")
    public static WebElement seriesNumber;

    public static String fieldIssuedAt = "issuedAt";
    @FindBy(id = "issuedAt")
    public static WebElement issuedAt;

    public static String fieldBirthday = "birthday";
    @FindBy(id = "birthday")
    public static WebElement birthday;

    public static String fieldSubdivision = "subdivision";
    @FindBy(id = "subdivision")
    public static WebElement subdivision;

    public static String fieldIssuer = "issuer";
    @FindBy(id = "issuer")
    public static WebElement issuer;

    public static String fieldBirthplace = "birthplace";
    @FindBy(id = "birthplace")
    public static WebElement birthplace;

    @FindBy(xpath = "//button[@color='yellow']")
    public static WebElement proceedButtonPassportPage;

    @Step("Ввод паспортных данных клиента")
    public static void inputClientPassportData(WebDriver driver) {
        typeIntoMaskedInput(driver, fieldSeriesNumber, passportData);
        typeIntoMaskedInput(driver, fieldIssuedAt, passportDateData);
        typeIntoMaskedInput(driver, fieldBirthday, birthdayData);
        typeIntoMaskedInput(driver, fieldSubdivision, subdivisionData);
        typeIntoMaskedInput(driver, fieldIssuer, issuerData);
        typeIntoMaskedInput(driver, fieldBirthplace, birthplaceData);
    }

    public static void waitProceedButtonPassportPage(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(proceedButtonPassportPage, "ПРОДОЛЖИТЬ"));
    }
}
