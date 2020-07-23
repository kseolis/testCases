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

import static helpers.TestData.phoneData;
import static helpers.TestData.textToAdminTitleClients;

public class AdminClientPage {
    public WebDriver driver;

    public AdminClientPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "h1")
    public static WebElement adminTitle;

    @FindBy(xpath = "//tbody/tr[1]/td[3]")
    public static WebElement clientPhone;

    @Step("Ожидание страницы клиентов")
    public static void waitAdminClientsPage(WebDriver tempDriver) {
        WebDriverWait wait = new WebDriverWait(tempDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(adminTitle, textToAdminTitleClients));
    }

    @Step("Подтверждение записи клиента в админке.")
    public static void assertSeeClient() {
        System.out.println(phoneData);
        System.out.println(clientPhone.getText());
        Assert.assertEquals(phoneData, clientPhone.getText());
    }
}
