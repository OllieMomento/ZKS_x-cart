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

/**
 *
 * @author BeryUncool
 */
public class TestCase {
    @Test
    public void test(){
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[]{CartPageObjectTest.class});
        List<String> metody = new ArrayList<String>();
        metody.add("testAddItem");
        metody.add("testRemoveItem");
        testng.setTestNames(metody);
        testng.addListener(tla);
        testng.run();

    }
}
