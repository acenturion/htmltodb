/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import htmlToDb.getDataFromHtml;

/**
 *
 * @author Minimal
 */
public class testOficial {
    public static void main(String[] args) throws Exception {
        getDataFromHtml caca = new getDataFromHtml();
        
        caca.getData("file:///C:/Users/acenturion/Desktop/regresion001.html");
        caca.getInfoTable("file:///C:/Users/acenturion/Desktop/regresion001.html");
    }
}
