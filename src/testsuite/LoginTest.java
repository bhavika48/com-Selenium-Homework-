package testsuite;

import browserFactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        // find the login link and click on login
        WebElement login = driver.findElement(By.linkText("Log in"));
        login.click();

        // verify message displayed as expected
        String expectedMessage = "Welcome, Please Sign In!";
        WebElement actualTextMessage = driver.findElement(By.xpath("//h1[contains(text(), 'Welcome, Please Sign In!')]"));
        String actualMessage = actualTextMessage.getText();
        Assert.assertEquals("Not redirected to login page", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // verify valid credentials
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();

        // find email field element
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("bhavikapatel@gmail.com");

        // find password field element
        driver.findElement(By.id("Password")).sendKeys("admin09");

        // click on login button
        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        loginButton.click();

        // verify log out text
        String expectedMessage = "Log out";
        WebElement actualTextElement = driver.findElement(By.linkText("Log out"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Log out text is not displayed",expectedMessage, actualMessage);
    }

    @Test
    public void verifyTheErrorMessage() {
        // verify invalid credentials
        // click on login link
        WebElement login = driver.findElement(By.linkText("Log in"));
        login.click();

        // find the email field element
       WebElement emailField = driver.findElement(By.id("Email"));
       emailField.sendKeys("prinaparekh@gmail.com");

       // find password field element
       driver.findElement(By.id("Password")) .sendKeys("prina01");

       // click on login button
        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();

        // verify error message
        String expectedMessage="Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
       WebElement actualMessageElement =  driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']"));
        String actualMessage=actualMessageElement.getText();
        Assert.assertEquals("Login Error message not displayed",expectedMessage,actualMessage);


    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
