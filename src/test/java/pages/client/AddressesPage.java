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
import static pages.client.BasePage.inputData;

public class AddressesPage {
    public WebDriver driver;

    public AddressesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "registeredAddress")
    public static WebElement registeredAddress;

    @FindBy(id = "equalAddresses")
    public static WebElement equalAddresses;

    @FindBy(xpath = "//form/h1[2]")
    public static WebElement addressesHeadingText;

    @FindBy(id = "phones[0].number")
    public static WebElement additionalPhone;

    @FindBy(id = "phones[0].ownerName")
    public static WebElement ownerName;

    @Step("Заполнение адреса и доп.контактов")
    public static void inputAddressesAndAdditionalContact() {
        inputData(registeredAddress, registeredAddressData);
        inputData(additionalPhone, passportDateData);
        inputData(ownerName, birthdayData);
    }

    @Step("Ожидание заголовка страницы адреса")
    public static void waitAddressPageHeading(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.
        until(ExpectedConditions.
        textToBePresentInElement(addressesHeadingText, addressesPageHeadingText));
    }
}
