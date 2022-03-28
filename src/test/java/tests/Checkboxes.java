import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Checkboxes {
    public WebDriver driver;
    boolean firstCheckox;
    boolean secondCheckox;

    @BeforeClass
    public void setupBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/checkboxes");

    }

    @Test
    public void verifyCheckboxesTest() {
        firstCheckox = driver.findElement(By.cssSelector("[type=checkbox]")).isSelected();
        Assert.assertEquals( firstCheckox, false);
        driver.findElement(By.cssSelector("[type=checkbox]")).click();
        firstCheckox = driver.findElement(By.cssSelector("[type=checkbox]")).isSelected();
        Assert.assertEquals( firstCheckox, true);
        secondCheckox = driver.findElement(By.cssSelector("[type=checkbox]:last-child")).isSelected();
        Assert.assertEquals( secondCheckox, true);
        driver.findElement(By.cssSelector("[type=checkbox]:last-child")).click();
        secondCheckox = driver.findElement(By.cssSelector("[type=checkbox]:last-child")).isSelected();
        Assert.assertEquals( secondCheckox, false);

    }

    @AfterClass
    public void closeBrowser() {
       driver.quit();

    }

}
