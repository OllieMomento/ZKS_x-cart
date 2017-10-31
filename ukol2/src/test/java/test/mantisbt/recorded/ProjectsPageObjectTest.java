/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.mantisbt.recorded;

/**
 *
 * @author Ollie's DESKTOP
 */
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import mantisbt.pageObjects.LoginPageObjectGen;
import mantisbt.pageObjects.ProjectsPageObject;
import org.apache.commons.io.FileUtils;
import static org.junit.Assert.assertTrue;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertTrue;

public class ProjectsPageObjectTest {

    private WebDriver driver;
    private String baseUrl;

    private ProjectsPageObject projectsPage;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Ollie\\Google Drive\\HCI\\3.semestr\\ZKS\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        baseUrl = "http://demo.redmine.org/projects";
        // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        projectsPage = new ProjectsPageObject(baseUrl, driver);

        PageFactory.initElements(driver, projectsPage);
    }

    @Test
    public void testThirdProjectName() throws Exception {

        projectsPage.open();      
        
        
        List<WebElement> projects = projectsPage.getProjects();
        WebElement thirdElement = projects.get(2);
        String name = thirdElement.getText();
      

        thirdElement.click();
        WebElement h1 = driver.findElement(By.cssSelector("h1"));
        assertEquals(name, h1.getText());
        /*
        // najdu element s projektem na 3.pozici
            ProjectElement projectElement = projectListPage.getProjectElements().item(2);
            assertEquals("ADRIN project management", projectElement.getProjectName());
            projectElement.gotoProjectPage(); // nebo open() prejde na stranku projektu
         */
    }
   
}
