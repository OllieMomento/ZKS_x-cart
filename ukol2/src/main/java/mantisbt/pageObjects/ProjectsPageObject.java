/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mantisbt.pageObjects;

/**
 *
 * @author Ollie's DESKTOP
 */
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectsPageObject {

    private final String baseUrl;

    private final WebDriver driver;

    public ProjectsPageObject(String baseUrl, WebDriver driver) {
        this.baseUrl = baseUrl;
        this.driver = driver;
    }
    
    public void open() {        
        driver.get(baseUrl);
    }
    
    public List<WebElement> getProjects() {
        List<WebElement> projects = driver.findElements(By.cssSelector("#projects-index ul.projects div.root a.project")); 
        return projects;
    }
    
}