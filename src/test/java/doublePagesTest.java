import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.admin.AdminAuthorisationPage;
import pages.admin.AdminClientPage;
import pages.admin.AdminMainPage;
import pages.client.BasePage;
import pages.client.PassportPage;
import pages.client.PersonalPage;

import static helpers.TestData.acceptPhoneData;
import static pages.admin.AdminAuthorisationPage.*;
import static pages.admin.AdminClientPage.*;
import static pages.admin.AdminMainPage.clientsLink;
import static pages.admin.AdminMainPage.clientsPage;
import static pages.client.BasePage.*;
import static pages.client.PassportPage.inputClientPassportData;
import static pages.client.PersonalPage.*;

public class doublePagesTest {
    public WebDriver driver;
    public BasePage basePage;

    @BeforeMethod
    private void setupClass() {
        basePage = new BasePage();
        driver = basePage.initializeDriver();
        PersonalPage personalPage = new PersonalPage(driver);
        PassportPage passportPage = new PassportPage(driver);
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
        inputData(code, acceptPhoneData);
        clickButton(driver, acceptPhoneButton);
        // Второй шаг регистрации. Паспортные данные клиента;
        waitPassportPageHeading(driver);
        inputClientPassportData(driver);

        // Открытие второго браузера, на стороне админа;
        WebDriver tempDriver = basePage.initializeDriver();
        AdminAuthorisationPage login = new AdminAuthorisationPage(tempDriver);
        AdminMainPage mainPage = new AdminMainPage(tempDriver);
        AdminClientPage clientPage = new AdminClientPage(tempDriver);

        openAdminPage(tempDriver);
        inputAuthorisationData();
        clickButton(tempDriver, loginButton);
        waitAdminHomePage(tempDriver);

        clickButton(tempDriver, clientsLink);
        clickButton(tempDriver, clientsPage);
        waitAdminClientsPage(tempDriver);
        assertSeeClient();
        tempDriver.close();

/*        waitProceedButtonPassportPage(driver);
        clickButton(driver, proceedButtonPassportPage);
        // Третий шаг регистрации. Адрес клиента и доп.контакты;
        waitAddressPageHeading(driver);
        inputAddressesAndAdditionalContact();*/
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        makeScreenOnTestFail(result);
        if (driver != null) {
            driver.quit();
        }
    }
}
