package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddRemoveElements {

    public WebDriver driver;
    WebElement addElement;

    @BeforeClass
    public void setupBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        addElement = driver.findElement(By.xpath("//button[text()='Add Element']"));

    }

        @Test
        public void addRemoveElementsTest() {
            addElement.click();
            addElement.click();
            driver.findElement(By.xpath("//button[text()='Delete']")).click();
            int counter = 1;
            int counterOfElements = driver.findElements(By.xpath("//button[text()='Delete']")).size();
            Assert.assertEquals( counterOfElements, counter);

        }

        @AfterClass
        public void closeBrowser() {
            driver.quit();

        }
}
