import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestClass {

    @Test
    public void testMethod() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://duckduckgo.com/");
        driver.manage().window().maximize();
        driver.quit();
    }
}
