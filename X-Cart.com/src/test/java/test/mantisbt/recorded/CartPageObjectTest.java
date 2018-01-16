/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.mantisbt.recorded;

import java.util.concurrent.TimeUnit;
import mantisbt.pageObjects.CartPageObject;
import mantisbt.pageObjects.HomePageObject;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author Ollie
 */
public class CartPageObjectTest {
    private RemoteWebDriver driver;
    private String baseUrl;
    private CartPageObject cartPage;
    private HomePageObject homePage;
    
    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
        driver = new FirefoxDriver();
        baseUrl = "https://demostore.x-cart.com/";
        // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
         
         
    }
    
    @Test
    public void testAddItem() throws Exception {  
        homePage = new HomePageObject(baseUrl, driver); 
        PageFactory.initElements(driver, homePage);
        //need to add a item into cart
        homePage.open();
        homePage.browseItemAndAddToCart("apple-iphone-6-16gb");
        Thread.sleep(3000);
     
    }
    
    @Test(dependsOnMethods = {"testAddItem"})
    public void testChangeQuantity() throws Exception {  
        cartPage = new CartPageObject(baseUrl, driver);  
        //PageFactory.initElements(driver, cartPage);
        cartPage.open();
        cartPage.changeQuantity("3");
    }
    
}