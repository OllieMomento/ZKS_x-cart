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
        /*TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        
        //testng.setTestClasses(new Class[]{CartPageObjectTest.class, LoginPageObjectTest.class, HomePageObjectTest.class, RegisterPageObjectTest.class, CheckoutPageObjectTest.class});
        //testng.setTestClasses(new Class[]{RegisterPageObjectTest.class});
        
        List<String> metody = new ArrayList<String>();
                //Arrays.asList("testRegisterWithValidCredentials", "testBrowseItem", "testSearchItem");
        metody.add("testRegisterWithValidCredentials");
        testng.setTestNames(metody);
        testng.addListener(tla);
        testng.run();*/

        XmlSuite suite = new XmlSuite();
        suite.setName("TmpSuite");

        XmlTest test = new XmlTest(suite);
        test.setName("TmpTest");
        List<XmlClass> classes = new ArrayList<XmlClass>();
        //RegisterPageObjectTEst
        XmlClass Register = new XmlClass("test.mantisbt.recorded.RegisterPageObjectTest");
        List<XmlInclude> methods = new ArrayList<XmlInclude>();
        XmlInclude registerValid = new XmlInclude("testRegisterWithValidCredentials");
        methods.add(registerValid);                
        Register.setIncludedMethods(methods);
        
        //RegisterPageObjectTEst
        XmlClass HomePage = new XmlClass("test.mantisbt.recorded.HomePageObjectTest");
        methods = new ArrayList<XmlInclude>();
        methods.add(new XmlInclude("testBrowseItem"));  
        methods.add(new XmlInclude("testSearchItemAndAddToCart"));  
        methods.add(new XmlInclude("testBrowseItemAndAddToCart")); 
        HomePage.setIncludedMethods(methods);
        
        
        //CheckoutPageObjectTEst
        /*XmlClass CheckoutPage = new XmlClass("test.mantisbt.recorded.CheckoutPageObjectTest");
        methods = new ArrayList<XmlInclude>();
        methods.add(new XmlInclude("testBrowseItem"));  
        methods.add(new XmlInclude("testSearchItemAndAddToCart"));  
        methods.add(new XmlInclude("testBrowseItemAndAddToCart")); 
        CheckoutPage.setIncludedMethods(methods);*/
        
        classes.add(Register);
        classes.add(HomePage);
        //classes.add(CheckoutPage);
        test.setXmlClasses(classes);

        List<XmlSuite> suites = new ArrayList<XmlSuite>();
        suites.add(suite);
        TestNG tng = new TestNG();
        tng.setXmlSuites(suites);
        tng.run();

    }
}
