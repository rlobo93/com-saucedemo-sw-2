package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String BaseUrl = "https://www.saucedemo.com/";

    @Before
    public void setup() {
        openBrowser(BaseUrl);
    }


    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {

        //locate and Enter “standard_user” username
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        //locate and Enter “secret_sauce” password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");


        // Click on ‘LOGIN’ button
        WebElement logIn = driver.findElement(By.id("login-button"));
        logIn.click();

        // Verify the text “PRODUCTS”
        String expectedMessage = "PRODUCTS";
        WebElement actualMessageElements = driver.findElement(By.xpath("//span[contains(text(),'Products')]"));
        String actualMessage = actualMessageElements.getText();
        Assert.assertEquals(expectedMessage,actualMessage);

    }




    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {

        //locate and Enter “standard_user” username
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        //locate and Enter “secret_sauce” password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        // Click on ‘LOGIN’ button
        WebElement logIn = driver.findElement(By.id("login-button"));
        logIn.click();

        //Verify that six products are displayed on page

       // List<WebElement> actualProducts = driver.findElements(By.xpath("//div[@id='']"));
        int expectedNumber = 6;
        List<WebElement> actualNumberElement = driver.findElements(By.className("inventory_item"));
        int actualNumber = actualNumberElement.size();
        Assert.assertEquals(expectedNumber, actualNumber);


    }



    @After
    public void teardown() {
        closeBrowser();
    }


}
