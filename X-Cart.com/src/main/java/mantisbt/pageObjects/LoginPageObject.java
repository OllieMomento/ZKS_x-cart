/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mantisbt.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author BeryUncool
 */
public class LoginPageObject {

    private final RemoteWebDriver driver;
    private final String baseUrl;

    @FindBy(css = "#header-bar div:nth-of-type(3) button.btn.regular-button.popup-button.popup-login")
    @CacheLookup
    private WebElement signInsignUp;

    public LoginPageObject(String baseUrl, RemoteWebDriver driver) {

        this.baseUrl = baseUrl;
        this.driver = driver;
    }

    public void open() {
        System.out.println("BASE URL: " + baseUrl);
        driver.get(baseUrl);
        driver.manage().window().maximize();
        signInsignUp.click();

    }

    public void setEmailTextField(String emailValue) {
        System.out.println("emailvalue: " + emailValue);
        waitForElement(driver, By.name("login"));
        driver.findElement(By.name("login")).sendKeys(emailValue);

    }

    public void setPasswordField(String passwordValue) {
        driver.findElement(By.id("login-password")).sendKeys(passwordValue);
    }

    public void clickLoginButton() {
        driver.findElement(By.cssSelector("td button.btn.regular-button.submit")).click();

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
