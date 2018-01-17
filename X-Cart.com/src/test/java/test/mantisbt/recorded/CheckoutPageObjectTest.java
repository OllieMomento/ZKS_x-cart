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
import org.junit.runner.RunWith;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;

/**
 *
 * @author Ollie
 */
public class CheckoutPageObjectTest {

    private RemoteWebDriver driver;
    private String baseUrl;
    private CheckoutPageObject checkoutPage;
    private LoginPageObject loginPage;
    private HomePageObject homePage;
    private CartPageObject cartPage;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
       //System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
        baseUrl = "https://demostore.x-cart.com/";
        // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    //(dependsOnMethods={"testLoginWithInvalidCredentials"})
    public void testLoginWithValidCredentials() throws Exception {
        loginPage = new LoginPageObject(baseUrl, driver);
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
    public void testAddItemAndCheckout() throws Exception {
        homePage = new HomePageObject(baseUrl, driver);
        PageFactory.initElements(driver, homePage);
        //need to add a item into cart
        homePage.open();
        Thread.sleep(1000);
        homePage.browseItemAndAddToCart("apple-iphone-6-16gb");
        Thread.sleep(1000);

    }

    @Test(dependsOnMethods = {"testAddItemAndCheckout"})
    public void testValidEmailAddressVAT() throws Exception {
        checkoutPage = new CheckoutPageObject(baseUrl, driver);
        PageFactory.initElements(driver, checkoutPage);
        checkoutPage.open();
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

    //@Test(dependsOnMethods={"testAddItemAndCheckout"})
    public void testInvalidEmailAddressVAT() throws Exception {
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

    @Test(dependsOnMethods = {"testValidEmailAddressVAT"})
    public void testValidCreditCard() throws Exception {
        Thread.sleep(2000);
        checkoutPage = new CheckoutPageObject(baseUrl, driver);
        //PageFactory.initElements(driver, checkoutPage);
        //checkoutPage.open();
        Thread.sleep(3000);
        checkoutPage.selectPaymentMethod();
        Thread.sleep(3000);
        checkoutPage.fillCreditCardNumber("4242424200024242");
        //checkoutPage.fillCreditCardExpireMonth("9");
        //checkoutPage.fillCreditCardExpireYear("19");
        //checkoutPage.fillCreditCardName("pan kreditka");
        //checkoutPage.fillCreditCardCVV2("123");
        checkoutPage.placeOrder();
        Thread.sleep(6000);
        checkoutPage.isOrderOkay();

        boolean isOkay = checkoutPage.isOrderOkay();

        assertTrue("Log message: Field(s) are invalid:", isOkay);
    }
}
