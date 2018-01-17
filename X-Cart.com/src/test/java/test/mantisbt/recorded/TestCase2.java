/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.mantisbt.recorded;

import java.util.ArrayList;
import java.util.List;
import mantisbt.pageObjects.CartPageObject;
import mantisbt.pageObjects.CheckoutPageObject;
import mantisbt.pageObjects.HomePageObject;
import mantisbt.pageObjects.LoginPageObject;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

/**
 *
 * @author BeryUncool
 */
public class TestCase2 {

    private RemoteWebDriver driver;
    private String baseUrl;
   

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
        driver = new FirefoxDriver();
        baseUrl = "https://demostore.x-cart.com/";

    }

    @Test
    public void testLoginWithValidCredentials() throws Exception {
        LoginPageObject loginPage = new LoginPageObject(baseUrl, driver);
        PageFactory.initElements(driver, loginPage);
        loginPage.open();
        loginPage.clickSignInUp();
        String email = "franta@pepa.com";
        String password = "franta";

        loginPage.setEmailTextField(email);
        loginPage.setPasswordField(password);
        loginPage.clickLoginButton();

        assertTrue("Log message: incorrect username and password", !loginPage.errorDivIsPresent() && !loginPage.errorTextIsPresent());

    }

    @Test(dependsOnMethods = {"testLoginWithValidCredentials"})
    public void testSearchItem() throws Exception {
        HomePageObject homePage = new HomePageObject(baseUrl, driver);
        PageFactory.initElements(driver, homePage);
        homePage.open();
        homePage.searchItem("Apple Iphone 6s");
        assertTrue("Nothing was found", !driver.findElement(By.className("head-h2")).getText().contains("0"));
    }

    //@Test(dependsOnMethods={"testSearchItem"})
    public void testSearchItemAndAddToCart() throws Exception {
        HomePageObject homePage = new HomePageObject(baseUrl, driver);
        PageFactory.initElements(driver, homePage);
        homePage.open();
        homePage.searchItemAndAddToCart("Apple Iphone 6s");
        assertTrue("Iteam was not added.", homePage.isItemAdded());
    }

    @Test(dependsOnMethods={"testSearchItem"})
    public void testBrowseItemAndAddToCart() throws Exception {
        HomePageObject homePage = new HomePageObject(baseUrl, driver);
        PageFactory.initElements(driver, homePage);
        homePage.open();
        homePage.browseItemAndAddToCart("apple-iphone-6-16gb");
        Thread.sleep(2500);
        assertTrue("Item was not added", homePage.isItemAdded());
    }
    
    @Test(dependsOnMethods={"testBrowseItemAndAddToCart"})
    public void testInvalidEmailAddressVAT() throws Exception {
        CheckoutPageObject checkoutPage = new CheckoutPageObject(baseUrl, driver);
        checkoutPage = new CheckoutPageObject(baseUrl, driver);
        PageFactory.initElements(driver, checkoutPage);
        checkoutPage.open();
        checkoutPage.fillEmail("a");
        checkoutPage.fillShippingAddressFirstName("");
        checkoutPage.fillShippingAddressLastName("Vobtahnul");
        checkoutPage.fillShippingAddressStreet("Ritni");
        checkoutPage.fillShippingAddressCity("Los Prdos");
        checkoutPage.fillShippingAddressState("OllieLand");
        checkoutPage.fillShippingAddressZipcode("12212");
        checkoutPage.fillShippingAddressPhone("112567");

        boolean isError = checkoutPage.findErrors().size() >= 1;

        assertTrue("Log message: Field(s) are invalid:" + checkoutPage.findErrors().toString(), isError);
    }
    
     @Test(dependsOnMethods = {"testInvalidEmailAddressVAT"})
    public void testValidEmailAddressVAT() throws Exception {
        CheckoutPageObject checkoutPage = new CheckoutPageObject(baseUrl, driver);
        checkoutPage = new CheckoutPageObject(baseUrl, driver);
        PageFactory.initElements(driver, checkoutPage);
        driver.get(baseUrl+"?target=checkout");
        checkoutPage.fillEmail("a@a.cz");
        checkoutPage.fillShippingAddressFirstName("Karel");
        checkoutPage.fillShippingAddressLastName("Vobtahnul");
        checkoutPage.fillShippingAddressStreet("Ritni");
        checkoutPage.fillShippingAddressCity("Los Prdos");
        checkoutPage.fillShippingAddressState("OllieLand");
        checkoutPage.fillShippingAddressZipcode("12212");
        checkoutPage.fillShippingAddressPhone("112567");

        boolean isError = checkoutPage.findErrors().size() >= 1;

        assertTrue("Log message: Field(s) are invalid:" + checkoutPage.findErrors().toString(), !isError);

    }
    
    @Test(dependsOnMethods = {"testValidEmailAddressVAT"})
    public void testPurchase() throws InterruptedException{
        CheckoutPageObject checkoutPage = new CheckoutPageObject(baseUrl, driver);
        Thread.sleep(2000);
        checkoutPage.placeOrder();
        
        boolean isOkay = checkoutPage.isOrderOkay();
        System.out.println("isOKAY: " + isOkay);
        assertTrue("Log message: Field(s) are invalid:", !isOkay);
    }

}
