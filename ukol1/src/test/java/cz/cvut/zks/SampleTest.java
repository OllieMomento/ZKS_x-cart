/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.zks;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author Karel
 */
public class SampleTest {

    private static FirefoxDriver driver;
    private static String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    public SampleTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        // https://github.com/mozilla/geckodriver
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Ollie's DESKTOP\\Google Drive\\HCI\\3.semestr\\ZKS\\cviko\\geckodriver-v0.19.0-win64\\geckodriver.exe");

        driver = new FirefoxDriver();
        baseUrl = "http://demo.redmine.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
        if (verificationErrors.length() > 0) {
            fail(verificationErrors.toString());
        }
    }

    @Test
    public void hello() {
        //setup
        //act
        driver.get(baseUrl);
        //assert
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
