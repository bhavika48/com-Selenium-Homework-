package testsuite;

import browserFactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToComputerPageSuccessfully() {
        // click on computers link
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text() = 'Computers ']")).click();
        String expectedMenuText = "Computers";
        WebElement actualText = driver.findElement(By.xpath("//h1[contains(text(),'Computers')]"));
        String actualMenuText = actualText.getText();
        Assert.assertEquals("Computers text is not displayed", expectedMenuText, actualMenuText);
    }

    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully() {
        // click and verifying  the ‘Electronics’ Tab
        driver.findElement(By.linkText("Electronics")).click();
        String expectedMenuText = "Electronics";
        WebElement actualText = driver.findElement(By.xpath("//div[contains(@class,'page-title')]"));
        String actualMenuText = actualText.getText();
        Assert.assertEquals("Electronics text is not displayed", expectedMenuText, actualMenuText);
    }

    @Test
    public void userShouldNavigateToApparelPageSuccessfully() {
        // click and verifying the ‘Apparel’ Tab
        driver.findElement(By.linkText("Apparel")).click();
        String expectedText = "Apparel";
        WebElement actualMenuText = driver.findElement(By.xpath(" //h1[contains(text(),'Apparel')]"));
        String actualText = actualMenuText.getText();
        Assert.assertEquals("Apparel text is not displayed", expectedText, actualText);

    }

    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully() {
        // click and verify the ‘Digital downloads’ Tab
        driver.findElement(By.linkText("Digital downloads")).click();
        String expectedText="Digital downloads";
       WebElement actualMenuText= driver.findElement(By.xpath("//h1[contains(text(),'Digital downloads')]"));
       String actualText=actualMenuText.getText();
       Assert.assertEquals("Digital downloads is not displayed",expectedText,actualText);

    }
@Test
public void  userShouldNavigateToBooksPageSuccessfully(){
        // click and verify the ‘Books’ Tab
    driver.findElement(By.linkText("Books")).click();
    String expectedText="Books";
    WebElement actualMenuText=driver.findElement(By.xpath("//h1[contains(text(),'Books')]"));
    String actualText=actualMenuText.getText();
    Assert.assertEquals("Books is not displayed",expectedText,actualText);


}
@Test
public void userShouldNavigateToJewelryPageSuccessfully (){
        // click and verify the ‘Jewelry’ Tab
    driver.findElement(By.linkText("Jewelry")).click();
    String expectedText="Jewelry";
    WebElement actualMenuText=driver.findElement(By.xpath("//h1[contains(text(),'Jewelry')]"));
    String actualText=actualMenuText.getText();
    Assert.assertEquals("Jewellery is not displayed",expectedText,actualText);


}
    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully() {
        driver.findElement(By.linkText("Gift Cards")).click();
        String expectedText="Gift Cards";
        WebElement actualMenuText=driver.findElement(By.xpath("//h1[contains(text(), 'Gift Cards')]"));
        String actualText=actualMenuText.getText();
        Assert.assertEquals("Gift card is not displayed",expectedText,actualText);
    }


    @After
    public void tearDown() {
        closeBrowser();
    }


}
