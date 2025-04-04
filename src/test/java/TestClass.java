import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Objects;

public class TestClass {
    ChromeDriver driver = new ChromeDriver();
    FirefoxDriver firefoxDriver = new FirefoxDriver();

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
        assert Objects.equals(driver.getTitle(), "Google") : "Title is not as expected";
//        assert driver.getTitle().equals("Google") : "Title is not as expected";
    }


    /**
     * Task 2:
     * Open Google Chrome
     * Navigate to [https://duckduckgo.com/]
     * Assert that the DuckDuckGo logo is displayed
     * Close Google Chrome
     **/

    @Test
    public void testLogo() {
        driver.get("https://duckduckgo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); //deprecated

//        WebElement logo = driver.findElement(new By.ByClassName("header_headerLeft__rW6nD header_headerSection___XMRI")); >> Not working
        WebElement logo = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/main/article/div[1]/div[1]/div[2]/div/header/div/section[1]/a/img"));
        boolean res = logo.isDisplayed();
//        System.out.println("Logo is displayed: " + res);
        Assert.assertTrue(res);

    }


    /**
     * Task 3:
     * Open Google Chrome
     * Navigate to [https://duckduckgo.com/]
     * Search for [Selenium WebDriver]
     * Assert that the link of the first result is [https://www.selenium.dev/documentation/webdriver/]
     * Close Google Chrome
     */
    @Test
    public void testSearch() {
        driver.navigate().to("https://duckduckgo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        WebElement searchBox = driver.findElement(By.id("searchbox_input"));
        searchBox.sendKeys("Selenium WebDriver");
        searchBox.submit();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

//        WebElement firstResult = driver.findElement(By.id("r1-0")); >> Clicks on another link in the first result
        WebElement firstResult = driver.findElement(By.cssSelector("#r1-0 > div.OQ_6vPwNhCeusNiEDcGp > div > div > a"));

        String firstResultLink = firstResult.getDomAttribute("href");
//        firstResult.click();
//        String firstResultLink = driver.getCurrentUrl();
        Assert.assertEquals(firstResultLink, "https://www.selenium.dev/documentation/webdriver/");

    }


    /** Task 4: Not done yet
     * Open Mozilla Firefox
     * Navigate to [https://duckduckgo.com/]
     * Search for [TestNG]
     * Assert that the text of the fourth result is [TestNG Tutorial]
     * Close Mozilla Firefox
     */
    @Test
    public void testFirefoxSearch(){
        firefoxDriver.get("https://duckduckgo.com/");
        firefoxDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        WebElement searchBox = firefoxDriver.findElement(By.id("searchbox_input"));
        searchBox.sendKeys("TestNG");
        searchBox.submit();
        firefoxDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

//        WebElement fourthResult = firefoxDriver.findElement(By.className("Rn_JXVtoPVAFyGkcaXyK VkOimy54PtIClAT3GMbr"));
//        WebElement fourthResult = firefoxDriver.findElement(By.id("r1-3"));
//        fourthResult.click();
        WebElement fourthResult = firefoxDriver.findElement(By.xpath("//*[@id=\"r1-3\"]/div[3]/h2/a/span"));
        String fourthResultText = fourthResult.getText();
        Assert.assertEquals(fourthResultText, "TestNG Tutorial");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
        firefoxDriver.quit();
    }

}
