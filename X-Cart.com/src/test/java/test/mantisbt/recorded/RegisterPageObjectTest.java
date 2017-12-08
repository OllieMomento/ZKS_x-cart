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

import org.apache.commons.io.FileUtils;
import static org.junit.Assert.assertTrue;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
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
        driver = new FirefoxDriver();
        baseUrl = "https://demostore.x-cart.com/";
        // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        registerPage = new RegisterPageObject(baseUrl, driver);
        
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
    public void testRegisterWithNotMatchingPasswords() throws Exception{
        PageFactory.initElements(driver, registerPage);
        registerPage.open();
        registerPage.setEmailTextField("email@gmail.com");
        registerPage.setPasswordField("123456");
        registerPage.setPasswordConfField("differentPassword");
        registerPage.clickSubmitButton();
        assertTrue(registerPage.isErrorMsgPresent());
        
    }
   
    
    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
