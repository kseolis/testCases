import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.PageLogin;

import static helpers.TestData.*;
import static pages.BasePage.makeScreenOnTestFail;
import static pages.PageLogin.*;

public class FirstTest {

    public WebDriver driver;
    public BasePage basePage;

    @BeforeMethod
    private void setupClass() {
        basePage = new BasePage();
        driver = basePage.initializeDriver();
        PageLogin page = new PageLogin(driver);
    }

    @Test(description = "Тест на корректную авторизацию", priority = 0)
    public void testValidLoginAndPassword() {
        openLoginPage(driver);
        enterLogin(userNameField, username);
        enterPassword(passField, password);
        clickLoginButton();
        waitingElement(driver);
        userIsAuthorized(driver);
    }

    @Test(description = "Тест некорректного логина", priority = 1)
    public void testInvalidLogin() {
        openLoginPage(driver);
        enterLogin(userNameField, invalid);
        enterPassword(passField, password);
        clickLoginButton();
        invalidLogin(driver);
    }

    @Test(description = "Тест некорректного пароля", priority = 1)
    public void testInvalidPassword() {
        openLoginPage(driver);
        enterLogin(userNameField, username);
        enterPassword(passField, invalid);
        clickLoginButton();
        invalidPassword(driver);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        makeScreenOnTestFail(result);
        if (driver != null) {
            driver.quit();
        }
    }
}
