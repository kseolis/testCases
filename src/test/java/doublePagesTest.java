import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.PersonalPage;

import static helpers.TestData.*;
import static pages.BasePage.clickButton;
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
        openMainPage(driver);
        clickButton(driver, getLoan);
        waitElementLoanApplication(driver);

        enterData(lastName, lastNameData);
        enterData(firstName, firstNameData);
        enterData(middleName, middleNameData);
        enterData(phone, phoneData);
        enterData(email, emailData);

        clickButton(driver, acceptAgreement);
        clickButton(driver, proceed);
        waitPhoneVerification(driver);
        enterData(code, acceptPhone);
        clickButton(driver, acceptPhoneButton);
        waitPassportPageHeading(driver);
    }

/*    @AfterMethod
    public void tearDown(ITestResult result) {
        makeScreenOnTestFail(result);
        if (driver != null) {
            driver.quit();
        }
    }*/
}
