package mantisbt.pageObjects;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Wait;

public class LoginPageObjectGen {
    private Map<String, String> data;
    private final WebDriver driver;
    private final String baseUrl;
    private int timeout = 15;

    @FindBy(css = "a.help")
    @CacheLookup
    private WebElement help;

    @FindBy(css = "a.home")
    @CacheLookup
    private WebElement home;

    @FindBy(id = "username")
    @CacheLookup
    public WebElement username;

    @FindBy(name = "login")
    @CacheLookup
    private WebElement login;

    @FindBy(css = "a[href='/account/lost_password']")
    @CacheLookup
    private WebElement lostPassword;

    private final String pageLoadedText = "© 2006-2015 Jean-Philippe Lang";

    private final String pageUrl = "/login";

    @FindBy(id = "password")
    @CacheLookup
    private WebElement password;

    @FindBy(css = "a.projects")
    @CacheLookup
    private WebElement projects;

    @FindBy(css = "a[href='http://www.redmine.org/']")
    @CacheLookup
    private WebElement redmine;

    @FindBy(css = "a.register")
    @CacheLookup
    private WebElement register;

    @FindBy(css = "a[href='/search']")
    @CacheLookup
    private WebElement search1;

    @FindBy(id = "q")
    @CacheLookup
    private WebElement search2;

    @FindBy(css = "a.login")
    @CacheLookup
    private WebElement signIn;


    public LoginPageObjectGen(String baseUrl, WebDriver driver) {
        this.baseUrl = baseUrl + pageUrl; // plus /login
        this.driver = driver;
        
    }
    
    public void open() {
        System.out.println("BASE URL: " + baseUrl);
        driver.get(baseUrl);        
    }  

    /**
     * Click on Help Link.
     *
     * @return the LoginPageObjectGen class instance.
     */
    public LoginPageObjectGen clickHelpLink() {
        help.click();
        return this;
    }

    /**
     * Click on Home Link.
     *
     * @return the LoginPageObjectGen class instance.
     */
    public LoginPageObjectGen clickHomeLink() {
        home.click();
        return this;
    }

    /**
     * Click on Login Button.
     *
     * @return the LoginPageObjectGen class instance.
     */
    public LoginPageObjectGen clickLoginButton() {
        login.click();
        return this;
    }

    /**
     * Click on Lost Password Link.
     *
     * @return the LoginPageObjectGen class instance.
     */
    public LoginPageObjectGen clickLostPasswordLink() {
        lostPassword.click();
        return this;
    }

    /**
     * Click on Projects Link.
     *
     * @return the LoginPageObjectGen class instance.
     */
    public LoginPageObjectGen clickProjectsLink() {
        projects.click();
        return this;
    }

    /**
     * Click on Redmine Link.
     *
     * @return the LoginPageObjectGen class instance.
     */
    public LoginPageObjectGen clickRedmineLink() {
        redmine.click();
        return this;
    }

    /**
     * Click on Register Link.
     *
     * @return the LoginPageObjectGen class instance.
     */
    public LoginPageObjectGen clickRegisterLink() {
        register.click();
        return this;
    }

    /**
     * Click on Sign In Link.
     *
     * @return the LoginPageObjectGen class instance.
     */
    public LoginPageObjectGen clickSignInLink() {
        signIn.click();
        return this;
    }

    /**
     * Fill every fields in the page.
     *
     * @return the LoginPageObjectGen class instance.
     */
    public LoginPageObjectGen fill() {
        setSearch2TextField();
        setLoginTextField();
        setPasswordPasswordField();
        return this;
    }

    /**
     * Fill every fields in the page and submit it to target page.
     *
     * @return the LoginPageObjectGen class instance.
     */
    public LoginPageObjectGen fillAndSubmit() {
        fill();
        return submit();
    }

    /**
     * Set default value to Login Text field.
     *
     * @return the LoginPageObjectGen class instance.
     */
    public LoginPageObjectGen setLoginTextField() {
        return setLoginTextField(data.get("LOGIN"));
    }

    /**
     * Set value to Login Text field.
     *

     * @return the LoginPageObjectGen class instance.
     */
    public LoginPageObjectGen setLoginTextField(String loginValue) {
        username.sendKeys(loginValue);
        return this;
    }

    /**
     * Set default value to Password Password field.
     *
     * @return the LoginPageObjectGen class instance.
     */
    public LoginPageObjectGen setPasswordPasswordField() {
        return setPasswordPasswordField(data.get("PASSWORD"));
    }

    /**
     * Set value to Password Password field.
     *
     * @return the LoginPageObjectGen class instance.
     */
    public LoginPageObjectGen setPasswordPasswordField(String passwordValue) {
        password.sendKeys(passwordValue);
        return this;
    }

    /**
     * Set default value to Search Text field.
     *
     * @return the LoginPageObjectGen class instance.
     */
    public LoginPageObjectGen setSearch1TextField() {
        return setSearch1TextField(data.get("SEARCH_1"));
    }

    /**
     * Set value to Search Text field.
     *
     * @return the LoginPageObjectGen class instance.
     */
    public LoginPageObjectGen setSearch1TextField(String search1Value) {
        search1.click();
        return this;
    }

    /**
     * Set default value to Search Text field.
     *
     * @return the LoginPageObjectGen class instance.
     */
    public LoginPageObjectGen setSearch2TextField() {
        return setSearch2TextField(data.get("SEARCH_2"));
    }

    /**
     * Set value to Search Text field.
     *
     * @return the LoginPageObjectGen class instance.
     */
    public LoginPageObjectGen setSearch2TextField(String search2Value) {
        search2.sendKeys(search2Value);
        return this;
    }

    /**
     * Submit the form to target page.
     *
     * @return the LoginPageObjectGen class instance.
     */
    public LoginPageObjectGen submit() {
        clickLoginButton();
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the LoginPageObjectGen class instance.
     */
    public LoginPageObjectGen verifyPageLoaded() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getPageSource().contains(pageLoadedText);
            }
        });
        return this;
    }

    /**
     * Verify that current page URL matches the expected URL.
     *
     * @return the LoginPageObjectGen class instance.
     */
    public LoginPageObjectGen verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }
}
