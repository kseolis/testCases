import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.PageLogin;

import static pages.PageLogin.*;
import static helpers.TestData.*;

public class FirstTest {

    public WebDriver driver;
    public PageLogin page;

    @BeforeMethod
    private void setupClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        page = new PageLogin(driver);
    }

    @Test(description = "Тест на корректную авторизацию", priority = 0)
    public void testValidLoginAndPassword() {

        openLoginPage(driver);

        maximizeBrowser(driver);

        enterLogin(userNameField, username);

        enterPassword(passField, password);

        clickLoginButton();

        waitingElement(driver);

        assertForValidLoginAndPassword(driver);
    }

    @Test(description = "Тест некорректного логина", priority = 1)
    public void testInvalidLogin() {

        openLoginPage(driver);

        maximizeBrowser(driver);

        enterLogin(userNameField, invalid);

        enterPassword(passField, password);

        clickLoginButton();

        assertAlertForInvalidLogin(driver);
    }

    @Test(description = "Тест некорректного пароля", priority = 1)
    public void testInvalidPassword() {

        openLoginPage(driver);

        maximizeBrowser(driver);

        enterLogin(userNameField, username);

        enterPassword(passField, invalid);

        clickLoginButton();

        assertAlertForInvalidPassword(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
