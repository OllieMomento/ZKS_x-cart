package test.mantisbt.recorded;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import mantisbt.pageObjects.RegisterPageObject;
import utils.CSVReader;
import org.apache.commons.io.FileUtils;
import static org.junit.Assert.assertTrue;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

/**
 *
 * @author BeryUncool
 */
//@RunWith(Parameterized.class)
public class RegistrationTestParametrized {
    
    @Parameterized.Parameters
    public static Collection<String[]> data() throws IOException {
        return null;
        // jak pridat resource soubor
        // New > Java Package
        // - Project Resources
        // objevi se ve stromu Other Sources 
        //return CSVReader.readCSVfileToCollection('');
    }

     

}
