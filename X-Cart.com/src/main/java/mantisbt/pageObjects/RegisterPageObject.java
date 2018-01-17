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
public class RegisterPageObject {

    private final RemoteWebDriver driver;
    private final String baseUrl;

    @FindBy(css = "#header-bar div:nth-of-type(3) button.btn.regular-button.popup-button.popup-login")
    @CacheLookup
    private WebElement signInsignUp;
    
    

    public RegisterPageObject(String baseUrl, RemoteWebDriver driver) {

        this.baseUrl = baseUrl;
        this.driver = driver;
    }

    public void open() {
        System.out.println("BASE URL: " + baseUrl);
        driver.get(baseUrl);
        driver.manage().window().maximize();
        signInsignUp.click();
        
        waitForElement(driver, By.cssSelector("a.popup-button.create-account-link"));
        
        driver.findElement(By.cssSelector("a.popup-button.create-account-link")).click();

    }
    
  

    public void setEmailTextField(String emailValue) {
        System.out.println("emailvalue: " + emailValue);
        waitForElement(driver, By.name("login"));
        driver.findElement(By.name("login")).clear();
        driver.findElement(By.name("login")).sendKeys(emailValue);

    }

    public void setPasswordField(String passwordValue) {
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(passwordValue);
    }

    public void setPasswordConfField(String passworConf){
        driver.findElement(By.name("password_conf")).clear();
        driver.findElement(By.name("password_conf")).sendKeys(passworConf);
    }
    
    public void clickSubmitButton() {
        WebDriverWait wait = new WebDriverWait (driver, 15);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Create')]")));
	driver.findElement(By.xpath("//span[contains(text(),'Create')]")).click();
        

    }
    
    public boolean isRequiredEmailMsgPresent(){
        return isElementPresent(By.cssSelector("div.table-value.login-value.table-value-required"));
    }
    
    public boolean isRequiredPasswordMsgPresent(){
        return isElementPresent(By.cssSelector("div.table-value.password-value.table-value-required"));
    }
    public boolean isRequiredPasswordConfMsgPresent(){
        return isElementPresent(By.cssSelector("div.table-value.password-conf-value.table-value-required"));
    }
    
    public boolean isErrorEmailMsgPresent(){
        
        return isElementPresent(By.cssSelector("p.error.inline-error"));
    }
    
    public boolean isErrorMsgPresent(){
        waitForElement(driver, By.cssSelector("li.error"));
        return isElementPresent(By.cssSelector("li.error"));
    }
    
    
     public boolean isRegistrationSuccessful() throws InterruptedException {
        Thread.sleep(1500); 
        return isElementPresent(By.xpath("/html/body/div[1]/div[1]/div[4]/div/div/div[2]/div/div/div[2]/div/div[3]/ul/li/div/div/button"));
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
