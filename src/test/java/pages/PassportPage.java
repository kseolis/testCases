package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    @FindBy(xpath = "//div[2]/div/button")
    public static WebElement proceedButtonPassportPage;

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
