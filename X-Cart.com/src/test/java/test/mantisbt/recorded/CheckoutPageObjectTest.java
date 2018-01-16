/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.mantisbt.recorded;

import mantisbt.pageObjects.CartPageObject;
import mantisbt.pageObjects.HomePageObject;
import static org.junit.Assert.assertTrue;
import org.junit.runner.RunWith;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Ollie
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    CartPageObjectTest.class,})


public class CheckoutPageObjectTest {

    private RemoteWebDriver driver;
    private String baseUrl;
    private CheckoutPageObjectTest checkoutPage;
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
        new CartPageObjectTest().testAddItem();
      
    }
}
