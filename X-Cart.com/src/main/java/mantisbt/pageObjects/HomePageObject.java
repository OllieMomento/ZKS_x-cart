/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mantisbt.pageObjects;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author BeryUncool
 */
public class HomePageObject {

    private final RemoteWebDriver driver;
    private final String baseUrl;

    public HomePageObject(String baseUrl, RemoteWebDriver driver) {

        this.baseUrl = baseUrl;
        this.driver = driver;
    }

    public void open() {
        System.out.println("BASE URL: " + baseUrl);
        driver.get(baseUrl);
        driver.manage().window().maximize();

    }

    public void browseItemAndView(String item) {
        driver.findElement(By.cssSelector("a[href*=" + item + "]")).click();
    }

    public void browseItemAndAddToCart(String item) {
        Actions actions = new Actions(driver);
        WebElement hoverElement = driver.findElement(By.cssSelector("a[href*=" + item + "]"));
        String code = "window.scroll(" + (hoverElement.getLocation().x + 0) + ","
                                 + (hoverElement.getLocation().y - 100) + ");";
        
        ((JavascriptExecutor) driver).executeScript(code, hoverElement);
        actions.moveToElement(hoverElement);
        actions.build();
        actions.perform();
                
        driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]")).click();
       
    }

    public void searchItem(String item) {
        driver.findElement(By.name("substring")).sendKeys(item);
        driver.findElement(By.cssSelector("button.btn.regular-button.submit-button.submit")).click();
    }

    private void waitForElement(RemoteWebDriver driver, final By by) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 10);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.findElement(by).isDisplayed();
            }
        });
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
