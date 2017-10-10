package cz.cvut.zks;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

//Be careful in splitting the test code to individual @Tests:
//an execution plan of Tests is not guaranteed by default
//We need to use @FixMethodOrder(MethodSorters.{NAME_ASCENDING}) above unit test class declaration
//http://junit.org/apidocs/index.html?org/junit/runners/MethodSorters.html
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestProstredi {

    static RemoteWebDriver driver;

    @BeforeClass
    public static void beforeClass() {
        // System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        // driver = new ChromeDriver();
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Ollie's DESKTOP\\Google Drive\\HCI\\3.semestr\\ZKS\\cviko\\geckodriver-v0.19.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @AfterClass
    public static void afterClass() {
        //Pause.pause(2);	
        driver.quit();
    }

    @Test
    public void step1_loginFailed() {
        
        driver.get("http://demo.redmine.org");
        driver.findElement(By.className("login")).click();

        String name = "chvilond";

        waitForElement(driver, By.id("username")); //driver ceka az se zobrazi element ktery ma jako id username
        driver.findElement(By.id("username")).sendKeys(name);
        driver.findElement(By.id("password")).sendKeys("spatneheslo");
        driver.findElement(By.name("login")).click();
        
        //use findElements instead of findElement. findElements will return an empty list if no matching elements are found instead of an exception.
        Boolean errorDivIsPresent = driver.findElements(By.id("flash_error")).size() > 0;   
        
        Boolean notLoggedIn = driver.findElements(By.id("loggedas")).isEmpty();  
        

        assertTrue("Log message: incorrect username or password", errorDivIsPresent && notLoggedIn);
    }

    @Test
    public void step2_loginPassed() {
        driver.get("http://demo.redmine.org");
        driver.findElement(By.className("login")).click();

        String name = "chvilond";

        waitForElement(driver, By.id("username")); //driver ceka az se zobrazi element ktery ma jako id username
        driver.findElement(By.id("username")).sendKeys(name);
        driver.findElement(By.id("password")).sendKeys("a12345678");
        driver.findElement(By.name("login")).click();

        WebElement loginDiv = driver.findElement(By.id("loggedas"));
        Boolean logginStatus = false;
        if (loginDiv.getText().contains("Logged in as " + name)) {
            logginStatus = true;
        }

        assertTrue("Log message: login was succesful", logginStatus);
    }

    @Test
    public void step3_projectTest() {
        // FIND TESTING PROJECT
        driver.findElement(By.linkText("Projects")).click();
        driver.findElement(By.linkText("FreshVeggy")).click();

        // CHECK NUMBER OF BUGS
        WebElement bugsLinkElement = driver.findElement(By.linkText("Bug"));
        WebElement bugsStatsElement = bugsLinkElement.findElement(By.xpath("parent::node()"));
        String bugsStatusString = bugsStatsElement.getText();
        String totalBugsCount = bugsStatusString.substring(bugsStatusString.indexOf("/") + 1).trim();
        int totalBugsCountNumber = (new Integer(totalBugsCount)).intValue();

        // JUnit style assert
        assertTrue("Log message: totalBugsCountNumber is less than 10", totalBugsCountNumber < 10);

        //fail();
    }

    // try to set alwaysRun false and fail previous test
    //@Test (dependsOnMethods={"projectTest"})
    @Test
    public void step4_logoutTest() {
        // LOG OUT
        //Log.log("executing logout");
        driver.findElement(By.linkText("Sign out")).click();
        Boolean logoutSuccessful = driver.findElements(By.id("loggedas")).isEmpty();
        assertTrue("Log message: logout was succesful", logoutSuccessful);
        
    }

    private void waitForElement(RemoteWebDriver driver, final By by) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 10);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.findElement(by).isDisplayed();
            }
        });
    }

}
