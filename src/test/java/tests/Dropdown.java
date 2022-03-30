package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Dropdown extends BaseTest {

    private static final String BASE_URL = "http://the-internet.herokuapp.com/dropdown";

    @Test
    public void dropdownTest() {
        driver.get(BASE_URL);
        WebElement element = driver.findElement(By.id("dropdown"));
        Select select = new Select( element);
        select.selectByVisibleText("Option 1");
        String selectedOptionFirst = select.getFirstSelectedOption().getText();
        Assert.assertEquals(selectedOptionFirst, "Option 1");
        select.selectByVisibleText("Option 2");
        String selectedOptionSecond = select.getFirstSelectedOption().getText();
        Assert.assertEquals(selectedOptionSecond, "Option 2");
    }
}