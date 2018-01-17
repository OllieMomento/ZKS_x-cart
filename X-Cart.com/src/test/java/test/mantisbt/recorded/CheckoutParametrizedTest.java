/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.mantisbt.recorded;

import java.util.Iterator;
import mantisbt.pageObjects.CartPageObject;
import mantisbt.pageObjects.CheckoutPageObject;
import mantisbt.pageObjects.HomePageObject;
import mantisbt.pageObjects.LoginPageObject;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.AllPairsHellper2;
import utils.AllPairsHellperObject;
import utils.CSVReader;

/**
 *
 * @author BeryUncool
 */
public class CheckoutParametrizedTest {
     private RemoteWebDriver driver;
    private String baseUrl;
    private CheckoutPageObject checkoutPage;
    private LoginPageObject loginPage;
    private HomePageObject homePage;
    private CartPageObject cartPage;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
       System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
        //System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        driver = new FirefoxDriver();
        //driver = new ChromeDriver();
        baseUrl = "https://demostore.x-cart.com/";
        // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test  
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
        homePage.browseItemAndAddToCart("apple-iphone-6-16gb");
        Thread.sleep(3000);
        assertTrue("", homePage.isItemAdded());
    }
    
    @DataProvider(name = "dataCheckout")
    public static Object[][] data() {
        AllPairsHellper2 allPairsObject=  new AllPairsHellper2();
        return allPairsObject.getData();
       
    }

    @Test(dependsOnMethods = {"testAddItemAndCheckout"},dataProvider = "dataCheckout")
    public void testValidEmailAddressVAT(String jmeno, String prijmeni, String adresa, String mesto, String zeme, String stat, String psc, String metoda, String cisloKreditky, String mesic, String rok, boolean expected) throws Exception {
        checkoutPage = new CheckoutPageObject(baseUrl, driver);
        PageFactory.initElements(driver, checkoutPage);
        checkoutPage.open();
        checkoutPage.fillEmail("a@a.cz");
        checkoutPage.fillShippingAddressFirstName(jmeno);
        checkoutPage.fillShippingAddressLastName(prijmeni);
        checkoutPage.fillShippingAddressStreet(adresa);
        checkoutPage.fillShippingAddressCity(mesto);
        checkoutPage.fillShippingAddressState(stat);
        checkoutPage.fillShippingAddressZipcode(psc);
        checkoutPage.fillShippingAddressPhone("112567");
        checkoutPage.selectDeliveryMethod(metoda);
        checkoutPage.selectPaymentMethod();
        
        Thread.sleep(2000);
        boolean isError = checkoutPage.findErrors().size() >= 1;

        assertTrue("Log message: Field(s) are invalid:" + checkoutPage.findErrors().toString(), (expected==isError));

    }

}
