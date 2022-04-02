package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NotificationMessages {

    private static final String BASE_URL = "http://the-internet.herokuapp.com/notification_message_rendered";
    protected WebDriver driver;
    String expectedResult = "\n" +
            "            Action successful\n" +
            "            ×\n" +
            "          ";
    String actualResult;



    @BeforeClass
    public void setupBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.setHeadless(false);
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-popup-blocking");
        //chromeOptions.addArguments("--incognito");
        driver = new ChromeDriver(chromeOptions);
        //driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void dropdownTest() {
        driver.get(BASE_URL);
        driver.findElement(By.xpath("//a[text()='Click here']")).click();
        actualResult = driver.findElement(By.xpath("//div[@class='flash notice']")).getAttribute("textContent");
        System.out.println(actualResult);
        //String s = driver.findElement(By.xpath("div[@id='flash']")).getText();
        //System.out.println(s);
        Assert.assertEquals(actualResult, expectedResult);


    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();

    }
}
