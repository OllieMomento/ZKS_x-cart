/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author BeryUncool
 */
public class AllPairsHellperObject {

    Object[][] data;

    public AllPairsHellperObject() {
        data = new Object[][]{
            {"koko@gmail.com", "", "", false}, //1;ValidEmail;EmptyString;EmptyString
            {"koko@gmail.com", "123", "123", true}, //2;ValidEmail;ValidPassword;SameAsPassword
            {"", "123", "", false}, //3;EmptyString;ValidPassword;EmptyString
            {"", "", "", false},//4;EmptyString;EmptyString;SameAsPassword
            {"kokogmail.com", "", "aaa", false},//5;Without@;EmptyString;DifferentFromPassword
            {"kokogmail.com", "123", "", false},//6;Without@;ValidPassword;EmptyString
            {"koko@gmailcom", "123", "1234", false},//7;WithoutDot;ValidPassword;DifferentFromPassword
            {"koko@gmailcom", "", "", false},//8;WithoutDot;EmptyString;EmptyString;
            {"koko@gmail.com", "", "", false},//9;EmailAlreadyExists;EmptyString;SameAsPassword
            {"koko@gmail.com", "123", "1234", false},//10;EmailAlreadyExists;ValidPassword;DifferentFromPassword
            {"koko@.com", "123", "123", false},//11;NoDomainString;ValidPassword;SameAsPassword
            {"koko@.com", "", "123", false}, //12;NoDomainString;EmptyString;DifferentFromPassword
            {"@gmail.com", "", "", false}, //13;NoLocalString;EmptyString;EmptyString
            {"@gmail.com", "123", "123", false}, //14;NoLocalString;ValidPassword;SameAsPassword
            {"koko@gmailaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa.com", "", "", false}, //15;Over69Chars;ValidPassword;EmptyString
            {"koko@gmailaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa.com", "", "", false}, //16;Over69Chars;EmptyString;SameAsPassword
        };
        /*
1;ValidEmail;EmptyString;EmptyString;3
2;ValidEmail;ValidPassword;SameAsPassword;3
3;EmptyString;ValidPassword;EmptyString;3
4;EmptyString;EmptyString;SameAsPassword;3
5;Without@;EmptyString;DifferentFromPassword;3
6;Without@;ValidPassword;EmptyString;2
7;WithoutDot;ValidPassword;DifferentFromPassword;3
8;WithoutDot;EmptyString;EmptyString;2
9;EmailAlreadyExists;EmptyString;SameAsPassword;2
10;EmailAlreadyExists;ValidPassword;DifferentFromPassword;2
11;NoDomainString;ValidPassword;SameAsPassword;2
12;NoDomainString;EmptyString;DifferentFromPassword;2
13;NoLocalString;EmptyString;EmptyString;2
14;NoLocalString;ValidPassword;SameAsPassword;2
15;Over69Chars;ValidPassword;EmptyString;2
16;Over69Chars;EmptyString;SameAsPassword;2
         */
    }
    
    public Object[][] getData(){
        return this.data;
    }

}
