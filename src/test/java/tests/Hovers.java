package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.*;

public class Hovers extends BaseTest {

    private static final String BASE_URL = "http://the-internet.herokuapp.com/hovers";
    private static final String NOT_FOUND = "Not Found";
    private static String BASE_FIGURE_PATH = "//div[@class='figure'][%s]//%s";
    private static  int FIRST_INDEX = 0;


    @BeforeClass
    public void setupBrowser1() {
        System.out.println("11111111111");
    }


    @Test(priority = 1)
        public void confirmNameOfFirstUser(){
        driver.get(BASE_URL);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElements(By.className("figure")).get(FIRST_INDEX)).perform();
        String user1NameText = driver.findElement(getUserNameTextLocator(1)).getText();
        Assert.assertEquals(user1NameText, "name: user1");
        }


    @Test(dependsOnMethods = "confirmNameOfFirstUser", priority = 2)
        public void verifyClickOnFirstUser() {
            driver.findElement(getUserLinkLocator(1)).click();
            Assert.assertEquals(getNotFoundText(), NOT_FOUND);
        }


    @Test(priority = 3)
    public void confirmNameOfSecondUser(){
        driver.get(BASE_URL);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElements(By.className("figure")).get(1)).perform();
        String user1NameText = driver.findElement(getUserNameTextLocator(2)).getText();
        Assert.assertEquals(user1NameText, "name: user2");
    }

    @Test(dependsOnMethods = "confirmNameOfSecondUser", priority = 4)
    public void verifyClickOnSecondUser() {
        driver.findElement(getUserLinkLocator(2)).click();
        Assert.assertEquals(getNotFoundText(), NOT_FOUND);
    }

    @Test(priority = 5)
    public void confirmNameOfThirdUser(){
        driver.get(BASE_URL);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElements(By.className("figure")).get(2)).perform();
        String user1NameText = driver.findElement(getUserNameTextLocator(3)).getText();
        Assert.assertEquals(user1NameText, "name: user3");
    }

    @Test(dependsOnMethods = "confirmNameOfThirdUser", priority = 6)
    public void verifyClickOnThirdUser() {
        driver.findElement(getUserLinkLocator(3)).click();
        Assert.assertEquals(getNotFoundText(), NOT_FOUND);
    }

    private By getUserNameTextLocator(int userNumber) {
        return By.xpath(String.format(BASE_FIGURE_PATH, userNumber, "h5"));
    }

    private By getUserLinkLocator(int userNumber) {
        return By.xpath(String.format(BASE_FIGURE_PATH, userNumber, "a"));
    }

    private String getNotFoundText() {
        return driver.findElement(By.xpath("//body")).getAttribute("innerText");
    }

}
