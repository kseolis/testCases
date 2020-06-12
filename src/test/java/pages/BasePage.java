package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;

public class BasePage {

    public static ThreadLocal<WebDriver> tDriver = new ThreadLocal<>();
    public WebDriver driver;

    public static synchronized WebDriver getDriver() {
        return tDriver.get();
    }

    @Step("Создание веб драйвера с заданными параметрами")
    public WebDriver initializeDriver() {
        WebDriverManager.getInstance(CHROME).config().setChromeDriverVersion("83");
        WebDriverManager.getInstance(CHROME).setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();



        return getDriver();
    }

}
