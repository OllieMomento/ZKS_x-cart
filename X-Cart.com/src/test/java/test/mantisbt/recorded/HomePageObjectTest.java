/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.mantisbt.recorded;

import java.util.concurrent.TimeUnit;
import mantisbt.pageObjects.HomePageObject;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
/**
 *
 * @author Bery
 */
public class HomePageObjectTest {
    private RemoteWebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private final StringBuffer verificationErrors = new StringBuffer();
    private HomePageObject homePage;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        //System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
        baseUrl = "https://demostore.x-cart.com/";
        // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        homePage = new HomePageObject(baseUrl, driver);
        
    }

    @Test
    public void testBrowseItem() throws Exception {
        PageFactory.initElements(driver, homePage);
        homePage.open();
        homePage.browseItemAndView("apple-iphone-6-16gb");
    }
    
    @Test
    public void testBrowseItemAndAddToCart() throws Exception {
        PageFactory.initElements(driver, homePage);
        homePage.open();
        homePage.browseItemAndAddToCart("apple-iphone-6-16gb");
        assertTrue("Item was not added" ,homePage.isItemAdded());
    }
    
    @Test
    public void testHoverItem() throws Exception {
        PageFactory.initElements(driver, homePage);
        homePage.open();
        homePage.browseItemAndAddToCart("apple-iphone-6-16gb");
        
    }
    
    @Test
    public void testSearchItem() throws Exception {
        PageFactory.initElements(driver, homePage);
        homePage.open();
        homePage.searchItem("Apple Iphone 6s");
        
    }
    
    @Test
    public void testSearchItemAndAddToCart() throws Exception {
        PageFactory.initElements(driver, homePage);
        homePage.open();
        homePage.searchItemAndAddToCart("Apple Iphone 6s");
        assertTrue("Iteam was not added.", homePage.isItemAdded());
    }

    @AfterClass
    public void tearDown() throws Exception {
        //driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
