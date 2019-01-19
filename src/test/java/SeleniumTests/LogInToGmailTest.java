package SeleniumTests;

import SeleniumTests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LogInToGmailTest extends BaseTest {

    @Test
    public void LogIn() {
        driver.manage().window().maximize();
        String username = "ihar.kastsenich@itechart-group.com";
        String password = "qwaszx@1";

        //Open google.com
        driver.get("http://www.google.com");

        //Switch language
        WebElement changeLanguageEnglishLink = driver.findElement(By.linkText("English"));
        changeLanguageEnglishLink.click();


        //Click the sign in button
        WebElement signInButton = driver.findElement(By.xpath("//a[@class=\"gb_Ue gb_Ba gb_Tb\"]"));
        signInButton.click();

        //Enter email address
        WebElement emailsImput = driver.findElement(By.className("zHQkBf"));
        emailsImput.sendKeys(username);

        //Click the "Next" button
        WebElement nextButton = driver.findElement(By.className("DL0QTb"));
        nextButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("u3bW4e")));

        //Enter password
        WebElement passwordField = driver.findElement(By.className("zHQkBf"));

        passwordField.sendKeys(password);

        //Click the "Next" button
        WebElement nextButton2 = driver.findElement(By.className("DL0QTb"));
        nextButton2.click();

        //Find the user thumbnail
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("gbii")));
        WebElement userIcon = driver.findElement(By.className("gbii"));
        Assert.assertNotNull(userIcon, "test");

        driver.close();
    }
}
