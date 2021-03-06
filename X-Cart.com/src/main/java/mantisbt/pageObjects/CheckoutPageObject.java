/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mantisbt.pageObjects;

import java.util.ArrayList;
import java.util.List;
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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author BeryUncool
 */
public class CheckoutPageObject {

    private final RemoteWebDriver driver;
    private final String baseUrl;

    @FindBy(css = "input#card_number")
    private WebElement creditCard;

    public CheckoutPageObject(String baseUrl, RemoteWebDriver driver) {
        this.baseUrl = baseUrl + "?target=checkout";
        this.driver = driver;
    }

    public void open() {
        System.out.println("BASE URL: " + baseUrl);
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

    public void checkAccountForLaterUse() {
        driver.findElement(By.name("create-profile")).click();
    }

    public void checkSameAsShippingAddress() {
        driver.findElement(By.name("same_address")).click();
    }

    public void fillEmail(String emailValue) {
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(emailValue);
    }

    public void fillPassword(String password) {
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(password);
    }

    public void fillShippingAddressFirstName(String firstName) {
        driver.findElement(By.name("shippingAddress[firstname]")).clear();
        driver.findElement(By.name("shippingAddress[firstname]")).sendKeys(firstName);
    }

    public void fillShippingAddressLastName(String lastName) {
        driver.findElement(By.name("shippingAddress[lastname]")).clear();
        driver.findElement(By.name("shippingAddress[lastname]")).sendKeys(lastName);
    }

    public void fillShippingAddressStreet(String street) {
        driver.findElement(By.name("shippingAddress[street]")).clear();
        driver.findElement(By.name("shippingAddress[street]")).sendKeys(street);
    }

    public void fillShippingAddressCity(String city) {
        driver.findElement(By.name("shippingAddress[city]")).clear();
        driver.findElement(By.name("shippingAddress[city]")).sendKeys(city);
    }

    public void fillShippingAddressState(String state) {
        driver.findElement(By.name("shippingAddress[custom_state]")).clear();
        driver.findElement(By.name("shippingAddress[custom_state]")).sendKeys(state);
    }

    public void fillShippingAddressZipcode(String zipcode) {
        driver.findElement(By.name("shippingAddress[zipcode]")).clear();
        driver.findElement(By.name("shippingAddress[zipcode]")).sendKeys(zipcode);
    }

    public void fillShippingAddressPhone(String phone) {
        driver.findElement(By.name("shippingAddress[phone]")).clear();
        driver.findElement(By.name("shippingAddress[phone]")).sendKeys(phone);
    }

    public void fillBillingAddressFirstName(String firstName) {
        driver.findElement(By.name("billingAddress[firstname]")).clear();
        driver.findElement(By.name("billingAddress[firstname]")).sendKeys(firstName);
    }

    public void fillBillingAddressLastName(String lastName) {
        driver.findElement(By.name("billingAddress[lastname]")).clear();
        driver.findElement(By.name("billingAddress[lastname]")).sendKeys(lastName);
    }

    public void fillBillingAddressStreet(String street) {
        driver.findElement(By.name("billingAddress[street]")).clear();
        driver.findElement(By.name("billingAddress[street]")).sendKeys(street);
    }

    public void fillBillingAddressCity(String city) {
        driver.findElement(By.name("billingAddress[city]")).clear();
        driver.findElement(By.name("billingAddress[city]")).sendKeys(city);
    }

    public void fillBillingAddressState(String state) {
        driver.findElement(By.name("billingAddress[custom_state]")).clear();
        driver.findElement(By.name("billingAddress[custom_state]")).sendKeys(state);
    }

    public void fillBillingAddressZipcode(String zipcode) {
        driver.findElement(By.name("billingAddress[zipcode]")).clear();
        driver.findElement(By.name("billingAddress[zipcode]")).sendKeys(zipcode);
    }

    public void fillBillingAddressPhone(String phone) {
        driver.findElement(By.name("billingAddress[phone]")).clear();
        driver.findElement(By.name("billingAddress[phone]")).sendKeys(phone);
    }

    public void fillBillingAddressVAT(String VAT) {
        driver.findElement(By.name("billingAddress[vat_number]")).clear();
        driver.findElement(By.name("billingAddress[vat_number]")).sendKeys(VAT);
    }

    public void fillShippingAddressVAT(String VAT) {
        driver.findElement(By.name("shippingAddress[vat_number]")).sendKeys(VAT);
    }

    public void selectShippingAddresCountry(String country) {
        new Select(driver.findElement(By.name("shippingAddress[country_code]"))).selectByValue(country);
    }

    public void selectBillingAddresCountry(String country) {
        new Select(driver.findElement(By.name("billingAddress[country_code]"))).selectByValue(country);
    }

    public void selectDeliveryMethod(String method) {
        if (method.equals("Courier")) {

            driver.findElement(By.id("method5")).click();

        } else if (method.equals("Local shipping")) {

            driver.findElement(By.id("method6")).click();

        } else if (method.equals("Local pickup")) {

            driver.findElement(By.id("method8")).click();
        }
    }

    public void selectPaymentMethod() {
        driver.findElement(By.id("pmethod23")).click();
    }

    public void fillCreditCardNumber(String cardNumber) {
       //driver.findElement(By.id("card_number")).clear();
       //driver.findElement(By.id("card_number")).sendKeys(cardNumber);
       //Actions actions = new Actions(driver);
        /*String code = "$('#card_number').val("+cardNumber+");";
        WebElement we = driver.findElement(By.id("card_number"));*/
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("console.log(document.getElementById('card_number').value);");
        
    }

    public void fillCreditCardExpireMonth(String expireMonth) {
        driver.findElement(By.name("posted_data[card_expire_month]")).clear();
        driver.findElement(By.name("posted_data[card_expire_month]")).sendKeys(expireMonth);
    }

    public void fillCreditCardExpireYear(String expireYear) {
        driver.findElement(By.name("posted_data[card_expire_year]")).clear();
        driver.findElement(By.name("posted_data[card_expire_year]")).sendKeys(expireYear);
    }

    public void fillCreditCardCVV2(String CVV2) {
        driver.findElement(By.name("posted_data[card_cvv2]")).clear();
        driver.findElement(By.name("posted_data[card_cvv2]")).sendKeys(CVV2);
    }

    public void fillCreditCardName(String name) {

        driver.findElement(By.name("posted_data[card_name]")).clear();
        driver.findElement(By.name("posted_data[card_name]")).sendKeys(name);
    }

    public void placeOrder() {
        
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/div/div/div/div/div/div[2]/div/div/div/div[2]/div[2]/form/div[4]/button")).click();
    }

    public boolean isOrderOkay() throws InterruptedException {
        String text1 = "Thank you";
        waitForElement(driver, By.className("invoice"));
        
        return isElementPresent(By.className("invoice"));
    }

    public List<String> findErrors() {
        List<WebElement> Elements = driver.findElements(By.tagName("li"));
        List<String> errors = new ArrayList<>();
        for (int i = 0; i < Elements.size(); i++) {
            if (Elements.get(i).getAttribute("class").contains("error")) {
                errors.add(Elements.get(i).getAttribute("class"));
            }
        }
        return errors;
    }

    private void waitForElement(RemoteWebDriver driver, final By by) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 10);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.findElement(by).isDisplayed();
            }
        });
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
