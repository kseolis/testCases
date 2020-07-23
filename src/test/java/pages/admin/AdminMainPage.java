package pages.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminMainPage {
    public WebDriver driver;

    public AdminMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Клиенты")
    public static WebElement clientsLink;

    @FindBy(xpath = "(//a[@href='http://127.0.0.1/employee/client'])[2]")
    public static WebElement clientsPage;
}
