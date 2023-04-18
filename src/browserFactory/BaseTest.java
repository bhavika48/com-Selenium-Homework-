package browserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;

    public void openBrowser(String baseUrl){
        driver=new ChromeDriver();
        // Launch the Url
        driver.get(baseUrl);

        // maximize window
        driver.manage().window().maximize();

        // implicit time out
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    // close browser
    public void closeBrowser(){
        driver.quit();

    }
}
