package test.mantisbt.recorded;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import mantisbt.pageObjects.RegisterPageObject;
import utils.AllPairsHellperObject;
import org.apache.commons.io.FileUtils;
import static org.junit.Assert.assertTrue;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.testng.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

/**
 *
 * @author BeryUncool
 */
public class RegisterPageObjectTest {

    private RemoteWebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private final StringBuffer verificationErrors = new StringBuffer();
    private RegisterPageObject registerPage;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
        //System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        driver = new FirefoxDriver();
        //driver = new ChromeDriver();
        baseUrl = "https://demostore.x-cart.com/";
        // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        registerPage = new RegisterPageObject(baseUrl, driver);
    }

    @DataProvider(name = "test1")
    public static Object[][] data() {
        AllPairsHellperObject allPairsObject=  new AllPairsHellperObject();
        return allPairsObject.getData();
    }

    @Test(dataProvider = "test1")
    public void testRegisterParametrized(String email, String password, String passworconfirm, boolean expectedResult) throws Exception {
        PageFactory.initElements(driver, registerPage);
        registerPage.open();
        registerPage.setEmailTextField(email);
        registerPage.setPasswordField(password);
        registerPage.setPasswordConfField(passworconfirm);
        registerPage.clickSubmitButton();
        assertEquals(!registerPage.isErrorEmailMsgPresent(), expectedResult);
        
    }
    
    @Test
    public void testRegisterWithInvalidEmail() throws Exception {
        PageFactory.initElements(driver, registerPage);
        registerPage.open();
        registerPage.setEmailTextField("badformatEmail");
        registerPage.setPasswordField("123456");
        registerPage.setPasswordConfField("123456");
        registerPage.clickSubmitButton();
        assertTrue(registerPage.isErrorEmailMsgPresent());
    }
    @Test
    public void testRegisterNotMatchingPasswords() throws Exception {
        PageFactory.initElements(driver, registerPage);
        registerPage.open();
        registerPage.setEmailTextField("asko@gmail.com");
        registerPage.setPasswordField("123456");
        registerPage.setPasswordConfField("123");
        registerPage.clickSubmitButton();
        assertTrue("Registration successfull, but it should not",registerPage.isErrorMsgPresent());
    }

    @Test
    public void testRegisterWithValidCredentials() throws Exception {
        PageFactory.initElements(driver, registerPage);
        registerPage.open();
        registerPage.setEmailTextField("jojo@gmail.com");
        registerPage.setPasswordField("123456");
        registerPage.setPasswordConfField("123456");
        registerPage.clickSubmitButton();
        Thread.sleep(1500);
        assertTrue("Not registerd", registerPage.isRegistrationSuccessful());
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
