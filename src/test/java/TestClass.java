import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.chromium.ChromiumOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestClass {
    ChromeDriver driver = new ChromeDriver();
//    ChromeOptions options = new ChromeOptions();
//    options.addArguments("start-maximized");


    /**
     * Task 1:
     * Open Google Chrome
     * Navigate to [https://duckduckgo.com/]
     * Assert that the page title is [Google]
     * Close Google Chrome
     */
    @Test
    public void testTitle() {
        driver.get("https://duckduckgo.com/");
        assert driver.getTitle().equals("Google") : "Title is not as expected";
        driver.quit();
    }


    /**
     * Task 2:
     * Open Google Chrome
     * Navigate to [https://duckduckgo.com/]
     * Assert that the DuckDuckGo logo is displayed
     * Close Google Chrome
    **/

     @Test
    public void testLogo(){
        driver.get("https://duckduckgo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); //outdated formate

//        WebElement logo = driver.findElement(new By.ByClassName("header_headerLeft__rW6nD header_headerSection___XMRI"));
        WebElement logo = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/main/article/div[1]/div[1]/div[2]/div/header/div/section[1]/a/img"));
        boolean res = logo.isDisplayed();
//        System.out.println("Logo is displayed: " + res);
        Assert.assertTrue(res);

        driver.quit();
    }
}
