package pages.admin;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static helpers.TestData.*;

public class AdminClientPage {
    public WebDriver driver;

    public AdminClientPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "h1")
    public static WebElement adminTitle;

    @FindBy(xpath = "//table[@id='client-list-table']/tbody/tr/td[2]/a")
    public static WebElement item;

    @FindBy(id = "client-list-filters-base-search")
    public static WebElement searchField;

    @FindBy(css = "#client-list-filters-base-search-type")
    public static WebElement searchFieldType;

    @FindBy(xpath = "//option[@value='phone']")
    public static WebElement phoneOption;

    @Step("Ожидание страницы клиентов")
    public static void waitAdminClientsPage(WebDriver tempDriver) {
        WebDriverWait wait = new WebDriverWait(tempDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(adminTitle, textToAdminTitleClients));
    }

    @Step("Подтверждение записи клиента в админке.")
    public static void assertSeeClient(WebDriver tempDriver) {
        WebDriverWait wait = new WebDriverWait(tempDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(item));
        Assert.assertEquals(item.getAttribute("innerHTML"), fullName);
    }
}
