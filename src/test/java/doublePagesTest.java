import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.PersonalPage;

import static helpers.TestData.*;
import static pages.AddressesPage.*;
import static pages.BasePage.*;
import static pages.PassportPage.*;
import static pages.PersonalPage.*;

public class doublePagesTest {
    public WebDriver driver;
    public BasePage basePage;

    @BeforeMethod
    private void setupClass() {
        basePage = new BasePage();
        driver = basePage.initializeDriver();
        PersonalPage page = new PersonalPage(driver);
    }

    @Test(description = "Тест СНИЛС идентификации", priority = 1)
    public void testSnils() {
        // Первый шаг регистрации. Данные клиента(ФИО, email, телефон);
        openMainPage(driver);
        clickButton(driver, getLoan);
        waitElementLoanApplication(driver);
        inputClientData();
        clickButton(driver, acceptAgreement);
        clickButton(driver, proceedButtonPersonalPage);
        // Подтверждение номера телефона;
        waitPhoneVerification(driver);
        enterData(code, acceptPhoneData);
        clickButton(driver, acceptPhoneButton);
        // Второй шаг регистрации. Паспортные данные клиента;
        waitPassportPageHeading(driver);
        inputClientPassportData();
        clickButton(driver, proceedButtonPassportPage);
        // Третий шаг регистрации. Адрес клиента и доп.контакты;
        waitAddressPageHeading(driver);
        inputAddressesAndAdditionalContact();
    }

/*    @AfterMethod
    public void tearDown(ITestResult result) {
        makeScreenOnTestFail(result);
        if (driver != null) {
            driver.quit();
        }
    }*/
}
