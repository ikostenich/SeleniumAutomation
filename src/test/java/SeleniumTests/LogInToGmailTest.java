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
        String englishLinkText = "English";
        String signInButtonLocator = "//a[@class=\"gb_Ue gb_Ba gb_Tb\"]";
        String emailInputFieldLocator = "zHQkBf";
        String nextButtonLocator = "DL0QTb";
        String enterPasswordLabelLocator = "u3bW4e";
        String passwordFieldLocator = "zHQkBf";
        String userThumbnailLocator = "gbii";


        WebElement changeLanguageEnglishLink = driver.findElement(By.linkText(englishLinkText));
        changeLanguageEnglishLink.click();


        //Click the sign in button
        WebElement signInButton = driver.findElement(By.xpath(signInButtonLocator));
        signInButton.click();

        //Enter email address
        WebElement emailsImput = driver.findElement(By.className(emailInputFieldLocator));
        emailsImput.sendKeys(user.getUserName());

        //Click the "Next" button
        WebElement nextButton = driver.findElement(By.className(nextButtonLocator));
        nextButton.click();

        //Enter password
        waitForElementToBeVisible(By.className(enterPasswordLabelLocator));
        WebElement passwordField = driver.findElement(By.className(passwordFieldLocator));
        passwordField.sendKeys(user.getPassword());

        //Click the "Next" button
        nextButton = driver.findElement(By.className(nextButtonLocator));
        nextButton.click();

        //Find the user thumbnail
        waitForElementToBeVisible(By.className(userThumbnailLocator));
        WebElement userIcon = driver.findElement(By.className(userThumbnailLocator));
        Assert.assertNotNull(userIcon);

    }
}
