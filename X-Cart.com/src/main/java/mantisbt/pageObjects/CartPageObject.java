/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mantisbt.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
public class CartPageObject {

    private final RemoteWebDriver driver;
    private final String baseUrl;

    public CartPageObject(String baseUrl, RemoteWebDriver driver) {

        this.baseUrl = baseUrl;
        this.driver = driver;
    }

    public void open() {
        System.out.println("BASE URL: " + baseUrl + "?target=cart");
        driver.get(baseUrl + "?target=cart");
        driver.manage().window().maximize();
        
    }
    
    public void checkout(){
        driver.findElement(By.cssSelector("button.btn.regular-button.regular-main-button.checkout")).click();
    }

    public void removeItem(){
        driver.findElement(By.cssSelector("a.remove.next-previous-assigned")).click();
    }

    public void changeQuantity(String newQuantity){
        driver.findElement(By.name("amount")).clear();
        driver.findElement(By.name("amount")).sendKeys(newQuantity);
    }
    
    public boolean isChangeOkay(String number){        
        String text = driver.findElement(By.id("page-title")).getText();        
        return text.contains(number);
    }
     public boolean isCartEmpty(){        
        String text = driver.findElement(By.id("page-title")).getText();        
        return text.contains("Your cart is empty");
    }
     
    public void continueShopping(){
        driver.findElement(By.cssSelector("button.btn.regular-button.action.continue")).click();
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
