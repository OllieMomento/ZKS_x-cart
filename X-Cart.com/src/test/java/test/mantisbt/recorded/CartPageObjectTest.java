/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.mantisbt.recorded;

import java.util.concurrent.TimeUnit;
import mantisbt.pageObjects.CartPageObject;
import mantisbt.pageObjects.HomePageObject;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.chrome.ChromeDriver;
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
    
    //@BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
        //System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        driver = new FirefoxDriver();
        //driver = new ChromeDriver();
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
        
        assertTrue("Log message: Item wasnt added", homePage.isItemAdded());
     
    }
    
    @Test(dependsOnMethods = {"testAddItem"})
    public void testChangeQuantity() throws Exception {  
        cartPage = new CartPageObject(baseUrl, driver);  
        PageFactory.initElements(driver, cartPage);
        cartPage.open();
        cartPage.changeQuantity("3");
        Thread.sleep(3000);
        assertTrue("Log message: Items wasnt changed", cartPage.isChangeOkay("3"));
    }
    
    @Test
        //(dependsOnMethods = {"testChangeQuantity"})
    public void testRemoveItem() throws Exception {  
        cartPage = new CartPageObject(baseUrl, driver);  
        PageFactory.initElements(driver, cartPage);
        cartPage.open();
        cartPage.removeItem();
        Thread.sleep(3000);
        
        assertTrue("Log message: Cart is not empty", cartPage.isCartEmpty());
    }
    
}
