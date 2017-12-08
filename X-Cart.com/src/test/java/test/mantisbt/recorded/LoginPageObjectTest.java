package test.mantisbt.recorded;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import mantisbt.pageObjects.LoginPageObject;

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
public class LoginPageObjectTest {

    private RemoteWebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private final StringBuffer verificationErrors = new StringBuffer();
    private LoginPageObject loginPage;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
        driver = new FirefoxDriver();
        baseUrl = "https://demostore.x-cart.com/";
        // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        loginPage = new LoginPageObject(baseUrl, driver);
        PageFactory.initElements(driver, loginPage);

    }

    @Test
    public void testLoginWithInvalidCredentials() throws Exception {      

        loginPage.open();
        String email = "joe@doe.com";
        String password = "joeking";

        loginPage.setEmailTextField(email);
        loginPage.setPasswordField(password);
        loginPage.clickLoginButton();

        assertTrue("Log message: correct username and password", loginPage.errorDivIsPresent() && loginPage.errorTextIsPresent());

    }
    
    public void testLoginWithValidCredentials() throws Exception {      

        loginPage.open();
        String email = "franta@pepa.com";
        String password = "franta";

        loginPage.setEmailTextField(email);
        loginPage.setPasswordField(password);
        loginPage.clickLoginButton();

        assertTrue("Log message: incorrect username and password", !loginPage.errorDivIsPresent() && !loginPage.errorTextIsPresent());

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
