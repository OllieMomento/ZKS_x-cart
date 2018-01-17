/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.mantisbt.recorded;

import java.util.ArrayList;
import java.util.List;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

/**
 *
 * @author BeryUncool
 */
public class TestCase {

    @Test
    public void testScenario1() {

        XmlSuite suite = new XmlSuite();
        suite.setName("TmpSuite");

        XmlTest test = new XmlTest(suite);
        test.setName("TmpTest");
        List<XmlClass> classes = new ArrayList<XmlClass>();
        //RegisterPageObjectTEst
        XmlClass Register = new XmlClass("test.mantisbt.recorded.RegisterPageObjectTest");
        List<XmlInclude> methods = new ArrayList<XmlInclude>();
        methods.add(new XmlInclude("testRegisterNotMatchingPasswords"));
        methods.add(new XmlInclude("testRegisterWithValidCredentials"));                
        Register.setIncludedMethods(methods);
        
        //RegisterPageObjectTEst
        XmlClass HomePage = new XmlClass("test.mantisbt.recorded.HomePageObjectTest");
        methods = new ArrayList<XmlInclude>();
        methods.add(new XmlInclude("testBrowseItem"));  
        methods.add(new XmlInclude("testSearchItem"));  
        methods.add(new XmlInclude("testBrowseItemAndAddToCart")); 
        HomePage.setIncludedMethods(methods);
        
        //CheckoutPageObjectTEst
        XmlClass CheckoutPage = new XmlClass("test.mantisbt.recorded.CheckoutPageObjectTest");
        methods = new ArrayList<XmlInclude>();
        methods.add(new XmlInclude("testValidEmailAddressVAT"));  
        methods.add(new XmlInclude("testValidCreditCard"));  
        methods.add(new XmlInclude("testPurchase")); 
        CheckoutPage.setIncludedMethods(methods);
        
        classes.add(Register);
        classes.add(HomePage);
        classes.add(CheckoutPage);
        test.setXmlClasses(classes);

        List<XmlSuite> suites = new ArrayList<XmlSuite>();
        suites.add(suite);
        TestNG tng = new TestNG();
        tng.setXmlSuites(suites);
        tng.run();

    }
}
