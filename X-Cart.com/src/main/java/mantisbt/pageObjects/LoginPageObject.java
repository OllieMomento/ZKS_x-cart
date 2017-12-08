/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mantisbt.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author BeryUncool
 */
public class LoginPageObject {

    private final WebDriver driver;
    private final String baseUrl;
    
    @FindBy(name = "btn  regular-button  popup-button popup-login")
    @CacheLookup
    private WebElement login;

    public LoginPageObject(String baseUrl, WebDriver driver) {

        this.baseUrl = baseUrl;
        this.driver = driver;
    }

    public void open() {
        System.out.println("BASE URL: " + baseUrl);
        driver.get(baseUrl);
        login.click();
        
    }


}
