package SeleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
    public static WebDriver driver = getDriver();
    public WebDriverWait wait;
    private String userName = "ihar.kastsenich@itechart-group.com";
    private String password = "qwaszx@1";

    protected User user = new User(userName, password);
    public static final String url = "http://www.google.com";
    public static final String locale = "en";



    public static WebDriver getDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\Java Practice\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=" + locale);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

    public static void waitForElementToBeVisible(By by) {
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

}
