package SeleniumTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
    WebDriver driver = getDriver("en");
    public WebDriverWait wait = new WebDriverWait(driver, 30);


    public static WebDriver getDriver(String locale){
        System.setProperty("webdriver.chrome.driver", "C:\\Java Practice\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=" + locale);
        return new ChromeDriver(options);
    }
}
