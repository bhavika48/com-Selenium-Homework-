package testsuite;

import browserFactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessfully() {
        // click on the ‘Register’ link
        driver.findElement(By.linkText("Register")).click();
        String expectedText = "Register";
        WebElement actualMenuTab = driver.findElement(By.xpath("//h1[contains(text(),'Register')]"));
        String actualText = actualMenuTab.getText();
        Assert.assertEquals("Register message is not displayed", expectedText, actualText);
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        // finding details for registration page
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.cssSelector("label[for='gender']"));
        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("gender-female")).click();
        WebElement firstName = driver.findElement(By.id("FirstName"));
        firstName.sendKeys("Prina");
        WebElement lastName = driver.findElement(By.id("LastName"));
        lastName.sendKeys("Shah");
        WebElement date = driver.findElement(By.name("DateOfBirthDay"));
        date.sendKeys("08");
        WebElement month = driver.findElement(By.name("DateOfBirthMonth"));
        month.sendKeys("01");
        WebElement year = driver.findElement(By.name("DateOfBirthYear"));
        year.sendKeys("1984");
        driver.findElement(By.id("Email")).sendKeys("prina123@gmail.com");
        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("prina09");
        WebElement confirmPassword = driver.findElement(By.id("ConfirmPassword"));
        confirmPassword.sendKeys("prina09");
        WebElement registerButton = driver.findElement(By.id("register-button"));
        registerButton.click();
        // verify "Your registration completed" message
        String expectedMessage = "Your registration completed";
        WebElement registerMessage = driver.findElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        String actualRegisterMessage = registerMessage.getText();
        Assert.assertEquals("Registeratioin message is not displayed", expectedMessage, actualRegisterMessage);

    }

    @After
    public void tearDown() {
        // closeBrowser();
    }


}
