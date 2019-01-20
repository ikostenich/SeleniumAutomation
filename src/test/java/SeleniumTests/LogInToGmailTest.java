package SeleniumTests;

import SeleniumTests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LogInToGmailTest extends BaseTest {
    String recipient = "i.kostenich@gmail.com";
    String subject = Utils.generateRandomString(10, true, true);
    String emailBody = Utils.generateRandomString(100, true, true);

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

    @Test
    public void OpenGmail() {
        By menuButtonLocator = By.className("gb_xc");
        By menuLocator = By.className("gb_da");
        By gmailButtonLocator = By.id("gb23");
        By gmailTopIconLocator = By.className("gb_2e");

        waitForElementToBeVisible(menuButtonLocator);
        driver.findElement(menuButtonLocator).click();

        //Wait for menu to appear
        waitForElementToBeVisible(menuLocator);

        //Click the Gmail button
        WebElement gmailButton = driver.findElement(gmailButtonLocator);
        gmailButton.click();

        //Check that page is opened
        Assert.assertNotNull(driver.findElement(gmailTopIconLocator));
    }

    @Test
    public void OpenNewMessageWindow() {
        By composeButtonLocator = By.xpath("//div[@class=\"T-I J-J5-Ji T-I-KE L3\"]");
        By newMessageWindowLocator = By.className("AD");

        //Click the "Compose" button
        driver.findElement(composeButtonLocator).click();

        //Checck if "New Message" window is opened
        Assert.assertNotNull(driver.findElement(newMessageWindowLocator));

    }

    @Test(priority = 2)
    public void EnterEmailDataAndSaveDraft() {
        By recipientListLocator = By.className("vO");
        By subjectListLocator = By.name("subjectbox");
        By emailInputAreaLocator = By.id(":ap");
        By savedLabelLocator = By.id(":8y");

        //Enter Recipient
        driver.findElement(recipientListLocator).sendKeys(recipient);

        //Enter Subject
        driver.findElement(subjectListLocator).sendKeys(subject);

        //Enter Email data
        driver.findElement(emailInputAreaLocator).sendKeys(emailBody);

        //Check that data is saved
        Assert.assertNotNull(driver.findElement(savedLabelLocator));
    }

    @Test(priority = 3)
    public void CloseEmailWindow() {
        By saveAndCloseButtonLocator = By.xpath("//img[@data-tooltip=\"Save & close\"]");
        By newMessageWindowLocator = By.className("AD");
        WebElement newMessageWindow;

        //Click the Save and Close button
        driver.findElement(saveAndCloseButtonLocator).click();


        //Check that window was closed

        Assert.assertNull(driver.findElement(newMessageWindowLocator));
    }


    @Test(priority = 4)
    public void OpenDraft() {
        By darftsLinkLocator = By.linkText("Drafts");
        String draftEmailLocatorXpath = "//div[@class=\"xS\" and ./div/div/span/span/text()='" + subject + "']";
        By draftEmailLocator = By.xpath(draftEmailLocatorXpath);
        By newMessageWindowLocator = By.className("AD");
        By recipientListLocator = By.xpath("//div[@class='oL aDm az9']/span");
        By subjectLocator = By.xpath("//input[@name='subject']");
        By draftBodyLocator = By.className("LW-avf");
        String recipientDraftValue;
        String subjectDraftValue;
        String draftBodyValue;

        //Open the Drafts page
        driver.findElement(darftsLinkLocator).click();

        //Find the saved draft
        WebElement draftEmail = driver.findElement(draftEmailLocator);
        Assert.assertNotNull(draftEmail);
        draftEmail.click();

        //Check that window is opened
        Assert.assertNotNull(driver.findElement(newMessageWindowLocator));


        //Check the recipient value
        recipientDraftValue = driver.findElement(recipientListLocator).getText();
        Assert.assertTrue(recipientDraftValue.equals(recipient));

        //Check subject value
        subjectDraftValue = driver.findElement(subjectLocator).getAttribute("value");
        Assert.assertTrue(subjectDraftValue.equals(subject));

        //Check draft body
        draftBodyValue = driver.findElement(draftBodyLocator).getText();
        Assert.assertTrue(draftBodyValue.equals(emailBody));


    }


}
