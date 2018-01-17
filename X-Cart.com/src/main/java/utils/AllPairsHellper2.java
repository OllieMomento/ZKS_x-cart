/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Iterator;

/**
 *
 * @author BeryUncool
 */
public class AllPairsHellper2 {
    Object[][] data;
    public AllPairsHellper2() {
        data = CSVReader.readCSVfile("/resources/checkout_out.csv");
    }
    
    public Object[][] getData(){
        return data = new Object[][]{
            {"Jakub", "Chvila", "Horni", "Dolni", "CZ","",  "18200", "Courier", "4532180078920420","12","19",  false}, //
            {"", "Chvila", "", "", "US", "CA", "90001","Local shipping", "4532180078920420","50","12",  true}, //
            {"Jakub", "Chvila", "Horni", "Dolni", "UA","", "", "Local pickup", "5189053872937220","12","12",  true}, //
            {"Jakub", "", "", "Dolni", "US","CA", "90001", "Local shipping", "5189053872937220","50","19",  true}, //
            {"", "Chvila", "Horni", "Dolni", "UA","", "", "Courier", "346452700619311","50","19",  true}
            
        };
    }
}
