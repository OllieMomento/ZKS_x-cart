package test.mantisbt.recorded;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import mantisbt.pageObjects.LoginPageObjectGen;
import org.apache.commons.io.FileUtils;
import static org.junit.Assert.assertTrue;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;

public class LoginPageObjectTest {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private final StringBuffer verificationErrors = new StringBuffer();
    private LoginPageObjectGen loginPage;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Ollie\\Google Drive\\HCI\\3.semestr\\ZKS\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        baseUrl = "http://demo.redmine.org";
        // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        loginPage = new LoginPageObjectGen(baseUrl, driver);

    }

    @Test
    public void testLoginWithInvalidCredentials() throws Exception {
        PageFactory.initElements(driver, loginPage);

        loginPage.open();
        String name = "chvilond";
        loginPage.setLoginTextField(name);
        loginPage.setPasswordPasswordField("spatneHeslo");
        loginPage.clickLoginButton();

        //use findElements instead of findElement. findElements will return an empty list if no matching elements are found instead of an exception.
        Boolean errorDivIsPresent = driver.findElements(By.id("flash_error")).size() > 0;

        Boolean notLoggedIn = driver.findElements(By.id("loggedas")).isEmpty();

        assertTrue("Log message: incorrect username or password", errorDivIsPresent && notLoggedIn);

    }

    @Test
    public void testLoginWithValidCredentials() throws Exception {
        PageFactory.initElements(driver, loginPage);

        
        loginPage.open();
        String name = "chvilond";
        loginPage.setLoginTextField(name);
        loginPage.setPasswordPasswordField("a12345678");
        loginPage.clickLoginButton();

        WebElement loginDiv = driver.findElement(By.id("loggedas"));
        Boolean logginStatus = false;
        if (loginDiv.getText().contains("Logged in as " + name)) {
            logginStatus = true;
        }

        assertTrue("Log message: login wasn't succesful", logginStatus);

        driver.findElement(By.className("logout")).click();

    }

}
